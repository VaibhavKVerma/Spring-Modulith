package com.learn.spring.modultih.entry;

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

    public void vehicleEntry(String vehicleNumber) {
        ParkingEntry parkingEntry = new ParkingEntry(null, vehicleNumber, LocalDateTime.now(), null, true);
        parkingEntryRepository.save(parkingEntry);
        eventPublisher.publishEvent(new VehicleEnteredEvent(vehicleNumber, parkingEntry.getEntryTime()));
    }
}
