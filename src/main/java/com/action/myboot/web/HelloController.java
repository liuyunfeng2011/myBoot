package com.action.myboot.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.action.myboot.util.APIException;
import com.action.myboot.util.JsonResult;
import com.action.myboot.util.JwtTokenUtils;
import com.action.myboot.util.ResultCode;
import com.action.myboot.pojo.User;
import com.action.myboot.service.UserService;
import com.action.myboot.service.impl.ValidatorException;
@RestController
public class HelloController {
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping(value="/sayHello/{name}",method=RequestMethod.GET)
	public String sayHello(@PathVariable("name")String name) {
		return "hello boot"+name;
	}
	/**
	 * 添加用户测试案例：分为前端传递form版本(正常版本) 和前端传递json版本，当前方法为在controller层调用validate验证
	 * @param user
	 * @param result
	 * @return
	 */
	//前端传递为json格式的接受方案
	//public Map<String, Object> addUser(@RequestBody @Valid User user,BindingResult result) {
	//	{
	//	"userName":"zha",
	//	"userPwd":"amdin123"
	//}
	@PostMapping(value="/addUser")
	public Map<String, Object> addUser(@Valid User user,BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(result.hasErrors()) {
			 List<ObjectError> errorList = result.getAllErrors();
	            List<String> mesList=new ArrayList<String>();
	            for (int i = 0; i < errorList.size(); i++) {
	                mesList.add(errorList.get(i).getDefaultMessage());
	            }
	            map.put("status", false);
	            map.put("error", mesList);
		}else {
			System.out.println(user);
            map.put("status", true);
            map.put("msg", "添加成功");
        }
		return map;
	}
	
	/**
	 * 当前版本为在service层验证用户
	 * @param user
	 * @param result
	 * @return
	 */
	@PostMapping(value="/addUser2")
	public JsonResult addUser2(@RequestBody User user) {
		String msg="";
		try {
			msg=userService.addUser(user);
		}catch (ValidatorException e) {
			return new JsonResult(ResultCode.VALIDATE_ERR,e.getMessage());
		}
		catch (Exception e) {
			return new JsonResult(ResultCode.EXCEPTION);
		}
		return new JsonResult();
	}
	
	@PostMapping(value="login")
	public Object userLogin(@Valid User user,BindingResult result) {
		String validMsg="";
		if(result.hasErrors()) {
			 List<ObjectError> errorList = result.getAllErrors();
	            List<String> mesList=new ArrayList<String>();
	            for (int i = 0; i < errorList.size(); i++) {
	                mesList.add(errorList.get(i).getDefaultMessage());
	            }
	            validMsg=mesList.toString();
	            return new JsonResult(ResultCode.VALIDATE_ERR,validMsg);
		}else {
			if(user.getUserName().equals("zhangsan")&&user.getUserPwd().equals("admin123")) {
				//String jwt = JwtTokenUtils.generateToken(user.getUserName());
				Map<String, String> map= new HashMap<String,String>(){{
	            //    put("token", jwt);
	            }};
	            return new JsonResult(ResultCode.SUCCESS, map);
			}else {
				 return new JsonResult(ResultCode.LOGIN_FAIL,ResultCode.LOGIN_FAIL.msg());
			}
        }
	}
}
