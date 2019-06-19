package com.action.myboot.pojo;



import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Alias(value="infoUser")
public class InfoUser implements Serializable{
	public InfoUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InfoUser(Integer infoId, String infoName, String infoPwd, SexEnum sex) {
		super();
		this.infoId = infoId;
		this.infoName = infoName;
		this.infoPwd = infoPwd;
		this.sex = sex;
	}

	public InfoUser(String infoName, String infoPwd, SexEnum sex) {
		super();
		this.infoName = infoName;
		this.infoPwd = infoPwd;
		this.sex = sex;
	}
	
//	@JsonProperty("id")
//	@Id
//	@Column(name="info_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer infoId;
//	@JsonProperty("name")
//	@Column(name="user_name")
	private String infoName;
//	@JsonIgnore
//	@Column(name="user_pwd")
	private String infoPwd;
//	@JsonProperty("gender")
//	@Convert(converter=SexConverter.class)
//	@Column(name="user_gender")
	private SexEnum sex;
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoPwd() {
		return infoPwd;
	}
	public void setInfoPwd(String infoPwd) {
		this.infoPwd = infoPwd;
	}
	
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "InfoUser [infoId=" + infoId + ", infoName=" + infoName + ", infoPwd=" + infoPwd + ", sex=" + sex + "]";
	}
	
}
