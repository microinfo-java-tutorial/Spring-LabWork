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

@Configuration
public class SpringRepositoryConfig {
	
	@Autowired
	private int maxSearchResults;
	
	@Bean
	public ItemRepository itemRepository(){
		
		InMemoryItemRepository itemRepository = new InMemoryItemRepository();
		
		itemRepository.setMaxSearchResults(maxSearchResults);
		
		return itemRepository;
	}
}