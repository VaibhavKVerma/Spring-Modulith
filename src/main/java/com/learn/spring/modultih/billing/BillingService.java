package com.learn.spring.modultih.billing;

import com.learn.spring.modultih.event.VehicleExitedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BillingService {
    private final BillingRepository billingRepository;

    @Async("asyncExecutor")
    @EventListener
    public void handleVehicleExitedEvent(VehicleExitedEvent event) {
        Billing billing = new Billing(null, event.vehicleNumber(),100.0, LocalDateTime.now());
        billingRepository.save(billing);
        System.out.println("Bill generated for vehicle Number : " + event.vehicleNumber() + " Bill : " + billing.getAmount());
    }
}
