package com.action.myboot.service.impl;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;

import com.action.myboot.util.APIException;
import com.action.myboot.util.ResultCode;

public class ValidationUtils {
	/**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    
    /**
     * 功能描述: 
     * 〈注解验证参数〉
     *
     * @param obj
     * @throws APIException 
     * @throws ValidateException 
     */
    public static <T> void validator(T obj) throws APIException   {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
        	Iterator<ConstraintViolation<T>> it=constraintViolations.iterator();
        	String errMsg="";
        	while(it.hasNext()) {
        		ConstraintViolation<T> c=it.next();
        		String propertyPath= c.getPropertyPath().toString();
        		String msg=c.getMessageTemplate();
        		errMsg=propertyPath+":"+msg+";";
        	}
        	ValidatorException ex=new ValidatorException(errMsg, ResultCode.VALIDATE_ERR.val());
        	throw ex;
        }
    }
}
