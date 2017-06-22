/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.*;

import com.javatunes.service.CatalogImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.service.Catalog;

public class UT_Catalog {

	@Test
	public void catalogTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		assertTrue("spring container should not be null", ctx != null);
		Catalog catalog = (CatalogImpl)ctx.getBean("musicCatalog");
		
		for(Long i=(long) 1; i<=10; i++){
		System.out.println("This is message using DI -- " + catalog.findById(i));
		
		}
		ctx.close();
		
	}
}

