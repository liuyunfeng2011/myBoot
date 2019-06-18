package com.action.myboot.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.action.myboot.mapper.InfoUserMapper;
import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;
@Service("infoUserService")
public class InfoUserServiceImpl implements InfoUserService {
	@Resource
	private InfoUserMapper infoMapper;
	@Override
	public InfoUser getInfoUser(int infoId) {
		// TODO Auto-generated method stub
		return infoMapper.getInfoUser(infoId);
	}
	@Override
	public void addInfoUser(InfoUser user) {
		// TODO Auto-generated method stub
		infoMapper.addInfoUser(user);
	}

}
