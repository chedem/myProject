package com.yrkj.profit.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import com.yrkj.code.bean.CodeBean;
import com.yrkj.profit.bean.CodeBeanList;
import com.yrkj.profit.dao.ProfitDao;

@Service
public class ProfitImpl implements IProfit{

	@Resource
	private  ProfitDao profitDao;
	
	public List getProfitData(HttpServletRequest request) {
		
		String lngaccountId  =request.getParameter("lngaccountId");
		String lngdepartmentId  =request.getParameter("lngdepartmentId");
		String startDate  =request.getParameter("startDate");
		String endDate  =request.getParameter("endDate");
//		String lngaccountId  ="1101";
//		String lngdepartmentId  ="103";
//		String startDate  ="2018-02-01";
//		String endDate  ="2018-02-28";
		return profitDao.getProfitData(lngaccountId, lngdepartmentId, startDate, endDate);
	}

	public List getCompanyData(HttpServletRequest request) {
		String type  =request.getParameter("type");
		List<CodeBean> list = profitDao.getCompanyData(type);
		CodeBeanList cbl = null;
		List<CodeBeanList> list1 = new ArrayList();
		for (CodeBean cb : list) {
			cbl = new CodeBeanList();
			cbl.setName(cb.getName());
			cbl.setCode(cb.getCode());
			List l = profitDao.getCB(cb.getCode(),type);
			cbl.setCbList(l);
			list1.add(cbl);
		}
		return list1;
	}

