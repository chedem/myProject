package com.yrkj.login.bean;



public class UserInfo {
	

	private String id;
	private String name;
	private String passWord;
	private String effectTime;
	private String failTime;
	private String isValid;
	private String gender;
	private String phone;
	private String email;
	
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", passWord="
				+ passWord + ", effectTime=" + effectTime + ", failTime="
				+ failTime + ", isValid=" + isValid + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEffectTime() {
		return effectTime;
	}
	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}
	public String getFailTime() {
		return failTime;
	}
	public void setFailTime(String failTime) {
		this.failTime = failTime;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	
	

}
