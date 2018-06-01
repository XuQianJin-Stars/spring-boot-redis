package com.example.demo.core;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
	
	@Bean("redisTemplate")
	public StringRedisTemplate redisTemplate(
			RedisConnectionFactory factory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();  
		stringRedisTemplate.setConnectionFactory(factory);
		stringRedisTemplate.setHashKeySerializer(stringSerializer);
		stringRedisTemplate.setKeySerializer(stringSerializer);
		stringRedisTemplate.setHashValueSerializer(stringSerializer);
		return stringRedisTemplate;
	}
}
