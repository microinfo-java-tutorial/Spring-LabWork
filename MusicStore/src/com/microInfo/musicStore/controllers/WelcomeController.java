
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
	
	@Autowired
	Catalog catalog;
	
	@RequestMapping("/viewDashBoard")
	public String dashboard(Model modelMap) {
		
		
		//List<MusicItem> musicItemsList = catalog.getAllMusicItems();
		List<MusicItem> musicItemsList = catalog.getAllMusicItems();
		
		//modelMap.addAttribute("musicItemsList", musicItemsList);
		modelMap.addAttribute("musicItemsList", musicItemsList);
		
		modelMap.addAttribute("welcomeMessage", "Hello.. Welcome to music Store...");
		
		return "dashboard";
	}
	
	@RequestMapping("/printMessage")
	@ResponseBody
	public String printMessage(){
		
		return "print this";
	}
	
}
