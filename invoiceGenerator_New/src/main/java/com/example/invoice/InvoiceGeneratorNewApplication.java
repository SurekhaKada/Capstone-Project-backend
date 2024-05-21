package com.example.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.invoice")
public class InvoiceGeneratorNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceGeneratorNewApplication.class, args);
	}

}
