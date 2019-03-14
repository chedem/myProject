<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="../css/animate.css" rel="stylesheet">
<link href="../css/style.css?v=4.1.0" rel="stylesheet">
<link rel="stylesheet" href="css/login.css" />
</head>
<body class="login-bg">
	<div id="textMain">
		<h1>报表平台</h1>
		<footer>BAOBIAOPINGTAI</footer>
	</div>
	<div class="middle-box text-center loginscreen animated fadeInDown">
		<div>
			<div>
				<h1 class="logo-name">CPCEC</h1>
			</div>
			<h3>欢迎使用CPCEC</h3>
			<form class="m-t" role="form"
				action="<%=basePath%>welcome/login3.do" method="post">
				<div class="form-group">
					<input type="text" name="logname" class="form-control"
						placeholder="用户名" required>
				</div>
				<div class="form-group">
					<input type="password" name="logpass" class="form-control"
						placeholder="密码" required>
				</div>
				<button id="getLogin" type="submit"
					class="btn btn-primary block full-width m-b" onclick="sendName()">登 录</button>
			</form>
			<p class="text-muted text-center">
				<a href="login.html#"><small>忘记密码了？</small> </a> | <a
					href="register.html">注册一个新账号</a>
			</p>
		</div>
	</div>
	<!-- 全局js -->
	<script src="../js/jquery.min.js?v=2.1.4"></script>
	<script src="../js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript"
		src="../js/plugins/cookie/jquery.cookie.js"></script>
	<script>
		function sendName() {
			let uName = $("[name=logname]").val();
			$.cookie('name', uName, {
				path : '/',
				secure : false
			});

		}
	</script>
	<!-- <script type="text/javascript" src="js/login.js"></script> -->
</body>
</html>
