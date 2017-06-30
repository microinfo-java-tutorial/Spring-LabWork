/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.HibernateItemRepository;

@Configuration
public class SpringRepositoryConfig {
	
	@Autowired
	@Qualifier("javatunesSessionFactory")
	SessionFactory sf;
	
	// Define itemRepository bean
	@Bean
	public ItemRepository itemRepository() {
		// TODO: Create the repository instance
		HibernateItemRepository rep = new HibernateItemRepository();
		
		// TODO: Set the session factory on the repository instance
		rep.setSessionFactory(sf);
		// Return the repository instance
		return rep;
	}

}