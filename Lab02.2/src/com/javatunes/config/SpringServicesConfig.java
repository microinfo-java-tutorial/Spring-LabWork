/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;

import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

@Configuration
// TODO: Declare as a configuration class
public class SpringServicesConfig {
	
	

	
	@Autowired
	ItemRepository itemRepository;
	
	// TODO: Declare the catalog bean definition
	
	
@Bean
 public Catalog catalog(){
	CatalogImpl catalog = new CatalogImpl();
	catalog.setItemRepository(itemRepository);
	return catalog;
	
}
	
		
}