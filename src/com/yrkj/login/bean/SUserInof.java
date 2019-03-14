package com.yrkj.login.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SUserInof entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="S_USER_INOF")
public class SUserInof implements java.io.Serializable {

	@Id
//	@GeneratedValue
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false, length=16)
	private long id;
	@Column(name="NAME", unique=true, nullable=false, length=16)
	private String name;
	@Column(name="PASSWORD", unique=true, nullable=false, length=32)
	private String password;
	@Column(name="EFFECT_TIME")
	private Date effectTime;
	@Column(name="FAIL_TIME")
	private Date failTime;
	@Column(name="IS_VALID", unique=true, nullable=false, length=2)
	private String isValid;
	@Column(name="GENDER", unique=true, nullable=true, length=2)
	private String gender;
	@Column(name="PHONE", unique=true, nullable=true, length=11)
	private String phone;
	@Column(name="EMAIL", unique=true, nullable=true, length=32)
	private String email;
	@Column(name="department", unique=true, nullable=true, length=2)
	private String department;


	/** default constructor */
	public SUserInof() {
	}

	/** minimal constructor */
	public SUserInof(long id) {
		this.id = id;
	}
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	// Property accessors

	public long getId() {
		return  this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}

	public Date getFailTime() {
		return failTime;
	}

	public void setFailTime(Date failTime) {
		this.failTime = failTime;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}