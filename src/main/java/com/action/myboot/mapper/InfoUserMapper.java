package com.action.myboot.mapper;

import org.apache.ibatis.annotations.Param;

import com.action.myboot.pojo.InfoUser;

public interface InfoUserMapper {
	public InfoUser getInfoUser(int infoId);
	void addInfoUser(@Param("user")InfoUser user);
}
