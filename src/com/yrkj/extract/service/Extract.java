package com.yrkj.extract.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import jxl.Sheet;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;

public class Extract implements IExtract{

	 public void copy(Sheet formSheet, WritableSheet toWritableSheet) {
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
	                        wcfMap.put(cf.toString(), wcf);
	                    }
	                    toWritableSheet.addCell(new Label(columnIndex, rowIndex, cell.getContents(), wcf));
	                } catch (Exception e) {
	                    StringWriter sw = new StringWriter();
	                    PrintWriter pw = new PrintWriter(sw);
	                    e.printStackTrace(pw);
	                }
	            }
	        }
	    }
	    //===================抵消物装成套===========================================================

}
