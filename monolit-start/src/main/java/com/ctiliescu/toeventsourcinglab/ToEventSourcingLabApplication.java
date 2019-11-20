package com.ctiliescu.toeventsourcinglab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com.ctiliescu.toeventsourcinglab" })
@EnableAsync
public class ToEventSourcingLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToEventSourcingLabApplication.class, args);
	}

}
