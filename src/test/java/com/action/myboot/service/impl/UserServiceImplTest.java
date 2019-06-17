package com.action.myboot.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Ignore
	@Test
	public void testGenderEnum() {
		Map<Object, Object> dropMap=new HashMap<>();
		try {
			List<Map<String, Object>> dropList=new ArrayList<>();
			for(SexEnum sex:SexEnum.values()){
				Map<String, Object> sexMap=new HashMap<>();
				sexMap.put("id",sex.getId());
				sexMap.put("name",sex.getName());
				dropList.add(sexMap);
			}
			dropMap.put("sex", dropList);
			System.out.println(dropMap.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
