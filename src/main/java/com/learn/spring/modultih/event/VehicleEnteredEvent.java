package com.learn.spring.modultih.event;

import java.time.LocalDateTime;

public record VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {
}
