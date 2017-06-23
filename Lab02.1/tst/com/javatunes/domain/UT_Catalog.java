/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.service.Catalog;

// Configure using Spring's testing integration
// These below two annotation is initializing the Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/configuration/applicationContext.xml")
public class UT_Catalog {

    @Autowired
    private ApplicationContext ctx;
    
    @Autowired
    private Catalog catalog;
    
	@Test
	public void catalogTest() {
		assertTrue("spring container should not be null", ctx != null);
		
		//Catalog cat = (Catalog) ctx.getBean("catalog");
		
		assertTrue("Catalog should not be null", catalog!=null);
		
		System.out.println(catalog);
		System.out.println(catalog.size());
		System.out.println(catalog.findByKeyword("a"));
		
		Collection<MusicItem> musicList = catalog.findByKeyword("a");
		System.out.println("Total number of Music on a: " + musicList.size());
		
		for(MusicItem musicItem : musicList) {
			System.out.println("Music Artist: " + musicItem.getArtist());
			System.out.println("Music title: " + musicItem.getTitle());
			System.out.println("-------------------------------------------");
			
		}

	}

}
