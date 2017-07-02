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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.microInfo.musicStore.domain.MusicItem;

@Repository("itemRepository")
public class HibernateItemRepository implements ItemRepository {
	
	@Autowired
	@Qualifier("javatunesSessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
	  sessionFactory = sf;
	}
	public SessionFactory getSessionFactory() {
	  return sessionFactory;
	}

	public MusicItem get(Long id) {
		// Call EntityManager.find() and return the result
		Session s = getSessionFactory().getCurrentSession();
		s.beginTransaction();
		MusicItem ret = (MusicItem)s.get(MusicItem.class, id);
		s.getTransaction().commit();
		return ret;
	}

	@Override
	public Collection<MusicItem> getAll() {
		// Not implemented
		Session s = getSessionFactory().getCurrentSession();
		s.beginTransaction();
		List<MusicItem> musicItemsList = s.createCriteria(MusicItem.class).list();
		
		return musicItemsList;
	}

	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		// Not implemented
		return null;
	}

	@Override
	public int size() {
		// Not implemented
		return 0;
	}

}
