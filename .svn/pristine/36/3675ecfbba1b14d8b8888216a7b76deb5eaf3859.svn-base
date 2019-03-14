package com.yrkj.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrkj.menu.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuConter {

	@Autowired
	private IMenuService menuService;
	
	
	@RequestMapping(value="/selUserMenu")
    @ResponseBody
	public List selUserMenu(HttpServletRequest request){
		try {
			return menuService.selUserMenu(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value="/delUserMenu")
    @ResponseBody
	public boolean delUserMenu(HttpServletRequest request){
		try {
			return menuService.delUserMenu(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping(value="/saveUserMenu")
    @ResponseBody
	public boolean saveUserMenu(HttpServletRequest request){
		try {
			return menuService.saveUserMenu(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