	public String getFile5(HttpServletRequest request, HttpServletResponse response) {
		 InputStream inputstream = null;
		 InputStream inputstream1 = null;

		 OutputStream  os = null;
		try {
			OutputStream output=response.getOutputStream();
			String startDate  =request.getParameter("startDate");
			String endDate  =request.getParameter("endDate");
			String fileName = request.getParameter("fileName");
			String filePath = ProfitImpl.class.getResource("/").getPath();
			File tempFile = new File(filePath+"com/file/"+fileName+".xls");
		  	inputstream = new FileInputStream(tempFile);
		  	  
		  	  String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/"+fileName+".xls";
		  	   os = new FileOutputStream(new File(outFilePath));
		         // 获取模板  
		  	  HSSFWorkbook tempWorkBook = new HSSFWorkbook(inputstream);
		  	  
		  	  File tempFile1 = new File(filePath+"com/file/"+fileName+"5.xls");
			  inputstream1 = new FileInputStream(tempFile1);
		  	  HSSFWorkbook tempWorkBook1 = new HSSFWorkbook(inputstream1);

		         // 获取模板sheet页  
		  	  HSSFSheet  tempSheet = tempWorkBook.getSheetAt(0);
		  	  List<String> listxm = new ArrayList<String>();
		  	  int rowNum=0;//获得项目总行数
		  	  
		  	  int tableNum = tempWorkBook.getNumberOfSheets();
		  	  
			    int cellNum = 0;//获取总列数
			    Row row = null; //获取要输入的每一行
			    Cell cell= null; //获取要输入的每一单元格
			  	String xmid=""; // //获取对应的项目id
			  	Row gsrow = null;//获取公司行
			  	Cell gscell= null;//获取公司单元格
			  	String gsid="";//获取公司id
			  	int xmNum = 0;//计算项目总长度
			  	int CellType=0;
		  	  for (int k = 0; k < tableNum; k++) {
		  		tempSheet = tempWorkBook.getSheetAt(k);
		  		
//		  		if(k%2==1){
		  			listxm = new ArrayList<String>();
		  			rowNum=tempSheet.getLastRowNum();//获得总行数
		  			for (int i = 0; i < rowNum; i++) {
		  				listxm.add(getCellValueByCell(tempSheet.getRow(i).getCell(1)));
		  			}
		  			
		  			
			  		tempSheet = tempWorkBook1.getSheetAt(k);

		  			xmNum = listxm.size();;//计算项目总长度
		  			gsrow = tempSheet.getRow(1);
					cellNum = gsrow.getPhysicalNumberOfCells();//获取总列数
					for (int i = 1; i < cellNum; i++) {
						gscell=gsrow.getCell(i);
						gsid = getCellValueByCell(gscell);
						if(!"".equals(gsid)){
							String[] gsDwId=gsid.split(",");
							for (int j = 3; j < xmNum; j++) {
//								System.out.println(k+":"+i+":"+j);
								row = tempSheet.getRow(j);
								cell = row.getCell(i);
								xmid=listxm.get(j); //获取对应的项目id
								CellType=cell.getCellType();
								if(!"".equals(xmid)&& CellType == Cell.CELL_TYPE_NUMERIC){
									cell.setCellValue(profitDao.getData(xmid, gsDwId[0], startDate, endDate,gsDwId[1]));
								}
								xmid="";

							}
							if(gsid.indexOf("单位：万元")!=-1){
								gscell.setCellValue("单位：万元");
							}else{
								gscell.setCellValue("");
							}
						}
						gsid="";
					}
		  			
//		  		}
//		  		else{
//		  			listxm = new ArrayList<String>();
//		  			rowNum=tempSheet.getLastRowNum();//获得总行数
//		  			for (int i = 0; i < rowNum; i++) {
//		  				listxm.add(getCellValueByCell(tempSheet.getRow(i).getCell(1)));
//			  	  }
//		  		}
		  			
		  	  }
		  	 
				evaluateFormulaCell(tempWorkBook1);//统计公式
//			     // 将内容写入Excel  
		        tempWorkBook1.write(os);  
		        os.flush();  
		        System.out.println("==========  成功        ===============");
		       return exeToHtml(outFilePath);		
		       
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				if(os!=null){os.close();}
				if(inputstream!=null){inputstream.close();}
				if(inputstream1!=null){inputstream1.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String getFile(HttpServletRequest request, HttpServletResponse response) {
		try {
			OutputStream output=response.getOutputStream();
			String startDate  =request.getParameter("startDate");
			String endDate  =request.getParameter("endDate");
			String fileName = request.getParameter("fileName");
			String userName="";
			return createExcel(startDate,endDate,fileName,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return null;
	}

	public String createExcel(String startDate, String endDate ,String fileName,String userName) throws Exception{
		  
	  	  String filePath = ProfitImpl.class.getResource("/").getPath();
		  File tempFile = new File(filePath+"com/file/"+userName+fileName+".xls");
	  	  InputStream inputstream = new FileInputStream(tempFile);
	  	  
	  	  String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/"+userName+fileName+".xls";
	  	  OutputStream  os = new FileOutputStream(new File(outFilePath));
	         // 获取模板  
	  	  HSSFWorkbook tempWorkBook = new HSSFWorkbook(inputstream);
	         // 获取模板sheet页  
	  	  HSSFSheet  tempSheet = tempWorkBook.getSheetAt(0);
	  	  List<String> listxm = new ArrayList<String>();
	  	  int rowNum=0;//获得项目总行数
	  	  
	  	  int tableNum = tempWorkBook.getNumberOfSheets();
	  	  
		    int cellNum = 0;//获取总列数
		    Row row = null; //获取要输入的每一行
		    Cell cell= null; //获取要输入的每一单元格
		  	String xmid=""; // //获取对应的项目id
		  	Row gsrow = null;//获取公司行
		  	Cell gscell= null;//获取公司单元格
		  	String gsid="";//获取公司id
		  	int xmNum = 0;//计算项目总长度
		  	int CellType=0;
	  	  for (int k = 0; k < tableNum; k++) {
	  		tempSheet = tempWorkBook.getSheetAt(k);
	  		
	  		if(k%2==1){
	  			xmNum = listxm.size();;//计算项目总长度
	  			gsrow = tempSheet.getRow(1);
				cellNum = gsrow.getPhysicalNumberOfCells();//获取总列数
				for (int i = 1; i < cellNum; i++) {
					gscell=gsrow.getCell(i);
					gsid = getCellValueByCell(gscell);
					if(!"".equals(gsid)){
						String[] gsDwId=gsid.split(",");
						for (int j = 3; j < xmNum; j++) {
							row = tempSheet.getRow(j);
							cell = row.getCell(i);
//							System.out.println(k+":"+i+":"+j);
							xmid=listxm.get(j); //获取对应的项目id
							CellType=cell.getCellType();
							if(!"".equals(xmid)&& CellType == Cell.CELL_TYPE_NUMERIC){
								cell.setCellValue(profitDao.getData(xmid, gsDwId[0], startDate, endDate,gsDwId[1]));
							}
							xmid="";

						}
						if(gsid.indexOf("单位：万元")!=-1){
							gscell.setCellValue("单位：万元");
						}else{
							gscell.setCellValue("");
						}
					}
					gsid="";
				}
	  			
	  		}else{
	  			listxm = new ArrayList<String>();
	  			rowNum=tempSheet.getLastRowNum();//获得总行数
	  			for (int i = 0; i < rowNum; i++) {
	  				listxm.add(getCellValueByCell(tempSheet.getRow(i).getCell(1)));
		  	  }
	  		}
	  			
	  	  }
	  	 
			evaluateFormulaCell(tempWorkBook);//统计公式
//	        tempSheet.removeRow(r);
//	        tempWorkBook.setForceFormulaRecalculation(true);//当打开是计算公式
	  	  
			for (int k = 0; k < tableNum/2; k++) {
				tempWorkBook.removeSheetAt(k);
			}
//		     // 将内容写入Excel  
	        tempWorkBook.write(os);  
	        
	        os.flush();  
	        os.close();  
	        inputstream.close();
	        
	        System.out.println("==========  成功        ===============");
	       return exeToHtml(outFilePath);
		}
	
	
	/**
	 * 统计公式
	 * @param tempWorkBook
	 */
	public void evaluateFormulaCell(HSSFWorkbook tempWorkBook ){
	  	int tableNum = tempWorkBook.getNumberOfSheets();
	  	Row row=null;
	  	Cell cell=null;
		HSSFSheet  tempSheet=null;
		int cellNum = 0 ;
		int rowNum = 0 ;
		
		HSSFFormulaEvaluator eval=new HSSFFormulaEvaluator(tempWorkBook);  
	  	  for (int k = 0; k <tableNum; k++) {
		  	tempSheet = tempWorkBook.getSheetAt(k);  
		  	row = tempSheet.getRow(2);
	  		cellNum = row.getPhysicalNumberOfCells();//获取总列数
			rowNum = tempSheet.getLastRowNum();//获得总行数
	        for (int i = 0; i < rowNum; i++) {
				row = tempSheet.getRow(i);
				if(row!=null){
					for (int j = 0; j < cellNum; j++) {
						cell = row.getCell(j);
						if(cell!=null&&cell.getCellType()==Cell.CELL_TYPE_FORMULA){
							try {
								eval.evaluateFormulaCell(cell);
							} catch (Exception e) {

							}  
						}
					}
				}
			}
		}
	}
	
	  //获取单元格各类型值，返回字符串类型
    private  String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
         
        switch (cellType) {
        case Cell.CELL_TYPE_STRING: //字符串类型
            cellValue= cell.getStringCellValue().trim();
            cellValue=StringUtils.isEmpty(cellValue) ? "" : cellValue; 
            break;
        case Cell.CELL_TYPE_BOOLEAN:  //布尔类型
            cellValue = String.valueOf(cell.getBooleanCellValue()); 
            break; 
        case Cell.CELL_TYPE_NUMERIC: //数值类型
                cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue()); 
            break;
        default: //其它类型，取空串吧
            cellValue = "";
            break;
        }
        return cellValue;
    }
    
    
    public  String exeToHtml(String file) throws Exception {

        InputStream input=new FileInputStream(file);
        HSSFWorkbook excelBook=new HSSFWorkbook(input);
        ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter (DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() );
        excelToHtmlConverter.processWorkbook(excelBook);
        
        Document htmlDocument =excelToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource (htmlDocument);
        StreamResult streamResult = new StreamResult (outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty (OutputKeys.ENCODING, "gbk");
        serializer.setOutputProperty (OutputKeys.INDENT, "yes");
        serializer.setOutputProperty (OutputKeys.METHOD, "html");
        serializer.transform (domSource, streamResult);
        outStream.close();

        String content = new String (outStream.toByteArray() );

        return content;
    }

    /**
     * 利润物装  抵消表
     */
	public String getFile4(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String startDate  =request.getParameter("startDate");
		String endDate  =request.getParameter("endDate");
		String fileName = request.getParameter("fileName");
		String userName="";
		
	  	  String filePath = ProfitImpl.class.getResource("/").getPath();
		  File tempFile = new File(filePath+"com/file/"+userName+fileName+".xls");
	  	  InputStream inputstream = new FileInputStream(tempFile);
	  	  
	  	  String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/"+userName+fileName+".xls";
	  	  OutputStream  os = new FileOutputStream(new File(outFilePath));
	         // 获取模板  
	  	  HSSFWorkbook tempWorkBook = new HSSFWorkbook(inputstream);
	         // 获取模板sheet页  
	  	  HSSFSheet  tempSheet = tempWorkBook.getSheetAt(0);
	  	  List<String> listxm = new ArrayList<String>();
	  	  int rowNum=0;//获得项目总行数
	  	  
	  	  int tableNum = tempWorkBook.getNumberOfSheets();
	  	  
		    int cellNum = 0;//获取总列数
		    Row row = null; //获取要输入的每一行
		    Cell cell= null; //获取要输入的每一单元格
		  	String xmid=""; // //获取对应的项目id
		  	Row gsrow = null;//获取公司行
		  	Cell gscell= null;//获取公司单元格
		  	String gsid="";//获取公司id
		  	int xmNum = 0;//计算项目总长度
		  	int CellType=0;
		  	
		  	String type = "";
	  	  for (int k = 0; k < tableNum; k++) {
	  		tempSheet = tempWorkBook.getSheetAt(k);
	  		
	  		if(k%2==1){
	  			xmNum = listxm.size();;//计算项目总长度
	  			gsrow = tempSheet.getRow(1);
				cellNum = gsrow.getPhysicalNumberOfCells();//获取总列数
				for (int i = 1; i < cellNum; i++) {
					gscell=gsrow.getCell(i);
					gsid = getCellValueByCell(gscell);
					if(!"".equals(gsid)){
						String[] gsDwId=gsid.split(",");
						for (int j = 3; j < xmNum; j++) {
							row = tempSheet.getRow(j);
							if(row==null){continue;}
							cell = row.getCell(i);
							if(cell==null){continue;}
							xmid=listxm.get(j); //获取对应的项目id
							CellType=cell.getCellType();
							if(!"".equals(xmid)&& CellType == Cell.CELL_TYPE_NUMERIC){
								if(type.indexOf("1")!=-1){
									cell.setCellValue(profitDao.getData4(xmid, gsDwId[0], startDate, endDate,gsDwId[1]));
								}else{
									System.out.println("ddddddddddddddddd");
								}
							}
							xmid="";
						}
						if(gsid.indexOf("单位：万元")!=-1){
							gscell.setCellValue("单位：万元");
						}else{
							gscell.setCellValue("");
						}
					}
					gsid="";
				}
	  			
	  		}else{
	  			type = tempSheet.getSheetName();
	  			listxm = new ArrayList<String>();
	  			rowNum=tempSheet.getLastRowNum();//获得总行数
	  			for (int i = 0; i < rowNum; i++) {
	  				listxm.add(getCellValueByCell(tempSheet.getRow(i).getCell(1)));
		  	  }
	  		}
	  			
	  	  }
	  	 
			evaluateFormulaCell(tempWorkBook);//统计公式
//	        tempWorkBook.setForceFormulaRecalculation(true);//当打开是计算公式
	  	  
			for (int k = 0; k < tableNum/2; k++) {
				tempWorkBook.removeSheetAt(k);
			}
//		     // 将内容写入Excel  
	        tempWorkBook.write(os);  
	        
	        os.flush();  
	        os.close();  
	        inputstream.close();
	        System.out.println("==========  成功        ===============");
	        
	        
	        hecheng(outFilePath);
	       return exeToHtml(outFilePath);
	}
	
	/**
	 * 成套  物装 抵消合并
	 * @param mobanFile
	 */
	public void hecheng(String mobanFile){
		  OutputStream os = null;
		  FileInputStream fis = null;
		  WritableWorkbook outputExcel =null;
		  try {
			    os = new FileOutputStream(new File(inputFilePath+"3-5.xls"));
	            outputExcel = Workbook.createWorkbook(os);
	            int index = 0;
                // 创建excel文件的工作簿对象book
	            fis = new FileInputStream(mobanFile);
                Workbook inputExcel = Workbook.getWorkbook(fis);
                // 获取excel文件工作簿的工作表数量sheets
                Sheet[] sheets = inputExcel.getSheets();
                for (Sheet sheet : sheets) {
                    WritableSheet writableSheet = outputExcel.createSheet(sheet.getName(), index);
                    copy(sheet, writableSheet);
                    index++;
                }
                
                //获取利润总表
                fis = new FileInputStream(inputFilePath+"5.xls");
                Workbook inputExcel1 = Workbook.getWorkbook(fis);
                Sheet sheet1 = inputExcel1.getSheet("利润-成套");
                WritableSheet writableSheet1 = outputExcel.createSheet(sheet1.getName(), index);
                copy(sheet1, writableSheet1);
                
                index++;
                Sheet sheet2 = inputExcel1.getSheet("费用-成套");
                WritableSheet writableSheet2 = outputExcel.createSheet(sheet2.getName(), index);
                copy(sheet2, writableSheet2);
                index++;
                
	            /** **********将以上缓存中的内容写到EXCEL文件中******** */
	            outputExcel.write();
	            /** *********关闭文件************* */
	        } catch (Exception e) {
	        }finally{
	        	try {
	        		if(outputExcel != null){outputExcel.close();}
	        		if(fis!=null){fis.close();}
	        		if(os!=null){os.close();}
	        	} catch (Exception e1) {
	        		e1.printStackTrace();
	        	}
	        	
	        }
	}
	
	  String filePath = ProfitImpl.class.getResource("/").getPath();
	  String inputFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/";
	public void motnToOne(HttpServletRequest request, HttpServletResponse response){
		  OutputStream os = null;
		  FileInputStream fis = null;
		  WritableWorkbook outputExcel =null;
		  try {
			    os = response.getOutputStream();
	            outputExcel = Workbook.createWorkbook(os);
	            int index = 0;
                // 创建excel文件的工作簿对象book
	            fis = new FileInputStream(inputFilePath+"5.xls");
                Workbook inputExcel = Workbook.getWorkbook(fis);
                // 获取excel文件工作簿的工作表数量sheets
                Sheet[] sheets = inputExcel.getSheets();
                for (Sheet sheet : sheets) {
//                	outputExcel.getSheet("");
                    WritableSheet writableSheet = outputExcel.createSheet(sheet.getName(), index);
                    copy(sheet, writableSheet);
                    index++;
                }
	            /** **********将以上缓存中的内容写到EXCEL文件中******** */
	            outputExcel.write();
	        } catch (Exception e) {
	        }finally{
	        	try {
	        		if(os!=null){os.close();}
	        		if(fis!=null){fis.close();}
	        		if(outputExcel!=null){outputExcel.close();}
	        	} catch (Exception e1) {
	        		e1.printStackTrace();
	        	}
	        	
	        }
	}
	
	/**
	 * 导出全部execl
	 * String filePath = ProfitImpl.class.getResource("/").getPath();
	 * String inputFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/";
	 */
	public void duoToOne(HttpServletRequest request,HttpServletResponse response) {
		String date  =request.getParameter("date");
		String type  =request.getParameter("type");
		  response.reset();  
          //指明这是一个下载的respond  
          response.setContentType("application/x-download");  
          response.setCharacterEncoding("UTF-8");  
          response.setHeader("Content-type", "text/html;charset=UTF-8");  
          response.setHeader("Content-Disposition","attachment;filename="+date+".xls"); 
          
		OutputStream  os =null;
		FileOutputStream  os1 =null;
		InputStream inputstream =null;
		InputStream mbInputstream =null;
		HSSFWorkbook wb=null;
		  try {
			  os =response.getOutputStream();
			  
			     // 获取模板sheet页  
			  mbInputstream = new FileInputStream(new File(filePath+"com/file/2.xls"));
			 wb=new HSSFWorkbook(mbInputstream);  
			HSSFSheet  wbSheet =  wb.getSheet("利润表-汇总");
			Cell cell = wbSheet.getRow(1).getCell(2);
			cell.setCellValue(date);
				
			 HSSFWorkbook tempWorkBook =null;
				//成套  物装
			try {
				inputstream = new FileInputStream(new File(inputFilePath+"3-5.xls"));
				tempWorkBook = new HSSFWorkbook(inputstream);
				for (int i = 0; i < tempWorkBook.getNumberOfSheets(); i++) {//获取每个Sheet表
					HSSFSheet  tempSheet =  tempWorkBook.getSheetAt(i);
					HSSFSheet  tempSheetNew =  wb.getSheet(tempSheet.getSheetName());
					copyRows(tempSheet,tempSheetNew);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			
		//  抵消表
			 try {
				inputstream = new FileInputStream(new File(inputFilePath+date+"_1.xls"));
				tempWorkBook = new HSSFWorkbook(inputstream);
				for (int j = 0 ,num=tempWorkBook.getNumberOfSheets(); j< num; j++) {//获取每个Sheet表
					HSSFSheet  tempSheet =  tempWorkBook.getSheetAt(j);
					HSSFSheet  tempSheetNew =  wb.getSheet(tempSheet.getSheetName());
					copyRows(tempSheet,tempSheetNew);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 //预算表  
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
			  Date dt=sdf.parse(date);
			  Calendar rightNow = Calendar.getInstance();
			  rightNow.setTime(dt);
			  rightNow.add(Calendar.YEAR,-1);//日期减1年
//			  rightNow.add(Calendar.MONTH,3);//日期加3个月
//			  rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
			  Date dt1=rightNow.getTime();
			  String reStr = sdf.format(dt1);

			  try {
				inputstream = new FileInputStream(new File(inputFilePath+date.substring(0,4)+type+".xls"));
				tempWorkBook = new HSSFWorkbook(inputstream);
				for (int j = 0 ,num=tempWorkBook.getNumberOfSheets(); j< num; j++) {//获取每个Sheet表
					HSSFSheet  tempSheet =  tempWorkBook.getSheetAt(j);
					HSSFSheet  tempSheetNew =  wb.getSheet(tempSheet.getSheetName());
					copyRows(tempSheet,tempSheetNew);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
			  
			  //同期表
			 try {
				inputstream = new FileInputStream(new File(inputFilePath+reStr+"-2.xls"));
				tempWorkBook = new HSSFWorkbook(inputstream);
				HSSFSheet  tempSheet =  tempWorkBook.getSheet("利润表-汇总");
				HSSFSheet  tempSheetNew =  wb.getSheet("同期利润");
				copyRows(tempSheet,tempSheetNew);
				
				HSSFSheet  tempSheet1 =  tempWorkBook.getSheet("费用表-汇总");
				HSSFSheet  tempSheetNew1 =  wb.getSheet("同期费用");
				copyRows(tempSheet1,tempSheetNew1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			 
			 
			evaluateFormulaCell(wb);//统计公式
			File f =new File(inputFilePath+date+"-1.xls");
			os1 = new FileOutputStream(f);
			wb.write(os1);
			wb.write(os);  
			
			System.out.println("===========下载成功=============");
		} catch (Exception e) {
		}finally{
			try {
				if(os!=null){os.close();}
				if(os1!=null){os1.close();hecheng1(date);}
				if(inputstream!=null){inputstream.close();}
				if(mbInputstream!=null){mbInputstream.close();}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	
	/**
	 * 成套  物装 抵消合并
	 * @param mobanFile
	 */
	public void hecheng1(String date){
		  OutputStream os = null;
		  FileInputStream fis = null;
		  WritableWorkbook outputExcel =null;
		  try {
			    os = new FileOutputStream(new File(inputFilePath+date+"-2.xls"));
	            outputExcel = Workbook.createWorkbook(os);
	            int index = 0;
                // 创建excel文件的工作簿对象book
	            fis = new FileInputStream(inputFilePath+date+"-1.xls");
                //获取利润总表
                Workbook inputExcel1 = Workbook.getWorkbook(fis);
                Sheet sheet1 = inputExcel1.getSheet("利润表-汇总");
                WritableSheet writableSheet1 = outputExcel.createSheet(sheet1.getName(), index);
                copy(sheet1, writableSheet1);
                
                index++;
                Sheet sheet2 = inputExcel1.getSheet("费用表-汇总");
                WritableSheet writableSheet2 = outputExcel.createSheet(sheet2.getName(), index);
                copy(sheet2, writableSheet2);
                index++;
                
	            /** **********将以上缓存中的内容写到EXCEL文件中******** */
	            outputExcel.write();
	            /** *********关闭文件************* */
	        } catch (Exception e) {
	        }finally{
	        	try {
	        		if(outputExcel != null){outputExcel.close();}
	        		if(fis!=null){fis.close();}
	        		if(os!=null){os.close();}
	        	} catch (Exception e1) {
	        		e1.printStackTrace();
	        	}
	        	
	        }
	}
	
	/**
     * @introduction: 将多个Excel文件中的sheel合并到一个Excel中（例：Excel1有2个sheel,Excel2有3个sheel，合并后的会有5个）
     * @param outputFileName
     * @param inputFileNameArray
     */
    public static void mergeExcel(String outputFileName, String... inputFileNameArray) {
        if (inputFileNameArray.length == 1) {
//            logger.info("至少需要两个文件才能合并，请验证！！！");
            return;
        }
        try {
            WritableWorkbook outputExcel = Workbook.createWorkbook(new File(outputFileName));
            int index = 0;
            for (String fileName : inputFileNameArray) {
                // 创建excel文件的工作簿对象book
                Workbook inputExcel = Workbook.getWorkbook(new FileInputStream(fileName));
                // 获取excel文件工作簿的工作表数量sheets
                Sheet[] sheets = inputExcel.getSheets();
                for (Sheet sheet : sheets) {
                    WritableSheet writableSheet = outputExcel.createSheet(sheet.getName(), index);
                    copy(sheet, writableSheet);
                    index++;
                }
            }
            /** **********将以上缓存中的内容写到EXCEL文件中******** */
            outputExcel.write();
            /** *********关闭文件************* */
            outputExcel.close();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
        }
    }

    //===================抵消物装成套===========================================================
    private static void copy(Sheet formSheet, WritableSheet toWritableSheet) {
        // 行数
        int rows = formSheet.getRows();
        // 列数
        int columns = formSheet.getColumns();
        HashMap<String, WritableCellFormat> wcfMap = new HashMap<String, WritableCellFormat>();
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                // 获取当前工作表.row_index,column_index单元格的cell对象
            	jxl.Cell cell = formSheet.getCell(columnIndex, rowIndex);
                try {
                	 CellFormat cf = cell.getCellFormat();
                	 WritableCellFormat wcf =new WritableCellFormat();;
                    
                    if (wcfMap.containsKey(cf.toString())) {
                        wcf = wcfMap.get(cf.toString());
                    } else {
                        wcf = new WritableCellFormat(cf); // 设置数字格式，例如："#0.00"
//                        wcf.getNumberFormat().setParseIntegerOnly(true);
                        wcfMap.put(cf.toString(), wcf);
                    }
//                    if(cell.getType()==CellType.NUMBER ||cell.getType()==CellType.NUMBER_FORMULA){  
//                        toWritableSheet.addCell(new jxl.write.Number(columnIndex, rowIndex, cell.getContents().replace(",", "").indexOf("-")==-1?Double.valueOf(cell.getContents().replace(",", "")):-Double.valueOf(cell.getContents().replace(",", "")), wcf));
//                    }else{
                    	toWritableSheet.addCell(new Label(columnIndex, rowIndex, cell.getContents().replace(",", ""), wcf));
//                    }
                } catch (Exception e) {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    e.printStackTrace(pw);
                }
            }
        }
    }
    //===================抵消物装成套===========================================================

	
	 public void copyRows(  HSSFSheet fromsheet, HSSFSheet newsheet ) {
		  newsheet.autoSizeColumn(0);//宽度自适应
		  HSSFWorkbook wook = newsheet.getWorkbook();
		  HSSFCellStyle style =wook.createCellStyle();
		  HSSFCellStyle style1 =wook.createCellStyle();
		  style.setDataFormat( HSSFDataFormat.getBuiltinFormat("#,##0.00"));
		  style1.setDataFormat( HSSFDataFormat.getBuiltinFormat("#,##0.00"));
		  
		  style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		  style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		  style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		  style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		  
		  style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		  style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		  style1.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		  style1.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

		  HSSFFont font = wook.createFont(); 
		  font.setFontHeightInPoints((short) 9);//设置字体大小
		  font.setFontName("宋体"); 
		  style.setFont(font);//选择需要用到的字体格式
		  style1.setFont(font);//选择需要用到的字体格式
		  

		  style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
          style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
           
	        int firstrow = fromsheet.getFirstRowNum(); 
	        int lastrow = fromsheet.getLastRowNum();
	        if ((firstrow == -1) || (lastrow == -1) || lastrow < firstrow) {
	            return;
	        }
	        HSSFRow fromRow = null;
	        HSSFRow newRow = null;
	        HSSFCell newCell = null;
	        HSSFCell fromCell = null;
	        // 拷贝行并填充数据
	        for (int i = 0; i <= lastrow; i++) {
	            fromRow = fromsheet.getRow(i);
	            if (fromRow == null) {
	                continue;
	            }
	            newRow = newsheet.createRow(i - firstrow);
	            newRow.setHeight(fromRow.getHeight());
	            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {
	                fromCell = fromRow.getCell(j);
	                if (fromCell == null) {
	                    continue;
	                }
	             
	                newCell = newRow.createCell(j);
	                
	                if(fromCell.getCellStyle().getFillPattern()==0){
	                	newCell.setCellStyle(style1);
	                }else{
	                	newCell.setCellStyle(style);
	                }
	                int cType = fromCell.getCellType();
//	                newCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
	                newCell.setCellType(cType);
//	                newsheet.autoSizeColumn(0);//宽度自适应
	                switch (cType) {
	                case HSSFCell.CELL_TYPE_STRING:
	                	 try {
	                		 String value = fromCell.getRichStringCellValue().toString();
	                		 if(value.indexOf("(")!=-1){
	                			 value = value.replace("(", "").replace(")", "").replace(",", "");
	                			 newCell.setCellValue(-Double.valueOf(value));
	                		 }else{
	                			 newCell.setCellValue(Double.valueOf(value.replace(",", "")));
	                		 }
//								newCell.setCellValue(Double.valueOf("".equals(fromCell.getRichStringCellValue().toString())?"0.00":fromCell.getRichStringCellValue().toString()));
							} catch (Exception e) {
								newCell.setCellValue(fromCell.getRichStringCellValue());
							}
	                    break;
	                case HSSFCell.CELL_TYPE_NUMERIC:
	                    newCell.setCellValue(fromCell.getNumericCellValue()==0.0d?0.0d:fromCell.getNumericCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_FORMULA:
	                	 try {
							newCell.setCellValue(fromCell.getNumericCellValue());
						} catch (Exception e) {
							newCell.setCellFormula(fromCell.getCellFormula());
						}
	                    break;
	                case HSSFCell.CELL_TYPE_BOOLEAN:
	                    newCell.setCellValue(fromCell.getBooleanCellValue());
	                    break;
	                case HSSFCell.CELL_TYPE_ERROR:
	                    newCell.setCellValue(fromCell.getErrorCellValue());
	                    break;
	                default:
	                	if(i>2){
               			 	newCell.setCellValue(fromCell.getNumericCellValue());
	                	}else{
	                		newCell.setCellValue(fromCell.getRichStringCellValue());
	                	}
	                    break;
	                }
	            }
	        }
	    }
	 
	 
	 public HSSFCellStyle copyCellStyle(HSSFCellStyle fromStyle,  
	            HSSFCellStyle toStyle) {  
//	        toStyle.setAlignment(fromStyle.getAlignment());  
//	        //边框和边框颜色  
//	        toStyle.setBorderBottom(fromStyle.getBorderBottom());  
//	        toStyle.setBorderLeft(fromStyle.getBorderLeft());  
//	        toStyle.setBorderRight(fromStyle.getBorderRight());  
//	        toStyle.setBorderTop(fromStyle.getBorderTop());  
//	        toStyle.setTopBorderColor(fromStyle.getTopBorderColor());  
//	        toStyle.setBottomBorderColor(fromStyle.getBottomBorderColor());  
//	        toStyle.setRightBorderColor(fromStyle.getRightBorderColor());  
//	        toStyle.setLeftBorderColor(fromStyle.getLeftBorderColor());  
	          
	        //背景和前景  
	        toStyle.setFillBackgroundColor(fromStyle.getFillBackgroundColor());  
	        toStyle.setFillForegroundColor(fromStyle.getFillForegroundColor());  
	        toStyle.setFillPattern(fromStyle.getFillPattern()); 

	          
//	        toStyle.setDataFormat(fromStyle.getDataFormat());  
//	        toStyle.setFillPattern(fromStyle.getFillPattern());  
////	      toStyle.setFont(fromStyle.getFont(null));  
//	        toStyle.setHidden(fromStyle.getHidden());  
//	        toStyle.setIndention(fromStyle.getIndention());//首行缩进  
//	        toStyle.setLocked(fromStyle.getLocked());  
//	        toStyle.setRotation(fromStyle.getRotation());//旋转  
//	        toStyle.setVerticalAlignment(fromStyle.getVerticalAlignment());  
//	        toStyle.setWrapText(fromStyle.getWrapText());  
	          
	        return toStyle;
	    }

	public String getFile6(HttpServletRequest request,
			HttpServletResponse response) {
		
		String startDate  =request.getParameter("startDate");
		String endDate  =request.getParameter("endDate");
		String fileName = request.getParameter("fileName");
	    OutputStream  os =null;
	    HSSFWorkbook tempWorkBook = null;
		try {

			List<Object[]> list = profitDao.getData6(startDate,endDate);

			String filePath = ProfitImpl.class.getResource("/").getPath();
			String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/6.xls";
			os = new FileOutputStream(new File(outFilePath));
			
			 tempWorkBook = new HSSFWorkbook();

			 HSSFCellStyle style =tempWorkBook.createCellStyle();
			 style.setDataFormat( HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			 
			HSSFSheet sheet = getSheet(tempWorkBook,"应收账款余额",endDate);
			HSSFSheet newSheet = getSheet(tempWorkBook,"应收账款余额（重分类）",endDate);

			setVale(list,sheet,style,0);
			setVale(list,newSheet,style,1);
			
			
			
			evaluateFormulaCell(tempWorkBook);//统计公式

		    tempWorkBook.write(os);  
		    os.flush();  
		    os.close();  
		    System.out.println("==========  成功        ===============");
		   return exeToHtml(outFilePath);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(os==null){os.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}  
	
	private void setVale(List<Object[]> list,HSSFSheet sheet ,HSSFCellStyle style ,int type){
		int i = 4;
		Row row = null;
		Cell cell= null;
		for (Object[] o : list) {
			if("0".equals(o[1].toString())&&o[1]==o[2]&&o[3]==o[4]&&o[5]==o[6]&&o[1]==o[3]&&o[3]==o[5]){continue;}
			row = sheet.createRow(i);

			for (int k = 0,num=o.length; k <num ; k++) {
				if(o[k]==null){continue;}
			
				cell = row.createCell(k);
				try {
					
					cell.setCellValue(Double.valueOf(o[k].toString()));
					cell.setCellStyle(style);
				} catch (Exception e) {
					cell.setCellValue(o[k].toString());
				}
			}
			if(type==1){
				Double d = Double.valueOf(o[o.length-1].toString());
				if(d<0){
				}else{
					i++;
				}
			}else{
				i++;
			}
		}
		
		int hji= i;
		row = sheet.createRow(hji);
		String[] str ={	"合计","SUM(B5:B"+(i-1)+")","SUM(C5:C"+hji+")","SUM(D5:D"+hji+")","SUM(E5:E"+hji+")","SUM(F5:F"+hji+")","SUM(G5:G"+hji+")"};
		cell = row.createCell(0);
		cell.setCellValue(str[0]);
		
		
		HSSFFormulaEvaluator eval=new HSSFFormulaEvaluator(sheet.getWorkbook());  
		for (int k = 1,num= str.length; k <num; k++) {
			cell = row.createCell(k);
			cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
			cell.setCellFormula(str[k]);
			cell.setCellStyle(style);
			eval.evaluateFormulaCell(cell);
		}
		
	}
	private HSSFSheet getSheet( HSSFWorkbook tempWorkBook,String sheetName,String endDate){
		
		HSSFCellStyle cellStyle = tempWorkBook.createCellStyle(); 
//		HSSFFont font = tempWorkBook.createFont();    
//		font.setFontName("仿宋");    
//		font.setFontHeightInPoints((short) 12);//设置字体大小    
//		cellStyle.setFont(font);//选择需要用到的字体格式  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		
		HSSFSheet sheet = tempWorkBook.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);  
		sheet.setDefaultRowHeightInPoints(15);  
		
		Cell c = sheet.createRow(0).createCell(0);
		c.setCellValue(sheetName);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));  
		c.setCellStyle(cellStyle);


		Row row = sheet.createRow(2);
		c = row.createCell(0);
		c.setCellValue("日期："+endDate);
		c = row.createCell(1);
		c.setCellValue("单位：万元");
		c = row.createCell(6);
		c.setCellValue("科目名称：1122应收账款");
		
		row = sheet.createRow(3);
		String[] str ={	"单位名称","期初余额","本期借方发生","本期贷方发生","借方累计","贷方累计","期末余额"};
		for (int i = 0,num=str.length; i < num; i++) {
			c = row.createCell(i);
			c.setCellValue(str[i]);
		}
		

		return sheet;
	}

	public String getFile7(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String startDate  =request.getParameter("startDate");
		String endDate  =request.getParameter("endDate");
	    OutputStream  os =null;
	    HSSFWorkbook tempWorkBook = null;
		try {

			List<Object[]> list = profitDao.getData7(startDate,endDate);

			String filePath = ProfitImpl.class.getResource("/").getPath();
			String outFilePath = filePath.replaceAll("WEB-INF/classes/", "")+"jsp/execle/userFile/7.xls";
			os = new FileOutputStream(new File(outFilePath));
			
			 tempWorkBook = new HSSFWorkbook();

			 HSSFCellStyle style =tempWorkBook.createCellStyle();
			 style.setDataFormat( HSSFDataFormat.getBuiltinFormat("#,##0.00"));
			 
			 HSSFCellStyle cellStyle = tempWorkBook.createCellStyle(); 
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
				
				HSSFSheet sheet = tempWorkBook.createSheet("应收账款余额表（统计基础表）");
				sheet.setDefaultColumnWidth(20);  
				sheet.setDefaultRowHeightInPoints(15);  
				
				Cell c = sheet.createRow(0).createCell(0);
				c.setCellValue("应收账款余额表（统计基础表）");
				sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));  
				c.setCellStyle(cellStyle);


				Row row = sheet.createRow(2);
				c = row.createCell(0);
				c.setCellValue("日期："+endDate);
				c = row.createCell(1);
				c.setCellValue("单位：万元");
				c = row.createCell(6);
				c.setCellValue("科目名称：1122应收账款");
				
				row = sheet.createRow(3);
				String[] str ={	"部门名称","单位名称","期初余额","本期借方发生","本期贷方发生","借方累计","贷方累计","期末余额"};
				for (int i = 0,num=str.length; i < num; i++) {
					c = row.createCell(i);
					c.setCellValue(str[i]);
				}			
				

				int i = 4;
				 row = null;
				Cell cell= null;
				for (Object[] o : list) {
					System.out.println(i);
					if("0".equals(o[7].toString())&&o[7]==o[2]&&o[3]==o[4]&&o[5]==o[6]&&o[7]==o[3]&&o[3]==o[5]){continue;}
					row = sheet.createRow(i);

					for (int k = 0,num=o.length; k <num ; k++) {
						if(o[k]==null){continue;}
					
						cell = row.createCell(k);
						try {
							
							cell.setCellValue(Double.valueOf(o[k].toString()));
							cell.setCellStyle(style);
						} catch (Exception e) {
							cell.setCellValue(o[k].toString());
						}
					}
					Double d = Double.valueOf(o[o.length-1].toString());
					if(d<0){
					}else{
						i++;
					}				}
				
				int hji= i;
				row = sheet.createRow(hji);
				String[] str1 ={	"合计","SUM(B5:B"+(i-1)+")","SUM(C5:C"+hji+")","SUM(D5:D"+hji+")","SUM(E5:E"+hji+")","SUM(F5:F"+hji+")","SUM(G5:G"+hji+")","SUM(H5:H"+hji+")"};
				cell = row.createCell(0);
				cell.setCellValue(str1[0]);
				
				
				HSSFFormulaEvaluator eval=new HSSFFormulaEvaluator(sheet.getWorkbook());  
				for (int k = 2,num= str.length; k <num; k++) {
					cell = row.createCell(k);
					cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
					cell.setCellFormula(str1[k]);
					cell.setCellStyle(style);
					eval.evaluateFormulaCell(cell);
				}

		    tempWorkBook.write(os);  
		    os.flush();  
		    os.close();  
		    System.out.println("==========  成功        ===============");
		   return exeToHtml(outFilePath);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(os==null){os.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	 
	 
}
