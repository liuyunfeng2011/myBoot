package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.pojo.SexEnum;
import com.action.myboot.service.InfoUserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoUserServiceImplTest {
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
	

}
