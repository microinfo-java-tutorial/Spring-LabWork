
package com.microInfo.musicStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microInfo.musicStore.domain.MusicItem;
import com.microInfo.musicStore.service.Catalog;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	// TODO: Create Catalog Property and autowire it. 
	@Autowired
	private Catalog catalog;
	
	@RequestMapping("/")
	public String dashboard(Model modelMap) {
		
		//get List of MusicItem from catalog.getAllMusicItems()
		
		//List<MusicItem> musicItemsList = catalog.getAllMusicItems();
		
		//modelMap.addAttribute("musicItemsList", musicItemsList);
		modelMap.addAttribute("welcomeMessage", "Hello.. Welcome to music Store...");
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/addMusic", method = RequestMethod.GET)
	public String renderMusicForm(Model model) {
		
		MusicItem musicItem = new MusicItem();
		model.addAttribute("musicItem", musicItem);
		
		return "addMusic";
	}
	
	@RequestMapping(value = "/submitMusicForm", method = RequestMethod.POST)
	public String addMusicForm(Model model, @ModelAttribute("musicItem")MusicItem musicItem) {
		
		System.out.println("In WelcomeController, addMusicForm() method ***");
		
		System.out.println("Music Title: " + musicItem.getTitle());
		System.out.println("Artist: " + musicItem.getArtist());
		System.out.println("Release Date:" + musicItem.getReleaseDate());
		System.out.println("Music ategory SElected: " + musicItem.getMusicCategory());
		
		int newlyAddedId = catalog.addMusicItem(musicItem);
		System.out.println("Newly Added MusicItem Id: " + newlyAddedId);
		
		return "success";
	}
	
}
