<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<!-- <body> -->
<body onunload="tc()">
 <div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						
						<!--   <form id="form1" action="login.do" method="post">
        					<p>用户名：<input name="userName" type="text" id="txtUserName" tabindex="1" size="15" value=""/></p>
        					<p>密　码：<input name="password" type="password" id="TextBox2" tabindex="2" size="16" value=""/></p>
       						 <p><input type="submit" value="登录">&nbsp<input type="reset" value="重置"></p>
    						</form> -->
    						
							<form action="login3.do" name="f" method="post">
						
							<div class="input_outer">
								<span class="u_user"></span>
								<input id ="user" name="logname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户" tabindex="1" size="15">
 							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id ="pass" name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><input type="submit" class="dlsubmit" style="color: #FFFFFF" value="登录"></div>
					<!-- 		<input type="reset" class="act-but submit" style="color: #FFFFFF" value="重置"></div>-->
<!-- 							<a id ="dl" class="act-but submit" href="javascript:dl();" style="color: #FFFFFF">登录</a> 
 -->						</form>
					</div>
				</div>
			</div>
		</div> 
		
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
	function tc() {
		alert("在此退出");
	}
		 function dl(){
		
 	$.ajax({
	  	url:"http://localhost:8080/web/profit/getCompanyData.do",
	  	type:"post",
	  	//contentType: "application/json; charset=utf-8", 
	  	data:{
	  		"user":$("#user").val(),
	  		"pass":$("#pass").val()
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  	debugger
	  	alert(result);
		//alert('Error loading document'); 
		}, 
	  	success:function(result){
	  		alert(result);
	  		//name=encodeURI(encodeURI(result));
	  		//alert(encodeURIComponent(result[2].name));
	  		//alert(result[2].name);
	  		//console.log(result); 
	  		}
	  }); 
 
		}
		/*  	  var resultYzm ="";
  $("#dl").click(function(){
  
 $.ajax({
	  
	  	url:"login.do",
	  	type:"post",
	  	data:{
	  		"user":$("#user").val(),
	  		"pass":$("#pass").val()
	  		},
	  	dataType: "json", 
	  	success:function(result){
	  		resultYzm=result;
	  		debugger
	  		alert(result);
	  		console.log(result); 
	  		}
	  }); 
  	});*/
		</script>
	</body>
</html>
