package com.yrkj.menu.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="s_user_menu")
public class UserMenu implements Serializable{
	
	@Id
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@GenericGenerator(strategy="assigned", name="id")
//	@Column(name="ID", unique=true, nullable=false, length=16)
	private String id;                     
	
	@Column(name="user_id", unique=true, nullable=false, length=16)
	private Long userId ;     
	
	@Column(name="menu_id", unique=true, nullable=false, length=16)
	private Long menuId;

	
	public UserMenu() {
		super();
	}

	public UserMenu(String id, Long userId, Long menuId) {
		this.id = id;
		this.userId = userId;
		this.menuId = menuId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	
}
