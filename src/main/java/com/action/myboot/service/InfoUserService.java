package com.action.myboot.service;

import org.apache.ibatis.annotations.Param;

import com.action.myboot.pojo.InfoUser;

public interface InfoUserService {
	public InfoUser getInfoUser(int infoId);
	void addInfoUser(InfoUser user);
}
