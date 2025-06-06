package com.api.apicliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api.apicliente")
public class ApiclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiclienteApplication.class, args);
	}

}
