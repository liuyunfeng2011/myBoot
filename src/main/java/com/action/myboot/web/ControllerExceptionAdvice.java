package com.action.myboot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.action.myboot.util.JsonResult;
import com.action.myboot.util.MyExption;
import com.action.myboot.util.ResultCode;

@RestControllerAdvice
public class ControllerExceptionAdvice {
	
    @ResponseBody
	@ExceptionHandler(java.lang.Exception.class)
	public JsonResult handleRE(Exception ex){
    	System.out.println(ex.getMessage());
		return new JsonResult(ResultCode.EXCEPTION, ResultCode.EXCEPTION.msg());
	}
    @ResponseBody
   	@ExceptionHandler(MyExption.class)
   	public JsonResult  handleREMy(MyExption ex){
		return new JsonResult(ResultCode.SYS_ERROR, ResultCode.SYS_ERROR.msg());
//    	Map map = new HashMap();
//        map.put("code",ResultCode.SYS_ERROR);
//        map.put("msg", ResultCode.SYS_ERROR.msg());
//        return map;
   	}
    
}
