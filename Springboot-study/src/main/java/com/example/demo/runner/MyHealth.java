package com.example.demo.runner;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator{

	@Override
	public Health health() {
		
		return Health.down().withDetail("yang ye error", 404).build();
	}

}
