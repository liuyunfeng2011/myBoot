package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoUserServiceImplTest {
	@Autowired
	private InfoUserService infoUserService;
	@Ignore
	@Test
	public void testFindInfoUserById() {
		InfoUser infoUser = infoUserService.findInfoUserById(1);
		System.out.println(infoUser.getSex());
	}
	@Ignore
	@Test
	public void testFindAll() {
		System.out.println("+++++++++++++++++++++++++++++");
		List<InfoUser> infoUsers = infoUserService.findAllInfoUser();
		System.out.println(infoUsers);
		for (InfoUser user : infoUsers) {
			System.out.println(user.getInfoId() + " " + user.getInfoName() + " " + user.getSex());
		}
	}
	@Ignore
	@Test
	public void testAddUser() {
		try {
			infoUserService.addInfoUser(new InfoUser("test1", "admin123", "1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
