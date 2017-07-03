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

import org.springframework.stereotype.Service;

import com.microInfo.musicStore.domain.MusicItem;

@Service("catalog")
public interface Catalog {

   public MusicItem findById(Long id);
   public Collection<MusicItem> findByKeyword(String keyword);
   public List<MusicItem> getAllMusicItems();
   public int size();
   
}
