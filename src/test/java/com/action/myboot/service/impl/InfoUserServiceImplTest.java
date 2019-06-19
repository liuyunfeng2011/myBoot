package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import java.util.List;
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
		InfoUser user= infoUserService.getInfoUser(22);
		System.out.println(user.getInfoName());
	}
	@Ignore
	@Rollback(false)
	@Test
	public void testAddInfoUser() {
		InfoUser user= new InfoUser();
		user.setInfoName("xiaohuihui2");
		user.setInfoPwd("admin123");
		user.setSex(SexEnum.FEMALE);
		infoUserService.addInfoUser(user);
		System.out.println("++++++++++++++++++++++++++++++"+user.getInfoId());
	}
	@Rollback(false)
	@Test
	public void testupInfoUser() {
		InfoUser user= new InfoUser();
		user.setInfoId(22);
		user.setInfoName("caozh2i");
		infoUserService.updateInfoUser(user);
	}
	@Ignore
	@Test
	public void testfindUserLikeName() {
		List<InfoUser> users= infoUserService.findUserLikeName("xiao");
		System.out.println(users);
	}
	@Ignore
	@Rollback(false)
	@Test
	public void testdeleteUser() {
		infoUserService.deleteInfoUser(24);
	}
	@Ignore
	@Test
	public void testRedis() {
//		redisTemplate.opsForValue().set("name", "xiaoheihei");
	//	redisUtil.set("age", "16");
	System.out.println(redisUtil.hasKey("age"));	
	redisUtil.expire("name", 30, TimeUnit.SECONDS);
	System.out.println(redisUtil.getExpire("name"));
	}
	

}
