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
import org.springframework.context.annotation.ImportResource;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// TODO: Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
	// TODO: Inject the repository
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	private SpringRepositoryConfig springRepositoryConfig;

	// TODO: Declare the catalog bean definition
	@Bean
	public Catalog catalog() {
		
		System.out.println("In SpringServicesConfig, catalog() ***");
		CatalogImpl catalogImpl = new CatalogImpl();
		
		//ItemRepository  itemRepo = springRepositoryConfig.itemRepo();
		
		catalogImpl.setItemRepository(itemRepo);
		
		return catalogImpl;
	}

}