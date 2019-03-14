package com.yrkj.extract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yrkj.extract.dao.ExtractDataDao;
import com.yrkj.profit.service.ProfitImpl;

@Controller
@RequestMapping("/extract")
public class ExtractDataConter {

	@Resource
	private ExtractDataDao extractDataDao;
	
	@RequestMapping(value="/departmentData")
    @ResponseBody
	public String departmentData(HttpServletRequest request){
		System.out.println("ddddddddddd");
		extractDataDao.departmentData();
		return "";
	}
	
	
	@RequestMapping(value="/setProfitData")
    @ResponseBody
	public String setProfitData(HttpServletRequest request){
		List list = (List) request.getAttribute("");
		extractDataDao.setProfitData(list);
		return "";
	}
	
	
	
	 String filePath = ExtractDataConter.class.getResource("/").getPath().replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/";
		
	 /**
	  * 文件上传
	  * @param uploadFile文件
	  * @param date时间
	  * @param type类型
	  * @param request
	  * @param response
	  * @return
	  */
	 @RequestMapping(value="/setProfitData1")
	 	@ResponseBody
	    public Map<String, Object> getParamFromFile(@RequestParam("uploadFile") MultipartFile uploadFile,String date,String type,HttpServletRequest request, HttpServletResponse response) {
	        Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
	        InputStream inputStream = null;
	         FileOutputStream outpurStream = null;
	 		date= date==null?new SimpleDateFormat("yyyyMM").format(new Date()):date;

	        try{
	            String filename = uploadFile.getName();
	            String originalFilename = uploadFile.getOriginalFilename();
	             
	            System.out.println("FileName = " + filename);
	            System.out.println("originalFilename = " + originalFilename);
	             
	            inputStream =  uploadFile.getInputStream();
	            if(type.indexOf("_2")!=-1){
	            	date = date.substring(0,4);
//	            	file = new File(filePath+date.substring(0,4)+type+".xls");
	            }
	            File file = new File(filePath+date+type+".xls");
	            
	            if(!file.exists())
	            	file.createNewFile();
	            outpurStream= new FileOutputStream(file);

	            FileOutputStream out=new FileOutputStream(file);
	            int c;
	            byte buffer[]=new byte[1024];
	            while((c=inputStream.read(buffer))!=-1){
	                for(int i=0;i<c;i++)
	                    out.write(buffer[i]);        
	            }
	        } catch (Exception e1) {
	            paramMap.put("message", "上传文件错误");
	            return paramMap;
	        }finally{
	        	try {
	        		if(outpurStream!=null){outpurStream.close();}
	        		if(inputStream!=null){inputStream.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        return paramMap;
	 	}
	//生成验证码图片  
		 @RequestMapping("/download") //对应/user/valicode.do请求  
		 @ResponseBody
		 private String download(HttpServletRequest request,HttpServletResponse response) {  
		        try {  
		            // 设置response的Header  
//		            response.addHeader("Content-Disposition", "attachment;'");  
//		            response.setContentType("application/vnd.ms-excel;charset=gb2312");  
//		            
		            response.setHeader("Content-disposition","attachment;filename=temp.xls");  
//		            response.setHeader("Content-Disposition", "attachment;filename="  
//		                    .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
		            
		            response.setContentType("application/excle");  
//		            System.out.println(con);
//					response.getWriter().print(con);
	//
//		    	    OutputStream os = response.getOutputStream();  
		        	
		        	 String filePath = ProfitImpl.class.getResource("/").getPath();
		    	  	  String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/5.xls";
		    	  	  InputStream inputstream = new FileInputStream(outFilePath);
		    	  	  OutputStream  os = response.getOutputStream();
		    	         // 获取模板  
		    	  	  HSSFWorkbook tempWorkBook = new HSSFWorkbook(inputstream);
		    	   
		    	  	  int tableNum = tempWorkBook.getNumberOfSheets();
		    	  	for (int k = 0; k < tableNum; k++) {
						if(tempWorkBook.getSheetAt(k).getSheetName().indexOf("_1")!=-1){
							tempWorkBook.setSheetHidden(k, 1);
//							tempWorkBook.removeSheetAt(k);
						}
					}
//					for (int k = 0; k < tableNum/2; k++) {
//						tempWorkBook.removeSheetAt(k);
//					}
//				     // 将内容写入Excel  
			        tempWorkBook.write(os);  
			        
			        os.flush();  
			        os.close();  
			        inputstream.close();
		    	    return "";
		        } catch (Exception ex) {  
		            ex.printStackTrace();  
		        }  
		        return null;
		 }
	
}
