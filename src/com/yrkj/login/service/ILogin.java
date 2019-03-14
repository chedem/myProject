package com.yrkj.login.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yrkj.login.bean.SUserInof;

public interface ILogin {

	public List login(String user,String pass);
	
	public boolean save(HttpServletRequest request ) throws Exception ;
	
	public boolean update(HttpServletRequest request );
	
	public boolean delete(HttpServletRequest request );
	
	public List selUserInfor(HttpServletRequest request );
}
