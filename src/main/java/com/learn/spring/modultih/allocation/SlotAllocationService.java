package com.learn.spring.modultih.allocation;

import com.learn.spring.modultih.event.VehicleEnteredEvent;
import com.learn.spring.modultih.event.VehicleExitedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotAllocationService {
    private final SlotRepository slotRepository;

    @EventListener
    public void handleVehicleEntry(VehicleEnteredEvent event) {
        Slot slot = slotRepository.findFirstByAvailableTrue().orElseThrow(() -> new RuntimeException("No slots available!"));
        slot.setAvailable(false);
        slot.setVehicleNumber(event.vehicleNumber());
        slotRepository.save(slot);
        System.out.println("Slot allocated : " + slot.getSlotCode() + " by vehicle : " + slot.getVehicleNumber());
    }

    @EventListener
    public void handleVehicleExit(VehicleExitedEvent event) {
        Slot slot = slotRepository
                .findByVehicleNumberAndAvailableFalse(event.vehicleNumber())
                .orElseThrow(() -> new RuntimeException("No slots"));

        slot.setVehicleNumber(null);
        slot.setAvailable(true);
        slotRepository.save(slot);
        System.out.println("Slot is free : " + slot.getSlotCode());
    }

    public Slot getNextAvailableSlot() {
        return slotRepository.findFirstByAvailableTrue().orElseThrow(() -> new RuntimeException("No slots available!"));
    }
}
