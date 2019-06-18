package com.action.myboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.action.myboot.pojo.InfoUser;
@Repository
public interface InfoUserMapper {
	public InfoUser getInfoUser(int infoId);
	void addInfoUser(@Param("user")InfoUser user);
}
