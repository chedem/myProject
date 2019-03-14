package com.yrkj.permission.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="s_menu")
public class PermissionBean implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id", unique=true, nullable=false, length=16)
	private Long menuId;
	@Column(name="menu_url", unique=true, nullable=false, length=120)
	private String menuUrl;
	@Column(name="menu_name", unique=true, nullable=false, length=32)
	private String menuName;
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public PermissionBean(Long menuId, String menuUrl, String menuName) {
		super();
		this.menuId = menuId;
		this.menuUrl = menuUrl;
		this.menuName = menuName;
	}
	public PermissionBean() {
		super();
	}
	public PermissionBean(Long menuId) {
		super();
		this.menuId = menuId;
	}
	
	
	
}
