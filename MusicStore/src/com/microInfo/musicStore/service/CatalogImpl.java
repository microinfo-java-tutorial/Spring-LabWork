/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.microInfo.musicStore.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microInfo.musicStore.domain.MusicItem;
import com.microInfo.musicStore.persistence.ItemRepository;


@Service("catalog")
public class CatalogImpl implements Catalog {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public MusicItem findById(Long id) {
		
		return itemRepository.get(id);
	}
	
	
	@Override
	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.searchByArtistTitle(keyword);
	}

	@Override
	public List<MusicItem> getAllMusicItems() {

		List<MusicItem> musicItemsList = (List<MusicItem>) itemRepository.getAll();
		
		// TODO: Sort this list of musicItems in ascending order based on "artist"
		
		return musicItemsList;
	}
	
	@Override
	public int size() {
		return itemRepository.size();
	}
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}


}
