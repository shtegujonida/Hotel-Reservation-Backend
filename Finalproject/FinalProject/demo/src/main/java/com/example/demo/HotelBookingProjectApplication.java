package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

// @ComponentScan({"main.controllers", "main.repositories"})
@SpringBootApplication
public class HotelBookingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingProjectApplication.class, args);
	}

}
