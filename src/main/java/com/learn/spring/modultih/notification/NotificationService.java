package com.learn.spring.modultih.notification;

import com.learn.spring.modultih.event.VehicleEnteredEvent;
import com.learn.spring.modultih.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Async("asyncExecutor")
@Service
public class NotificationService {
    @EventListener
    public void notifyOnVehicleEntry(VehicleEnteredEvent event) {
        System.out.println("Notification for VehicleEnteredEvent for vehicle : " + event.vehicleNumber());
    }

    @EventListener
    public void notifyOnVehicleExit(VehicleExitedEvent event) {
        System.out.println("Notification for VehicleExitedEvent for vehicle : " + event.vehicleNumber());
    }
}
