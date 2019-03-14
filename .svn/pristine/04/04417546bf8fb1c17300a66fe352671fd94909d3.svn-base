package com.yrkj.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.image.YzmImage;
import com.common.md5.Md5;
import com.yrkj.login.bean.UserInfo;
import com.yrkj.login.dao.LoginDao;
import com.yrkj.login.service.ILogin;

@Controller
@RequestMapping("/welcome")
public class LoginConter {
	
	@Resource
	private ILogin login;
	
	@RequestMapping(value="/login2.do",method = RequestMethod.POST)
    @ResponseBody
	public void login2( @RequestParam String logname,@RequestParam String logpass){
//		String s  =request.getParameter("user");
		try {
//		    response.setHeader("Content-type", "text/html;charset=UTF-8");  
//			response.sendRedirect("/web/index.jsp");
			return;
//			response.getWriter().write("您的应户名或密码错误");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@RequestMapping(value="/image")
//    @ResponseBody
//	public BufferedImage image(){
//		System.out.println("ddddddd");
//		return YzmImage.getYzm();
////		login.update(request);
////		login.delete(request);
//	}
	
	//生成验证码图片  
	@RequestMapping("/image") //对应/user/valicode.do请求  
	public void image(HttpServletResponse response,HttpSession session) throws Exception{  
	    //将图片输出给浏览器  
	    BufferedImage image =  YzmImage.getYzm(); 
	    response.setContentType("image/jpg");  
	    OutputStream os = response.getOutputStream();  
	    ImageIO.write(image, "jpg", os);  
	}  
	
	@RequestMapping(value="/login4")
    @ResponseBody
	public void login4(HttpServletRequest request){
		try {
			login.save(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		login.update(request);
//		login.delete(request);
	}
	
	
	@RequestMapping(value="/login3.do")
	public ModelAndView login3( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		try {
			request.setCharacterEncoding("utf-8");
			UserInfo user = (UserInfo)request.getSession().getAttribute("user");  
			if(user!=null){
				mav.setViewName("forward:/jsp/index/index.jsp");
				 return mav;  
			}
			String logname  =request.getParameter("logname");
			String logpass  =request.getParameter("logpass");
			List list = login.login(logname, logpass);
			
			if(list.size()>0){
				UserInfo ui =(UserInfo) list.get(0);
				request.getSession().setAttribute("user",ui);
				request.getSession().setAttribute("userName",ui.getName());
				System.out.println(request.getSession().getAttribute("user"));
//				mav.setViewName("redirect:/jsp/index/index.jsp");
				mav.setViewName("forward:/jsp/index/index.jsp");
			}else{
				mav.setViewName("forward:/jsp/login/login.jsp");
				mav.addObject("errorInfo", "账号或密码错误");
			}
			
		} catch (Exception e) {
			mav.setViewName("forward:/jsp/login/login.jsp");
			mav.addObject("errorInfo", "账号或密码错误");
			return mav;  
		}
		return mav;  
	}
	
	@RequestMapping(value="/login.jsp")
	public ModelAndView login(HttpServletRequest request ){
		ModelAndView mav = new ModelAndView();
		try {
			request.setCharacterEncoding("utf-8");
			String logname  =request.getParameter("logname");
			String logpass  =request.getParameter("logpass");
			List list = login.login(logname, logpass);
			
			if(list.size()>0){
				request.getSession().setAttribute("user",list.get(0));
				System.out.println(request.getSession().getAttribute("user"));
				mav.setViewName("redirect:/jsp/index/index.jsp");
			}else{
				mav.setViewName("forward:login.jsp");
				mav.addObject("errorInfo", "账号或密码错误");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	        return mav;  
	        
//		return "redirect:login.jsp";
//	    return "forward:login.jsp";
//		return "welcome/login";
	}
	
	
	@RequestMapping(value="/saveUserInfo")
    @ResponseBody
	public boolean saveUserInfo(HttpServletRequest request){
		try {
			return login.save(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@RequestMapping(value="/deleteUserInfo")
    @ResponseBody
	public boolean deleteUserInfo(HttpServletRequest request){
		try {
			return login.delete(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@RequestMapping(value="/updateUserInfo")
    @ResponseBody
	public boolean updateUserInfo(HttpServletRequest request){
		try {
			
			return login.update(request);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping(value="/selUserInfo")
    @ResponseBody
	public List selUserInfo(HttpServletRequest request){
		try {
			return login.selUserInfor(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
