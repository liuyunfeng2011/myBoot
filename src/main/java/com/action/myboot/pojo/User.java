package com.action.myboot.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
/**
 * 使用hibernate-validator进行校验.<br/>
 * 
 * @Null   被注释的元素必须为 null       
 * @NotNull    被注释的元素必须不为 null       
 * @AssertTrue     被注释的元素必须为 true       
 * @AssertFalse    被注释的元素必须为 false       
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值       
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值       
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值       
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值       
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内       
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内       
 * @Past   被注释的元素必须是一个过去的日期       
 * @Future     被注释的元素必须是一个将来的日期       
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式       
 * Hibernate Validator 附加的 constraint       
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0       
 * @Email  被注释的元素必须是电子邮箱地址       
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内       
 * @NotEmpty   被注释的字符串的必须非空       
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内 
 * 
 */

@Entity
public class User implements Serializable{
	
	public User(Integer userId,
			@NotBlank(message = "不能为空") @Size(max = 16, min = 4, message = "4-16位之间") String userName,
			@NotBlank(message = "不能为空") @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{3,15}", message = "不符合规则") String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@NotBlank(message="不能为空")
	@Size(max=16,min=4,message="4-16位之间")
	private String userName;
	@NotBlank(message="不能为空")
	@Pattern(regexp="[a-zA-Z][a-zA-Z0-9]{3,15}",message="不符合规则")
	private String userPwd;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
}
