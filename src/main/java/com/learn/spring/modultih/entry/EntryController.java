package com.learn.spring.modultih.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/entry")
public class EntryController {
    private final EntryService entryService;

    @PostMapping("/{vehicleNumber}")
    ResponseEntity<ParkingEntry> createEntry(@PathVariable String vehicleNumber) {
        entryService.vehicleEntry(vehicleNumber);
        return ResponseEntity.accepted().build();
    }

}
