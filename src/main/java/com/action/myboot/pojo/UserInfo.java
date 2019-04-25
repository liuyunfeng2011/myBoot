package com.action.myboot.pojo;

public class UserInfo {
	private Integer infoId;
	private String nickName;
	private String phone;
	private String email;
	public Integer getInfoId() {
		return infoId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserInfo [infoId=" + infoId + ", nickName=" + nickName + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
