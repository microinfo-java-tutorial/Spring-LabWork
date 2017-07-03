/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.microInfo.musicStore.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microInfo.musicStore.domain.MusicItem;

@Repository("itemRepository")
public interface ItemRepository {

  public MusicItem get(Long id);

  public Collection<MusicItem> getAll();

  public Collection<MusicItem> searchByArtistTitle(String keyword);
  
  public List<MusicItem> getAllMusicItems();
  
  public int size();
}
