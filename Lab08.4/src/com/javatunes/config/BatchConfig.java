/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.batch.HibernateMusicItemWriter;
import com.javatunes.batch.MusicItemNameProcessor;
import com.javatunes.batch.MusicItemPriceProcessor;
import com.javatunes.batch.MusicItemWriter;
import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

@Configuration
// Enable Spring batch processing
@EnableBatchProcessing
public class BatchConfig {

	// @EnableBatchProcessing sets up the following two builders
    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;
    
    @Inject
    SessionFactory sf;
    
	// Inject the repository
	@Inject
	ItemRepository repository;    
    
 
    // Configure a MusicItem reader
	@Bean
	public ItemReader<MusicItem> reader() {

		HibernateCursorItemReader<MusicItem> reader = new HibernateCursorItemReader<MusicItem>();
		reader.setQueryString("from MusicItem");
		reader.setSessionFactory(sf);
		reader.setUseStatelessSession(true);
		// Use our version so we can see debugging output
		return reader;
	}

	// Configure a MusicItem processor
	@Bean
	public ItemProcessor<MusicItem,MusicItem> nameProcessor() {
		return new MusicItemNameProcessor();
	}
	
	@Bean
	public ItemProcessor<MusicItem,MusicItem> priceProcessor() {
		return new MusicItemPriceProcessor();
	}
		
	// Configure a MusicItem writer writing to the DB
	@Bean
	public ItemWriter<MusicItem> writer() {
		HibernateMusicItemWriter theWriter = new HibernateMusicItemWriter();
		theWriter.setRepository(repository);

		return theWriter;
	}

	// Configure our job
	@Bean
	public Job job1() {
		return jobs.get("myJob6").start(step2()).next(step1()).build();		
	}

	// Configure our step
	@Bean
	public Step step1() {
		return steps.get("step1")
				.<MusicItem,MusicItem> chunk(2).reader(reader())
				.processor(nameProcessor()).writer(writer()).build();
	}

	// Configure our step two
	@Bean
	public Step step2() {
		return steps.get("step2")
				.<MusicItem,MusicItem> chunk(2).reader(reader())
				.processor(priceProcessor()).writer(writer()).build();
	}	
	
	// This is for the optional part, that configures two processors (name and price) 
	@Bean
	public ItemProcessor<MusicItem,MusicItem> namePriceProcessor() {
		CompositeItemProcessor<MusicItem,MusicItem> compositeProcessor =
                new CompositeItemProcessor<MusicItem,MusicItem>();
		List<ItemProcessor<MusicItem,MusicItem>> processors = new ArrayList<ItemProcessor<MusicItem,MusicItem>>();
		processors.add(nameProcessor());
		processors.add(priceProcessor());
		compositeProcessor.setDelegates(processors);
		return compositeProcessor;
	}	

}