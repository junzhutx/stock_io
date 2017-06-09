package com.rainston.dailyprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories ("com.rainston.common.repository")
public class DailyProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyProcessorApplication.class, args);
	}
}
