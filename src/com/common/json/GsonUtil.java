package com.common.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @title :Gson类库的封装工具
 * @author ligan
 * */
public class GsonUtil {

	private static Gson gson = null;
	
	static {
		if(gson == null){
			 gson = new GsonBuilder().disableHtmlEscaping().create();
		}
	}
	
	private GsonUtil(){
		
	}
	
	/**
	 * @title : 将对象转换成json格式
	 * @param : obj
	 * */
	public static String objectToJson(Object obj){
		String jsonStr = null;
		if(gson !=null){
			jsonStr = gson.toJson(obj);
		}
		return jsonStr;
	}
	
	/**
	 * @title : 将json格式转成List对象
	 * @param : jsonStr
	 * */
	public static List<?> jsonToList(String jsonStr){
		List<?> objList = null;
		if(gson !=null){
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<?>>(){}.getType();
			objList = gson.fromJson(jsonStr, type);
		}
		return objList;
	}
	
	/**
	 * @title : 将json格式转成map对象
	 * @param : jsonStr
	 * 
	 * */
	public static Map<?,?> jsonToMap(String jsonStr){
		Map<?,?> objMap = null;
		if(gson !=null){
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<?,?>>(){}.getType();
			objMap = gson.fromJson(jsonStr, type);
		}
		return objMap;
	}
	
	/**
	 * @title : 将json格式转换成bean对象
	 * @param : jsonStr
	 * */
	public static Object jsonToBean(String jsonStr,Class<?> cl){
		Object obj = null;
		if(gson != null){
			obj = gson.fromJson(jsonStr,cl);
		}
		return obj;
	}
	
	/**
	 * @title : 根据json格式 key获得value
	 * */
	public static Object getJsonValue(String jsonStr,String key){
		Object valueObj = null;
		Map<?,?> map = jsonToMap(jsonStr);
		if(map!=null && map.size()>0){
			valueObj = map.get(key);
		}
		return valueObj;
	}
	
	/**
	 * 接口返回统一格式
	 * @param result
	 * @param msg
	 * @return
	 */
	public static List<Map<String, String>> rtnMsg(String result, String msg){
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("RESULT", result);
		map.put("ERRORMSG", msg);
		map.put("ERRORCODE", "");
		list.add(map);
		return list;
	}
}
