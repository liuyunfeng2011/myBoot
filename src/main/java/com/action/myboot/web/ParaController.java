package com.action.myboot.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.action.myboot.pojo.InfoUser;
import com.action.myboot.util.JsonResult;
import com.action.myboot.util.MyExption;
import com.action.myboot.util.ResultCode;

@Controller
public class ParaController {
	@Autowired
	private MessageSource messageSource;

	/**
	 * 通过路径接受
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sayHello1/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello1(@PathVariable("name") String name) throws Exception {
		return "hello boot" + name;
	}

	/**
	 * 通过@RequestParam 接受参数
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sayHello2", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello2(@RequestParam("name") String name) throws Exception {
		return "hello boot" + name;
	}

	/**
	 * 接受数组类型
	 * 
	 * @param intArr
	 * @param strArr
	 * @return
	 */
	@GetMapping(value = "/requestArray")
	@ResponseBody
	public Map requestArray(int[] intArr, String[] strArr) {
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("intArr", intArr);
		paramsMap.put("strArr", strArr);
		return paramsMap;
	}

	/**
	 * @param user
	 *            通过@RequestBody注解得到JSON参数
	 * @return 用户信息
	 */
	@PostMapping("/insert")
	@ResponseBody
	public InfoUser insert(@RequestBody InfoUser user) {
		// userService.insertUser(user);
		return user;
	}

	// 获取提交参数
	@PostMapping("/format/date")
	@ResponseBody
	public Map<String, Object> format(Date date, @NumberFormat(pattern = "#,###.##") Double number) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("date", date);
		dataMap.put("number", number);
		return dataMap;
	}

	@PostMapping("/test/date")
	@ResponseBody
	public Map<String, Object> format2(Date date) {
		System.out.println(date);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("date", date);
		return dataMap;
	}
	  // 后台获取国际化信息和打开国际化视图
    @GetMapping("/page")
    @ResponseBody
    public JsonResult page() {
    	Locale locale = LocaleContextHolder.getLocale();
        // 获取国际化消息
        String msg = messageSource.getMessage("msg", null, locale);
        System.out.println("msg+++++++++++++++++++++++++++"+msg);
		return new JsonResult(ResultCode.SUCCESS, msg);
    }
    //测试jsp文件的使用
    @GetMapping("/hello")
    public String hello() {
		return "Hello";
    }
}
