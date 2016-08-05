package com.quantiphi.learnhub.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching	
public class CacheConfig {

	@Bean
	public CacheManager cacheManager() {
		// configure and return an implementation of Spring's CacheManager SPI
		SimpleCacheManager cacheManager = new SimpleCacheManager();

		List<ConcurrentMapCache> lst = new ArrayList<ConcurrentMapCache>();
		lst.add(new ConcurrentMapCache("course"));
		cacheManager.setCaches(lst);

		return cacheManager;
	}
}
