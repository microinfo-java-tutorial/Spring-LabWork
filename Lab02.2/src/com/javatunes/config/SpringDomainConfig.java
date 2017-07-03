/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

<<<<<<< HEAD
import org.springframework.context.annotation.Configuration;

=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
// TODO: Declare as a Spring configuration class
@Configuration
public class SpringDomainConfig {

	@Bean
	// TOOD: Declare as a bean definition
	public Integer maxSearchResults() {
		System.out.println("In SpringDomainConfig, maxSearchResults***");
		return Math.max(1, (int) (Math.random()*10));
	}
	
}