package com.learn.spring.modultih.entry;

import com.learn.spring.modultih.event.VehicleExitedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExitService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void vehicleExit(String vehicleNumber) {
        ParkingEntry entry = parkingEntryRepository
                .findByVehicleNumberAndActiveTrue(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("No vehicle entry"));
        entry.setExitTime(LocalDateTime.now());
        entry.setActive(false);
        parkingEntryRepository.save(entry);
        eventPublisher.publishEvent(new VehicleExitedEvent(vehicleNumber, entry.getExitTime()));

    }
}
