package com.action.myboot.converter;

import javax.persistence.AttributeConverter;

import com.action.myboot.pojo.SexEnum;

public class SexConverter implements AttributeConverter<String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String status) {
		try {
			return Integer.parseInt(status); // 如果是数字，则直接返回（这里可以遍历StatusEnum的value来进一步验证）
		} catch (NumberFormatException e) {
			for (SexEnum type : SexEnum.values()) { // 如果不是数字，则通过StatusEnum来找到描述对应的数字
				if (status.equals(type.getName())) {
					return type.getId();
				}
			}
		}
		return 1;
	}

	@Override
	public String convertToEntityAttribute(Integer value) {
		 for (SexEnum type : SexEnum.values()) {    //将数字转换为描述
	            if (value.equals(type.getId())) {
	                return type.getName();
	            }
	        }
		 return " ";
	}
}
