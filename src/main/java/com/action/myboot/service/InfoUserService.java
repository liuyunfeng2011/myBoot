package com.action.myboot.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.action.myboot.pojo.InfoUser;

public interface InfoUserService {
	public  static final int  PAGE_SIZE=5;
	public InfoUser findInfoUserById(Integer id);
	public List<InfoUser> findAllInfoUser();
	public void addInfoUser(InfoUser infoUser)throws Exception;
	public Page<InfoUser> findInfoUserByPage(int pageNow)throws Exception;
	public void addUser(InfoUser infoUser) throws Exception;
	public List<InfoUser> findInfoUserLikeName(String infoName)throws Exception;
	//public InfoUser findUserWithGender(Integer gender)throws Exception;
}
