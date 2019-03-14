package com.yrkj.permission.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="s_user_menu")
public class UserMenuBean  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", unique=true, nullable=false, length=16)
	private Long id;
	@Column(name="menu_id", unique=true, nullable=false, length=16)
	private Long menuId;
	@Column(name="user_id", unique=true, nullable=false, length=16)
	private Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserMenuBean(Long id, Long menuId, Long userId) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.userId = userId;
	}
	public UserMenuBean(Long id) {
		super();
		this.id = id;
	}
	public UserMenuBean() {
		super();
	}
	
	
}
