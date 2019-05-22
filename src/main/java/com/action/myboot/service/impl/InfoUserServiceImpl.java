package com.action.myboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.action.myboot.dao.JpaInfoUserRepository;
import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;
@Service
public class InfoUserServiceImpl implements InfoUserService{
	@Autowired
	private JpaInfoUserRepository userRepository;
	@Override
	public InfoUser findInfoUserById(Integer id) {
		// TODO Auto-generated method stub
		InfoUser user=userRepository.findById(id).get();
		return user;
	}
	@Override
	public List<InfoUser> findAllInfoUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public void addInfoUser(InfoUser infoUser) {
		// TODO Auto-generated method stub
		userRepository.save(infoUser);
	}
	@Override
	public Page<InfoUser> findInfoUserByPage(int pageNow) {
		// TODO Auto-generated method stub
		Pageable page=new Pageable();
		Page<InfoUser> infoUsers= userRepository.findAll(new PageRequest(pageNow, PAGE_SIZE));
		return infoUsers;
	}
	@Override
	public void addUser(InfoUser infoUser) throws Exception {
		// TODO Auto-generated method stub
		userRepository.save(infoUser);
	}
	@Override
	public List<InfoUser> findInfoUserLikeName(String infoName) {
		// TODO Auto-generated method stub
		return userRepository.findInfoUserLikeName(infoName);
	}
//	@Override
//	public InfoUser findUserWithGender(Integer gender) {
//		// TODO Auto-generated method stub
//		return userRepository.findUserWithGender(gender);
//	}
}
