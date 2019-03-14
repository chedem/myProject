package com.yrkj.menu.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.yrkj.login.bean.UserInfo;
import com.yrkj.menu.bean.UserMenu;
import com.yrkj.menu.dao.IMenuDao;

@Service
public class MenuImpl implements IMenuService {

	@Resource
	private IMenuDao menuDao;

	public List selUserMenu(HttpServletRequest request) {

		String id = request.getParameter("userId");
		if(id==null||"".equals(id)){
			UserInfo user = (UserInfo)request.getSession().getAttribute("user");  
			if(user==null){return null;}
			id=user.getId();
		}
		return menuDao.selUserMenu(id);
	}

	public boolean delUserMenu(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String[] menuIds = request.getParameter("sendId").split("_");
		for (int i = 0,num=menuIds.length; i < num; i++) {
			Long menuId = Long.valueOf(menuIds[i]);
			UserMenu um = new UserMenu();
			um.setId(userId+"_"+menuId);
			um.setMenuId(menuId);
			um.setUserId(Long.valueOf(userId));
			menuDao.delUserMenu(um);
		}
		return true;
	}

	public boolean saveUserMenu(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String[] menuIds = request.getParameter("sendId").split("_");
		for (int i = 0,num=menuIds.length; i < num; i++) {
			Long menuId = Long.valueOf(menuIds[i]);
			UserMenu um = new UserMenu();
			um.setId(userId+"_"+menuId);
			um.setMenuId(menuId);
			um.setUserId(Long.valueOf(userId));
			menuDao.saveUserMenu(um);
		}
		return true;
	}


}
