package com.action.myboot.service.impl;

import org.springframework.stereotype.Service;

import com.action.myboot.pojo.User;
import com.action.myboot.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public String addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		ValidationUtils.validator(user);
		System.out.println("当跑出异常之后，这里不会执行");
		return "add User";
	}

}
