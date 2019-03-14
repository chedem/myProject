package com.yrkj.login.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.md5.Md5;
import com.yrkj.login.bean.SUserInof;
import com.yrkj.login.dao.LoginDao;
import com.yrkj.menu.bean.UserMenu;

@Service
@Transactional
public class LoginImpl implements ILogin{

	@Resource
	private LoginDao loginDao;

	public List login(String user,String pass) {
		try {
			pass=Md5.EncoderByMd5(pass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return loginDao.login(user, pass);
	}
	public boolean save(HttpServletRequest request) throws Exception {
		SUserInof si = new SUserInof();
		
		si.setPassword(Md5.EncoderByMd5(request.getParameter("password")));
	    si.setName(request.getParameter("name"));
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date effectTime =formatter.parse(request.getParameter("effect_Time"));
	    java.sql.Date sqlDate = new java.sql.Date(effectTime.getTime());
//	    Date effectTime =(Date) formatter.parse(request.getParameter("effect_Time"));
//	    request.getParameter("fail_Time"))
		si.setEffectTime(sqlDate);
		si.setFailTime( new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fail_Time")).getTime()));
		si.setIsValid(request.getParameter("is_Valid"));
		si.setGender(request.getParameter("gender"));
		si.setPhone(request.getParameter("phone"));
		si.setEmail(request.getParameter("email"));
		si.setDepartment(request.getParameter("department"));
		
		return loginDao.saveAA( si);
	}
	
	public boolean delete( HttpServletRequest request) {
		SUserInof si = new SUserInof();
		String userId = request.getParameter("userId");
		si.setId(Long.valueOf(userId));
		si.setName("sss");
		si.setPassword("ffss");
		si.setIsValid("1");
		loginDao.delete(si);

		return true;
	}
	
	public boolean update(HttpServletRequest request) {
		try {
			SUserInof si = new SUserInof();

			si.setId(Long.valueOf(request.getParameter("userId")));
			si.setPassword(Md5.EncoderByMd5(request.getParameter("password")));
			si.setName(request.getParameter("name"));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date effectTime =formatter.parse(request.getParameter("effect_Time"));
			java.sql.Date sqlDate = new java.sql.Date(effectTime.getTime());
			si.setEffectTime(sqlDate);
			si.setFailTime( new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fail_Time")).getTime()));
			si.setIsValid(request.getParameter("is_Valid"));
			si.setGender(request.getParameter("gender"));
			si.setPhone(request.getParameter("phone"));
			si.setEmail(request.getParameter("email"));
			si.setDepartment(request.getParameter("department"));
			loginDao.updateAA(si);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
	public List selUserInfor(HttpServletRequest request) {
		
		return loginDao.selUserInfo("");
	}
}
