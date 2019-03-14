package com.yrkj.permission.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.yrkj.permission.bean.PermissionBean;
import com.yrkj.permission.bean.UserMenuBean;
import com.yrkj.permission.dao.PermissionDao;

@Service
public class PermissionImpl implements IPermission{

	@Resource
	private PermissionDao permissionDao;

	public boolean saveMenu(HttpServletRequest request) {
		PermissionBean pb = new PermissionBean();
		permissionDao.saveMenu(pb);
		return false;
	}

	public boolean deleteMenu(HttpServletRequest request) {
		PermissionBean pb = new PermissionBean();
		permissionDao.deleteMenu(pb);
		return false;
	}

	public boolean updateMenu(HttpServletRequest request) {
		PermissionBean pb = new PermissionBean();
		permissionDao.updateMenu(pb);
		return false;
	}

	public boolean deleteUserMenu(HttpServletRequest request) {
		UserMenuBean ub = new UserMenuBean();
		permissionDao.deleteUserMenu(ub);
		return false;
	}

	public boolean updateUserMenu(HttpServletRequest request) {
		UserMenuBean ub = new UserMenuBean();
		permissionDao.updateUserMenu(ub);
		return false;
	}

	public List selMenu(HttpServletRequest request) {
		String id = request.getParameter("id");
		return permissionDao.selMenu(id);
	}
	
	
	
}
