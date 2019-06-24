package com.action.myboot.pojo;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
//性别枚举类
//声明JdbcType为整型
@MappedJdbcTypes(value=JdbcType.INTEGER)
//声明JavaType为SexEnum
@MappedTypes(value=SexEnum.class)
public enum SexEnum {
	    MALE(1, "男"),
	    FEMALE(2, "女");

	    private int id ;
	    private String name;
	    SexEnum(int id, String name) {
	        this.id = id;
	        this.name= name;
	    }

	    public static SexEnum getEnumById(int id) {
	        for (SexEnum sex : SexEnum.values()) {
	            if (sex.getId() == id) {
	                return sex;
	            }
	        }
	        return null;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	    
}
