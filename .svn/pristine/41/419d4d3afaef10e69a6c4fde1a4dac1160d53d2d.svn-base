package com.yrkj.code.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_p_code")
public class PCodeBean implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false, length=16)
	private long id;
	@Column(name="code", unique=true, nullable=false, length=8)
	private String code;
	@Column(name="name", unique=true, nullable=false, length=16)
	private String name;
	@Column(name="type", unique=true, nullable=false, length=8)
	private String type;
	@Column(name="is_valid", unique=true, nullable=false, length=2)
	private String is_valid;
	@Column(name="remark_1", unique=true, nullable=false, length=255)
	private String remark1;
	@Column(name="remark_2", unique=true, nullable=false, length=255)
	private String remark2;
	@Column(name="remark_3", unique=true, nullable=false, length=255)
	private String remark3;
	@Column(name="remark_4", unique=true, nullable=false, length=255)
	private String remark4;
	@Column(name="remark_5", unique=true, nullable=false, length=255)
	private String remark5;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public String getRemark5() {
		return remark5;
	}
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	public PCodeBean() {
		super();
	}
	public PCodeBean(long id) {
		super();
		this.id = id;
	}
	
	

	
}
