package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.action.myboot.pojo.SexEnum;
import com.action.myboot.pojo.User;
import com.action.myboot.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Resource
	private UserService userService;
	@Ignore
	@Test
	public void testAddUser() {
		try {
			userService.addUser(new User(1,"admin","xiaohie"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGenderEnum() {
		try {
		System.out.println(SexEnum.values());	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
