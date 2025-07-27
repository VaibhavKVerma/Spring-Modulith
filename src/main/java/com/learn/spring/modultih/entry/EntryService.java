package com.learn.spring.modultih.entry;

import com.learn.spring.modultih.allocation.SlotAllocationService;
import com.learn.spring.modultih.event.VehicleEnteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final SlotAllocationService slotAllocationService;

    public void vehicleEntry(String vehicleNumber) {
        ParkingEntry existingEntry = parkingEntryRepository.findByVehicleNumberAndActiveTrue(vehicleNumber).orElse(null);
        if(existingEntry != null) {
            throw new RuntimeException("Vehicle already exists");
        }
        if(slotAllocationService.getNextAvailableSlot() == null) {
            throw new RuntimeException("No slots available!");
        }
        ParkingEntry parkingEntry = new ParkingEntry(null, vehicleNumber, LocalDateTime.now(), null, true);
        parkingEntryRepository.save(parkingEntry);
        eventPublisher.publishEvent(new VehicleEnteredEvent(vehicleNumber, parkingEntry.getEntryTime()));
    }
}
