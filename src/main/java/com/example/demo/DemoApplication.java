package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The DemoApplication class is the entry point of the application.
 * It starts the Spring Boot application and initializes the necessary components.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * The main method is the entry point of the application.
	 * It starts the Spring Boot application by calling SpringApplication.run() method.
	 *
	 * @param args The command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
