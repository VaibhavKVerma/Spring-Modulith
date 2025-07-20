package com.learn.spring.modultih;

import com.learn.spring.modultih.allocation.Slot;
import com.learn.spring.modultih.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringModultihApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringModultihApplication.class, args);
	}

    @Bean
    CommandLineRunner initSlots(SlotRepository slotRepository) {
        return args -> {
            if(slotRepository.count() == 0) {
                slotRepository.save(new Slot(null,"A1",true,null));
                slotRepository.save(new Slot(null,"A2",true,null));
                slotRepository.save(new Slot(null,"A3",true,null));
                slotRepository.save(new Slot(null,"A4",true,null));
            }
        };
    }
}
