package com.rainston.companylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompanyListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyListApplication.class, args);
	}
}
