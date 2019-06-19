package com.action.myboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.action.myboot.pojo.InfoUser;

public interface InfoUserService {
	public InfoUser getInfoUser(int infoId);
	InfoUser addInfoUser(InfoUser user);
	InfoUser updateInfoUser(InfoUser user);
	 int deleteInfoUser(int infoId); 
	 List<InfoUser> findUserLikeName(String userName);
}
