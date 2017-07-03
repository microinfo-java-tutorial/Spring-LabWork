/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.InMemoryItemRepository;

<<<<<<< HEAD
// TODO: Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {

	// TODO: Declare the item repository bean
	@Bean
	public ItemRepository itemRepo() {
		System.out.println("In SpringRepositoryConfig, itemRepo() ***");
		InMemoryItemRepository inMemoryItemRepository = new InMemoryItemRepository();
		
		return inMemoryItemRepository;
	}
	
}
=======
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
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
