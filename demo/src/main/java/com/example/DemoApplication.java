package com.example;

import com.example.Service.CityService;
import com.example.Service.Iml.CityServiceIml;
import com.example.Service.Iml.NationServiceIml;
import com.example.Service.NationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CityService cityService() {
		return new CityServiceIml();
	}
	@Bean
	public NationService nationService() {
		return new NationServiceIml();
	}
}
