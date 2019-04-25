package com.action.myboot.service.impl;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;

import com.action.myboot.util.APIException;

public class ValidatorException extends APIException{

	public ValidatorException(String message,String errCode) {
		super(message,errCode);
		// TODO Auto-generated constructor stub
	}


}
