package com.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrkj.login.bean.UserInfo;


public class SessionFilter implements Filter{

    private FilterConfig filterConfig;  
	public void destroy() {
        this.filterConfig = null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest)arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        
        String noLoginPaths = filterConfig.getInitParameter("noLoginPaths"); 
        
        
        UserInfo user = (UserInfo)request.getSession().getAttribute("user");  
        if(user==null){  
            response.sendRedirect(request.getContextPath()+"/welcome/login.jsp");  //返回重新登录界面  
            return;  
        }else{
        	if(noLoginPaths!=null){  
                String[] strArray = noLoginPaths.split(";");  
                for (int i = 0; i < strArray.length; i++) {  
                      
                    if(strArray[i]==null || "".equals(strArray[i]))continue;  
//                    if(request.getRequestURI().indexOf(strArray[i])!=-1 ){  
                    if(request.getRequestURI().endsWith(strArray[i])){
                        arg2.doFilter(arg0, arg1);  
                        return;  
                    }  
                }  
            }  
//        	arg2.doFilter(arg0,arg1);  
        }  
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
        this.filterConfig = arg0;

	}
	

}
