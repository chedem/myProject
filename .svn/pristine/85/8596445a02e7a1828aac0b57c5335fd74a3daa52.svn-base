<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>子公司报表</title>
    
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
	  	<span>时间：</span><input type="text" id="startDate" readonly="readonly"><span>到</span><input type="text" id="endDate">
	  	   <input type="button" id ="dl" class='btn btn-info' onclick="zgsExecle()" style="color: #FFFFFF"; value="查看">
	  	</div>
     <div class="daochu_zhanshi">
     	<div class="daochu">
     	  <a href="jsp/execle/userFile/4.xls" download="子公司报表.xls">一键导出子公司报表</a>
   		</div>
    	<div id="lirun" class="zhanshi">
               
    	</div>
    </div>

  	</div>
              
           





                    
  </body>
 
  <script type="text/javascript" src="jsp/execle/js/execel.js"></script>
  <script type="text/javascript" src="welcome/js/jquery-1.11.1.min.js"></script>
   <script type="text/javascript" src="jsp/execle/laydate/laydate.js"></script>
   <script type="text/javascript" src="jsp/execle/js/bootstrap.min.js"></script>
  <script type="text/javascript"> 
  
  var myDate = new Date();//获取系统当前时间
/*   var s = new Date().setFullYear(myDate.getFullYear(), myDate.getMonth(), "");new Date(s)
 */  

 $("#startDate").val(myDate.getFullYear()+"-01");
  laydate.render({
	  elem: '#endDate'
	  ,type: 'month'
	  ,format: 'yyyy-MM'
	  ,value: myDate
	  ,btns: ['confirm']
	});
 </script>
</html>
