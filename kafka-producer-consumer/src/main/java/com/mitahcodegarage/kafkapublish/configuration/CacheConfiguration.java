package com.mitahcodegarage.kafkapublish.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.mitahcodegarage.kafkapublish.cache.SchemaCacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Autowired
    SchemaCacheLoader schemaCacheLoader;

    @Value("${cache.expiry.time:300000}")
    int cacheExpiryTime;

    @Bean
    public LoadingCache<String, String> schemaRegistryCache() {
        return CacheBuilder.newBuilder().expireAfterWrite(cacheExpiryTime, TimeUnit.SECONDS).build(schemaCacheLoader);
    }
}
