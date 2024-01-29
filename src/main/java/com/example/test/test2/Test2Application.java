package com.example.test.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Test2Application {	

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}
	
}
