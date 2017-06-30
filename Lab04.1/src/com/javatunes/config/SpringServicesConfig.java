/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

@Configuration
public class SpringServicesConfig {
	
	// TODO: Inject the repository
	@Autowired
	ItemRepository repository;
	
	// TODO: Define the catalog bean
	@Bean
	public Catalog catalog() {
		// TODO Create the catalog implementation - passing in the repository
		CatalogImpl catalog = new CatalogImpl(repository);
		return catalog;
	}

}