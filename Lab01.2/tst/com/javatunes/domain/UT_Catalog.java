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
		Catalog catalog = (CatalogImpl)ctx.getBean("catalog");
		System.out.println("This is message using DI -- " + catalog.findById(1L));
		/*
		 * Look up the musicCatalog and invoke its toString method.  
		 * Don't forget to close spring context
		 */
		
	}
}
