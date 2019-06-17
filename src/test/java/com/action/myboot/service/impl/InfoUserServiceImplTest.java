package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoUserServiceImplTest {
	@Resource(name="infoUserService")
	private InfoUserService infoUserService;
	@Test
	public void testGetInfoUser() {
		InfoUser user= infoUserService.getInfoUser(1);
		System.out.println(user);
	}

}
