/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

/**
 * 1) Add @ComponentScan("") only if @Bean is not used.
 * 2) If we use @ComponentScan then, make sure you add all the suitable annotation in service classes and repository classes.
 * 3) By Declaring any java class with annotation @Configuration then 
 * 			that class will be treated as spring cofiguration class which is similar to application content xml file.
 * 
 * @author Siddarth
 * 
 */
//TODO: Declare as a Spring configuration class
//TODO: Import other config classes
@Configuration
//@ComponentScan("com.javaTunes")
@Import({SpringDomainConfig.class, SpringServicesConfig.class, SpringRepositoryConfig.class})
@PropertySource("classpath:musicItem.properties")
public class SpringConfig {
	
	@Autowired
	Environment env;
	
	// If want to create  a bean in xml
	
	/**
	 * Create @Bean(Creating beans manually) only if @ComponetScan is not used.
	 * 
	 */
/*	@Bean
	public ItemRepository itemRepo() {
		return new InMemoryItemRepository();
	}
	
	// method should will be considered as bean "id" tag in xml
	@Bean
	public Catalog musicCatalog() {
		
		// Similar to class="" tag in xml file
		CatalogImpl ci = new CatalogImpl();
		
		// Similar to ref tag in xml file
		ItemRepository imMemoryItemRepo = itemRepo();
		
		// Similar to property tag in xml file
		ci.setItemRepository(imMemoryItemRepo);
		
		return ci;
	}*/
	
	@Bean
	public MusicItem musicItem() {
		
		// User object and seeting the values to this user object
		MusicItem musicItem = new MusicItem();
		musicItem.setArtist(env.getProperty("artist"));
		musicItem.setPrice(new BigDecimal(env.getProperty("price")));
		musicItem.setReleaseDate(Calendar.getInstance().getTime());
		
		return musicItem;
	}
	
	
	
}
=======
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration 
@Import({SpringDomainConfig.class,SpringRepositoryConfig.class, SpringServicesConfig.class})
// TODO: Import other config classes


public class SpringConfig {}
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
