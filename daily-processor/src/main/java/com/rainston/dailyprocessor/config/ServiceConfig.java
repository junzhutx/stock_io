package com.rainston.dailyprocessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rainston.dailyprocessor.service.CompanyListProcessService;
import com.rainston.dailyprocessor.service.impl.CompanyListFileProcessServiceImpl;

@Configuration
public class ServiceConfig {

		@Bean
		public CompanyListProcessService companyListProcessService() {
			return new CompanyListFileProcessServiceImpl();
		}
}
