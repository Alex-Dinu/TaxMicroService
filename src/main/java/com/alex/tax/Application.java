package com.alex.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition// http://localhost:8080/swagger-ui.html
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
