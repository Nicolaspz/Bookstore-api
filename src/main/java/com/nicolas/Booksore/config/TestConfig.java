package com.nicolas.Booksore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolas.Booksore.Service.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	DBService dbService;
	
	@Bean
	 public void InstanciarBaseDeDados() {
		 this.dbService.InstaciaBaseDeDados();
	 }

}
