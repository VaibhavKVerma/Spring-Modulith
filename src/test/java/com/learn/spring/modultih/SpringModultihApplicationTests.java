package com.learn.spring.modultih;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SpringModultihApplicationTests {

	@Test
	void contextLoads() {
        ApplicationModules modules = ApplicationModules.of(SpringModultihApplication.class).verify();
        new Documenter(modules).writeDocumentation();
    }

}
