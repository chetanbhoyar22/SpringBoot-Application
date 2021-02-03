package com.enterprise.officemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.enterprise*"})
public class OfficemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficemanagerApplication.class, args);
	}

}
