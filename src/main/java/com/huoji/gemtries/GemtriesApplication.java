package com.huoji.gemtries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GemtriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemtriesApplication.class, args);
	}

}
