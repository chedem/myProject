package com.yrkj.permission;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrkj.permission.service.IPermission;

@Controller
@RequestMapping("/permission")
public class PermissionConter {

	@Resource
	private IPermission permission;
	
	
	@RequestMapping(value="/selMenu")
    @ResponseBody
	public List selMenu(HttpServletRequest request){
		return permission.selMenu(request);
	}
	
	@RequestMapping(value="/saveMenu")
    @ResponseBody
	public boolean saveMenu(HttpServletRequest request){
		permission.saveMenu(request);
		return true;
	}
	@RequestMapping(value="/updateMenu")
    @ResponseBody
	public boolean updateMenu(HttpServletRequest request){
		permission.updateMenu(request);
		return true;
	}
	@RequestMapping(value="/deleteMenu")
    @ResponseBody
	public boolean deleteMenu(HttpServletRequest request){
		permission.deleteMenu(request);
		return true;
	}
	
	@RequestMapping(value="/deleteUserMenu")
    @ResponseBody
	public boolean deleteUserMenu(HttpServletRequest request){
		permission.deleteUserMenu(request);
		return true;
	}
	
	@RequestMapping(value="/updateUserMenu")
    @ResponseBody
	public boolean updateUserMenu(HttpServletRequest request){
		permission.updateUserMenu(request);
		return true;
	}
	
}
