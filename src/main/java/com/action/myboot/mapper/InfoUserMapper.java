package com.action.myboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.action.myboot.pojo.InfoUser;
@Repository
public interface InfoUserMapper {
	//获取某个用户
	 InfoUser getInfoUser(int infoId);
	 //新增用户
	 int insertInfoUser(@Param("user")InfoUser user);
	 //修改用户
	 int updateInfoUser(@Param("user")InfoUser user);
	// 删除用户
	 int deleteInfoUser(int infoId); 
	 //根据用户名查询用户
	 List<InfoUser> findUserLikeName(@Param("userName")String userName);
}
