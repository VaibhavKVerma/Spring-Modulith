package com.learn.spring.modultih.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/exit")
public class ExitController {
    private final ExitService exitService;

    @PostMapping("/{vehicleNumber}")
    ResponseEntity<ParkingEntry> createEntry(@PathVariable String vehicleNumber) {
        exitService.vehicleExit(vehicleNumber);
        return ResponseEntity.ok().build();
    }

}
