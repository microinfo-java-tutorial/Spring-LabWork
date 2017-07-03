
package com.microInfo.musicStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microInfo.musicStore.domain.MusicItem;
import com.microInfo.musicStore.service.Catalog;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	// TODO: Create Catalog Property and autotire it. 
	@Autowired
	private Catalog catalog;
	
	@RequestMapping("/")
	public String dashboard(Model modelMap) {
		
		List<MusicItem> musicItemList = catalog.getAllMusicItems();
		
		
		modelMap.addAttribute("musicItemList", musicItemList);
		modelMap.addAttribute("welcomeMessage", "Hello.. Welcome to music Store...");
		
		return "dashboard";
	}
	
	@RequestMapping("/addmusicitem")
	public String addMusic() {

		return "success";
		// /WEB-INF/success.jsp
	}
	
	@RequestMapping("/print")
	@ResponseBody
	public String print(){
		
		return "printed";
	}
	
}
