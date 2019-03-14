<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>

  
  <body>
    This is my JSP page. <br>
    <input type="button" id ="dl" class="submit" onclick="dl()" style="color: #FFFFFF"; value="bumen">
        <input type="button" id ="dl" class="submit" onclick="dl1()" style="color: #FFFFFF"; value="xiangmu">
            <input type="button" id ="dl" class="submit" onclick="dl2()" style="color: #FFFFFF"; value="shujv">
    
        <br>
  
<div>
 <img alt="验证码" src="welcome/image.do"title="点击刷新验证码" style="cursor:hand;border-radius:2px" onclick="this.src='welcome/image.do?d='+Math.random();" width="100px" height="40px"></img> 
</div>
  </body>
  
  <a href="profit/downloadExelce.do?fileName=5" download="利润表.xls">利润表</a>
    
    <div width="400px" height="400px">
    	<div id="lirun" onclick="dl3()" style="width:1200px;height:400px;overflow:auto">safsadfsaf</div>
    </div>
    <textarea id ='sssss' style="width:300px;height:100px;overflow:auto"></textarea>
    
          <a id="file" href="profit/downloadExelce.do" download="利润表.xls">利润表</a>
    
  
  <script type="text/javascript" src="welcome/js/jquery-1.11.1.min.js"></script></head>
  
  <script type="text/javascript">
  
  function dl3(){
   	$.ajax({
	  	 	url:"profit/download.do?fileName=5",
	  	type:"get",
	  	data:{
	  		"type":"bu_men"
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  	alert(result);
		}, 
	  	success:function(result){
	  		$("#lirun").html(result);
	  		}
	  }); 
  }
		
		var bumen= null;
		var xiangmu = null;
		 function dl(){
 	$.ajax({
	  	//url:"http://localhost:8080/web/profit/getCompanyData.do",
	  	 	url:"profit/getCompanyData.do",
	  	type:"post",
	  	//contentType: "application/json; charset=utf-8", 
	  	data:{
	  		"type":"bu_men"
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  	alert(result);
		}, 
	  	success:function(result){
	  		alert("<div width='400px' height='400px'>"+result+"</div>");
	  		}
	  }); 
 
		}
  
  
		 function dl1(){
 	$.ajax({
	  	//url:"http://localhost:8080/web/profit/getCompanyData.do",
	  	 	url:"profit/getCompanyData.do",
	  	type:"post",
	  	//contentType: "application/json; charset=utf-8", 
	  	data:{
	  		"type":"xiang_mu"
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  	alert(result);
		}, 
	  	success:function(result){
	  		alert(result);
	  		}
	  }); 
 
		}
		
		
	function dl2(){
		
 	$.ajax({
	  	//url:"http://localhost:8080/web/profit/getCompanyData.do",
	  	 	url:"profit/getProfitData.do",
	  	type:"post",
	  	//contentType: "application/json; charset=utf-8", 
	  	data:{
	  		"lngaccountId":"1101",
	  		"lngdepartmentId":"220",
	  		"startDate":"2018-02-01",
	  		"endDate":"2018-02-28"
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  	alert(result);
		}, 
	  	success:function(result){
	  		alert(result);
	  		}
	  }); 
 
		}
</script>
		
</html>
