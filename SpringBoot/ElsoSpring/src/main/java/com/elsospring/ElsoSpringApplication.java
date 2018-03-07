package com.elsospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties //engedjük a propertis csoportos összekötését osztályváltozóval
public class ElsoSpringApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ElsoSpringApplication.class, args);
	}
}
