package com.action.myboot;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@SpringBootApplication
@MapperScan("com.action.myboot.mapper")
@EnableCaching
public class MybootApplication {
	@Resource(name="redisTemplate")
	private RedisTemplate redisTemplate;
	
	
	// 自定义初始化
    @PostConstruct
    public void init() {
        initRedisTemplate();
    }
	// 改变RedisTemplate对于键的序列化策略
    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }
	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}

}
