package com.common.dao;

public class DynamicDataSourceHolder {
	  // 线程本地环境  
    private static final ThreadLocal contextHolder = new ThreadLocal();  
      
    // 设置数据源类型  
    public static void setDataSourceType(String dataSourceType) {  
        contextHolder.set(dataSourceType);  
    }  
  
    // 获取数据源类型  
    public static String getDataSourceType() {  
        return (String) contextHolder.get();  
    }  
  
    // 清除数据源类型  
    public static void clearDataSourceType() {  
        contextHolder.remove();  
    }  

}
