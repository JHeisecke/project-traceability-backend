package com.github.pol.una.traceability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TraceabilityApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(TraceabilityApplication.class, args);
	}
}
