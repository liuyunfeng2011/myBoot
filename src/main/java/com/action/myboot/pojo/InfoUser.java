package com.action.myboot.pojo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import com.action.myboot.converter.SexConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//@NamedQueries({ 有问题
//	@NamedQuery(name="findUserWithGender",query="select info from infouser where info.sex=?1")
//})
@JsonAutoDetect
@Entity(name="infouser")
@Table(name="infouser")
public class InfoUser {
	public InfoUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoUser(String infoName, String infoPwd, String sex) {
		super();
		this.infoName = infoName;
		this.infoPwd = infoPwd;
		this.sex = sex;
	}
	
	@JsonProperty("id")
	@Id
	@Column(name="info_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer infoId;
	@JsonProperty("name")
	@Column(name="user_name")
	private String infoName;
	@JsonIgnore
	@Column(name="user_pwd")
	private String infoPwd;
	@JsonProperty("gender")
	@Convert(converter=SexConverter.class)
	@Column(name="user_gender")
	private String sex;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "InfoUser [infoId=" + infoId + ", infoName=" + infoName + ", infoPwd=" + infoPwd + ", sex=" + sex + "]";
	}
	
}
