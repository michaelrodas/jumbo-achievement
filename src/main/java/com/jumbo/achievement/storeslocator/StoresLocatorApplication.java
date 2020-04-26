package com.jumbo.achievement.storeslocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StoresLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoresLocatorApplication.class, args);
	}
}
