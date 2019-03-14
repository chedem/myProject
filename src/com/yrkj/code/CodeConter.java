package com.yrkj.code;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrkj.code.service.ICode;

@Controller
@RequestMapping("/code")
public class CodeConter {
	@Resource
	private ICode code;
	
	@RequestMapping(value="/selCode")
    @ResponseBody
	public List selCode(HttpServletRequest request){
		return code.selCode(request);
	}
	
	@RequestMapping(value="/selPCode")
    @ResponseBody
	public List selPCode(HttpServletRequest request){
		return code.selPCode(request);
	}
	
	@RequestMapping(value="/saveCode")
    @ResponseBody
	public boolean saveCode(HttpServletRequest request){
		code.saveCode(request);
		return true;
	}
	
	@RequestMapping(value="/savePCode")
    @ResponseBody
	public boolean savePCode(HttpServletRequest request){
		 code.savePCode(request);
		return true;
	}
	
	@RequestMapping(value="/updateCode")
    @ResponseBody
	public boolean updateCode(HttpServletRequest request){
		code.updateCode(request);
		return true;
	}
	
	@RequestMapping(value="/updatePCode")
    @ResponseBody
	public boolean updatePCode(HttpServletRequest request){
		code.updatePCode(request);
		return true;
	}
	
	@RequestMapping(value="/delCode")
    @ResponseBody
	public boolean delCode(HttpServletRequest request){
		code.delCode(request);
		return true;
	}
	
	@RequestMapping(value="/delPCode")
    @ResponseBody
	public boolean delPCode(HttpServletRequest request){
		code.delPCode(request);
		return true;
	}
	
}
