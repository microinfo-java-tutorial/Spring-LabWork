<<<<<<< HEAD
/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

public class UT_Catalog {

	@Test
	public void catalogTest() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		Catalog cat = (Catalog) ctx.getBean("catalog");
		
		MusicItem musicItem = cat.findById(1L);
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(musicItem);
		System.out.println("***\n");
		
		System.out.println("All Music Items: -------------------------------------------------------");
		List<MusicItem> musicItemsList = cat.getAllMusicItems();
		
		for(MusicItem  musicitem: musicItemsList) {
			System.out.println("ArtistName: " + musicitem.getTitle());
		}
		
		ctx.close();
	}

}
=======
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

		Catalog cat = ctx.getBean(Catalog.class);
		 MusicItem musicItem = cat.findById(1L);
		 
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(musicItem);
		System.out.println("***\n");

		ctx.close();
	}

}
>>>>>>> bdca71b2cc17d7a8f21cd8cfa06ab1235ca112f1
