package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.pojo.SexEnum;
import com.action.myboot.service.InfoUserService;
import com.action.myboot.util.RedisUtil;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoUserServiceImplTest {
//	@Resource
//    private RedisTemplate<String, Object> redisTemplate;
	@Resource
    private RedisUtil redisUtil;
	@Resource(name="infoUserService")
	private InfoUserService infoUserService;
	@Ignore
	@Test
	public void testGetInfoUser() {
		InfoUser user= infoUserService.getInfoUser(3);
		System.out.println(user.getSex().getName());
	}
	@Ignore
	@Rollback(false)
	@Test
	public void testAddInfoUser() {
		InfoUser user= new InfoUser();
		user.setInfoName("xiaohei3");
		user.setInfoPwd("admin123");
		user.setSex(SexEnum.FEMALE);
		infoUserService.addInfoUser(user);
	}
	@Test
	public void testRedis() {
//		redisTemplate.opsForValue().set("name", "xiaoheihei");
	//	redisUtil.set("age", "16");
	System.out.println(redisUtil.hasKey("age"));	
	redisUtil.expire("name", 30, TimeUnit.SECONDS);
	System.out.println(redisUtil.getExpire("name"));
	}
	

}
