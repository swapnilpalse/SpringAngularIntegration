package com.swapnil.spring.angular.springangularintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig {
	@Bean
public ObjectMapper objectMapper() {
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
	return objectMapper;
}
	@Bean
public ObjectWriter objectWriter(ObjectMapper ob) {
	return ob.writerWithDefaultPrettyPrinter();
}
}
