package com.ctiliescu.toeventsourcinglab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.ctiliescu.toeventsourcinglab" })
public class ToEventSourcingLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToEventSourcingLabApplication.class, args);
	}

}
