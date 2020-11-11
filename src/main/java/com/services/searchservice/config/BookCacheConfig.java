package com.services.searchservice.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.services.searchservice.cache.LRUBookCache;

@EnableAutoConfiguration
public class BookCacheConfig {
	
	@Bean
	public LRUBookCache createCache(){
		//we can define cache size if we want
		return new LRUBookCache();
	}

}
