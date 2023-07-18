package com.example.bff3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Bff3Application {

	public static void main(String[] args) {
		SpringApplication.run(Bff3Application.class, args);
	}

}
