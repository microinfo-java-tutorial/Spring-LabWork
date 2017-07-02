/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

@Service("catalog")
public class CatalogImpl implements Catalog {

	@Autowired
	private ItemRepository itemRepository;
	
	 public CatalogImpl() {
	        throw new NullPointerException();
	    }
	 
	 public List<MusicItem> getAllMusicItems(){
		 
		 List<MusicItem> musicItemsList = (List<MusicItem>) itemRepository.getAll();
		 
		 return musicItemsList;
	 }

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public MusicItem findById(Long id) {
		return itemRepository.get(id);
	}

	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.searchByArtistTitle(keyword);
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
