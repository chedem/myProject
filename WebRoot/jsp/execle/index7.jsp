<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>应收账款余额表（统计基础表）</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  <link rel="stylesheet" href="jsp/execle/css/execel.css" type="text/css"></link>
  <link rel="stylesheet" href="jsp/execle/css/bootstrap.min.css" type="text/css"></link>
  <body>

  	<div class="bodys">
	  	<div class="tiaojian">
	  	<span>时间：</span><input type="text" id="startDate1" ><span>到</span><input type="text" id="endDate">
	  	   <input type="button" id ="dl" class='btn btn-info' onclick="tjjcfExecle()" style="color: #FFFFFF"; value="查看">
	  	</div>
     <div class="daochu_zhanshi">
     	<div class="daochu">
     	  <a href="jsp/execle/userFile/7.xls" download="应收账款余额表（统计基础表）.xls">一键导出应收账款余额表（统计基础表）</a>
   		</div>
    	<div id="lirun" class="zhanshi">
               
    	</div>
    </div>

  	</div>
              
           





                    
  </body>
 
  <script type="text/javascript" src="jsp/execle/js/execel6.js"></script>
  <script type="text/javascript" src="welcome/js/jquery-1.11.1.min.js"></script>
   <script type="text/javascript" src="jsp/execle/laydate/laydate.js"></script>
   <script type="text/javascript" src="jsp/execle/js/bootstrap.min.js"></script>
  <script type="text/javascript"> 
  
  var myDate = new Date();//获取系统当前时间
/*   var s = new Date().setFullYear(myDate.getFullYear(), myDate.getMonth(), "");new Date(s)
 */  

  laydate.render({
	  elem: '#startDate1'
	  ,type: 'date'
	  ,format: 'yyyy-MM-dd'
	  ,value: myDate.getFullYear()+"-01-01"
	  ,btns: ['confirm']
	});
	
  laydate.render({
	  elem: '#endDate'
	  ,type: 'date'
	  ,format: 'yyyy-MM-dd'
	  ,value: myDate
	  ,btns: ['confirm']
	});
 </script>
</html>