package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.schedulings.ScheduledTask;

@SpringBootTest
class ScheduledTaskTests {

	
	@Autowired
	private ScheduledTask scheduledTask;
	
	
	
	@Test
	void contextLoads() {
		
		Assertions.assertDoesNotThrow(() -> {
			scheduledTask.collection();
        });
		
	}

}
