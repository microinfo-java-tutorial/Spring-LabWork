/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Configuration;

// TODO: Declare as a Spring configuration class
@Configuration
public class SpringDomainConfig {

	// TOOD: Declare as a bean definition
	public Integer maxSearchResults() {
		System.out.println("In SpringDomainConfig, maxSearchResults***");
		return Math.max(1, (int) (Math.random()*10));
	}
	
}