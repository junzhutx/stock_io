package com.rainston.companylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories ("com.rainston.common.repository")
public class CompanyListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyListApplication.class, args);
	}
}
