package com.yrkj.profit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrkj.profit.service.IProfit;

@Controller
@RequestMapping("/profit")
public class ProfitConter {
	
	@Resource
	private IProfit profit;
	
	@RequestMapping(value="/getProfitData")
    @ResponseBody
	public Map getProfitData(HttpServletRequest request){

		List list = profit.getProfitData(request);
		Map map = new HashMap();
		if(list!=null){
			map.put("data", list.get(0)==null?0.00f:Float.valueOf((list.get(0).toString())));
		}else{
			map.put("data", 0.00f);
		}
//		map.put("data", 20);

		return map;
	}
	
	/**
	 * 获取公司下拉信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getCompanyData", produces = "application/json; charset=utf-8")
    @ResponseBody
	public List getCompanyData(HttpServletRequest request){

		List list = profit.getCompanyData(request);
		return list;
	}
	
	 @RequestMapping("/download5") //对应/user/valicode.do请求  
	 @ResponseBody
	 private String download5(HttpServletRequest request,HttpServletResponse response) {  
	        try {  
	            String con = profit.getFile5(request,response);
	    	    return con;
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  
	        return null;
	 }
	 
	//生成验证码图片  
	 @RequestMapping("/download") //对应/user/valicode.do请求  
	 @ResponseBody
	 private String download(HttpServletRequest request,HttpServletResponse response) {  
	        try {  
	            // 设置response的Header  
//	            response.addHeader("Content-Disposition", "attachment;'");  
//	            response.setContentType("application/vnd.ms-excel;charset=gb2312");  
//	            
//	            response.setHeader("Content-disposition","attachment;filename=temp.xlsx");  
//	            
//	            response.setContentType("application/excle");  
	            String con = profit.getFile(request,response);
//	            System.out.println(con);
//				response.getWriter().print(con);
//
//	    	    OutputStream os = response.getOutputStream();  
	    	    return con;
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  
	        return null;
	 }
	 
	 
	//生成验证码图片  
		 @RequestMapping("/download4") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String download4(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            String con = profit.getFile4(request,response);
		    	    return con;
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
		 @RequestMapping("/download6") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String download6(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            String con = profit.getFile6(request,response);
		    	    return con;
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
		 
		 
		 @RequestMapping("/download7") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String download7(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            String con = profit.getFile7(request,response);
		    	    return con;
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
		 
 
		 @RequestMapping("/downloadExelce") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String copy(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            profit.duoToOne(request,response);
		    	    return "成功！！！！";
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
		 
		 @RequestMapping("/copy1") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String copy1(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            profit.motnToOne( request, response);
		    	    return "成功！！！！";
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
}
