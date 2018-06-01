package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CacheService {
	
	@Resource(name="redisTemplate")
	private StringRedisTemplate redisTemplate;
	
	
	public void setKey(String key,String value){
		redisTemplate.opsForValue().set(key, value);
	}
	
	
	public void setHashKey(String key,String field,String value){
		redisTemplate.opsForHash().put(key, field, value);
	}
	
	
	public String getKey(String key){
		return redisTemplate.opsForValue().get(key);
	}
	
	public void deleKey(String key){
		redisTemplate.delete(key);
	}
	
	public Object getHashKey(String key,String field){
		return redisTemplate.opsForHash().get(key, field);
	}
}
