/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;


<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
=======
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1

import com.javatunes.persistence.ItemRepository;

import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

@Configuration
// TODO: Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
<<<<<<< HEAD
	// TODO: Inject the repository
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	private SpringRepositoryConfig springRepositoryConfig;
=======
	
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1

	
	@Autowired
	ItemRepository itemRepository;
	
	// TODO: Declare the catalog bean definition
<<<<<<< HEAD
	@Bean
	public Catalog catalog() {
		
		System.out.println("In SpringServicesConfig, catalog() ***");
		CatalogImpl catalogImpl = new CatalogImpl();
		
		//ItemRepository  itemRepo = springRepositoryConfig.itemRepo();
		
		catalogImpl.setItemRepository(itemRepo);
		
		return catalogImpl;
	}

=======
	
	
@Bean
 public Catalog catalog(){
	CatalogImpl catalog = new CatalogImpl();
	catalog.setItemRepository(itemRepository);
	return catalog;
	
}
	
		
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
}