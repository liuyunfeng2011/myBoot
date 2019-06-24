package com.action.myboot.util;

/**
 * 自定义异常，用于Controller处理全局异常
 * 
 * @author Liuyf
 *
 */
public class MyExption extends NullPointerException {

	public MyExption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyExption(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
