
package com.microInfo.musicStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	// TODO: Create Catalog Property and autotire it. 
	//private Catalog catalog;
	
	@RequestMapping("/")
	public String dashboard(Model modelMap) {
		
		//get List of MusicItem from catalog.getAllMusicItems()
		
		//List<MusicItem> musicItemsList = catalog.getAllMusicItems();
		
		//modelMap.addAttribute("musicItemsList", musicItemsList);
		modelMap.addAttribute("welcomeMessage", "Hello.. Welcome to music Store...");
		
		return "dashboard";
	}
	
	@RequestMapping("/addMusicItem")
	public String addMusic() {

		return "success";
		// /WEB-INF/success.jsp
	}
	
}
