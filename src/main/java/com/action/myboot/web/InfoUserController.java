package com.action.myboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.service.InfoUserService;
import com.action.myboot.util.JsonResult;
import com.action.myboot.util.ResultCode;

@RestController
public class InfoUserController {
	@Autowired
	private InfoUserService infoService;
	
	@GetMapping(value="/info/findAll")
	public List<InfoUser> infoUser(){
		return infoService.findAllInfoUser();
	}
	@PostMapping(value="/info/addUser")
	public JsonResult addUser(InfoUser user){
		try {
			infoService.addInfoUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION);
		}
		return new JsonResult(ResultCode.SUCCESS);
	}
	
	@GetMapping(value="/info/findUserByPage/{pageNow}")
	public  JsonResult  findUserByPage(@PathVariable("pageNow")int pageNow){
		Page<InfoUser> users=null;
		try {
			users=infoService.findInfoUserByPage(pageNow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new JsonResult(ResultCode.EXCEPTION);
		}
		return new JsonResult(ResultCode.SUCCESS, users);
	}
	
	@PostMapping(value="/info/regisUser")
	public JsonResult regisUser(@RequestBody InfoUser user){
		try {
			infoService.addInfoUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JsonResult(ResultCode.EXCEPTION);
		}
		return new JsonResult(ResultCode.SUCCESS);
	}
	@GetMapping(value="/info/findInfoUserLikeName/{name}")
	public JsonResult findInfoUserLikeName(@PathVariable("name") String name){
		List<InfoUser> users=null;
		try {
			users=infoService.findInfoUserLikeName(name);
		} catch (Exception e) {
			return new JsonResult(ResultCode.EXCEPTION);
		}
		return new JsonResult(ResultCode.SUCCESS, users);
	}
	
//	@GetMapping(value="/info/findUserWithGender/{gender}")
//	public JsonResult findUserWithGender(@PathVariable("gender") Integer gender){
//		InfoUser users=null;
//		try {
//			users=infoService.findUserWithGender(gender);
//		} catch (Exception e) {
//			return new JsonResult(ResultCode.EXCEPTION);
//		}
//		return new JsonResult(ResultCode.SUCCESS, users);
//	}
}
