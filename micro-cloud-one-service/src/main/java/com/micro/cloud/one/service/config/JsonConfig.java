package com.micro.cloud.one.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper obj = new ObjectMapper();
		return obj;
	}

}
