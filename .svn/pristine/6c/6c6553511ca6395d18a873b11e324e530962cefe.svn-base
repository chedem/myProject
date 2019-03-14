package com.common.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yrkj.profit.service.ProfitImpl;

@Component  
public class MonthJob {

	@Scheduled(cron = "0 0 16 * * 5 ") // 间隔5秒执行
//	@Scheduled(cron = "0 0 13 * * 3 ") // 间隔5秒执行
    public void monthJob1() throws IOException {  
		  String filePath = MonthJob.class.getResource("/").getPath();
	  	  String oldPath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/";
	  	  String newPath = filePath.replaceAll("webapps/web/WEB-INF/classes/", "")+"userFile/";
	  	  copyDir(oldPath,newPath);
    }  
	
	private void copyDir(String oldPath, String newPath) throws IOException {
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }
	  	  File fileDir = new File(oldPath);
		  File[] files = fileDir.listFiles();
		  for (File f : files) {
			  String name =f.getName();
			  if(f.isDirectory()){
				  copyDir(oldPath+"/"+name,newPath+"/"+name);
			  }else{
				  copyFile(oldPath+"/"+name,newPath+"/"+name);
			  }
		  }
    }
	
	
	private static void copyFile(String oldPath, String newPath) {
		FileInputStream in =null;
		FileOutputStream out = null;
        try {
			File oldFile = new File(oldPath);
			File file = new File(newPath);
			in = new FileInputStream(oldFile);
			out = new FileOutputStream(file);;
			byte[] buffer=new byte[1024];
			while((in.read(buffer)) != -1){
			    out.write(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
			if(out!=null){in.close();}
			if(in!=null){in.close();}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
        
    }
}
