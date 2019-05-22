package com.action.myboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.pojo.User;

public interface  JpaInfoUserRepository extends JpaRepository<InfoUser, Integer>{
	@Query(value="select * from infouser where user_name like   CONCAT('%',?1,'%')",nativeQuery=true)
	public List<InfoUser> findInfoUserLikeName(String name);
	
	public InfoUser findUserWithGender(Integer gender);
}
