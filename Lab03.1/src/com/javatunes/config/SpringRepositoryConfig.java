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

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;

// Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {
	
	// TODO: Inject the environment
	@Autowired
	private int maxSearchResults;
	// Declare the item repository bean
	
		
	@Bean
    public ItemRepository itemRepository(){
			
	InMemoryItemRepository itemRepository = new InMemoryItemRepository();
			
	itemRepository.setMaxSearchResults(maxSearchResults);
			
	return itemRepository;
	
		// TODO: Retrieve the maxSearchResults property from the environment (as an Integer)
		// TODO: Initialize the maxSearchResults property or rep using it

	
	}
}