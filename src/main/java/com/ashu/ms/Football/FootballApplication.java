package com.ashu.ms.Football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ashu.ms.external.api.impl", "com.ashu.ms.service", "com.ashu.ms.Football" })
public class FootballApplication {
	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
	}
}
