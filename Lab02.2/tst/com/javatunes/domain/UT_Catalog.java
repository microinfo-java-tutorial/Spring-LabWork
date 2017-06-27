/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;


public class UT_Catalog {
	@Test
	public void catalogTest() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		//Catalog catalog = ctx.getBean(Catalog.class);
		Catalog catalog = (Catalog) ctx.getBean("catalog");
		
		for (MusicItem musicItem : catalog.findByKeyword("a")) {
			System.out.println("Music Artist: " + musicItem.getArtist());
			System.out.println("Music title: " + musicItem.getTitle());
			System.out.println("-------------------------------------------");		
		}
		
		MusicItem musicItem = (MusicItem) ctx.getBean("musicItem");
		System.out.println("ArtistName: " + musicItem.getArtist());
		System.out.println("Price: " + musicItem.getPrice());
		
		ctx.close();
	}

}
