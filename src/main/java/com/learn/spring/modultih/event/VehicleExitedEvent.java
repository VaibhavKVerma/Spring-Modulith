package com.learn.spring.modultih.event;

import java.time.LocalDateTime;

public record VehicleExitedEvent(String vehicleNumber, LocalDateTime exitTime) {
}
