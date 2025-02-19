package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CrudOperationApplication.class, args);
		System.out.println(run.hashCode());
		System.out.println("main method run successfully..");
	}

}
