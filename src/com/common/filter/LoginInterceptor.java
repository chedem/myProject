package com.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("dddddddddddddddddddd");
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ddddddddddddfffffffffffffffffffdddddddd");

//		arg1.sendRedirect("/login.jsp");
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		String str = (String) arg0.getSession().getAttribute("isLogin");  
        System.out.println("str=========>"+str);  
        if(str==null){  
            return true;  
        }  
        return false;  
	}

}
