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
<base href="<%=basePath%>">

<title>My JSP 'allDownload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="jsp/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="jsp/css/font-awesome.min.css" />
<link rel="stylesheet" href="jsp/css/jexcel/jquery.jexcel.css"
	type="text/css"></link>
<style>
	#seltype{
		width: 150px;
		height: 30px;
		line-height: 30px;
		font-size: 16px;
	}
</style>
</head>

<body>
	<div class="container-fluid">
		<form id="postForm" class="form-inline row"
			action="extract/setProfitData1.do" method="post"
			enctype="multipart/form-data">
			<div class="form-group col-sm-3">
				<label for="#downDate">时间：</label><input class="form-control" type="text"
					id="downDate" name="downDate">
			</div>
			<div class="form-group col-sm-3">
				<label for="type">请选择：</label> 
				<select id="seltype" name="type">
					<option value="_201">预算目标表</option>
					<option value="_202">奋斗目标表</option>
				</select>
			</div>
			<div>
				<span id="messageTip" hidden="true"></span> <input
					class="btn btn-primary" type="button" value="下载"
					onclick="dowdload()" />
			</div>
		</form>
		<div id="my"></div>
	</div>
	<script type="text/javascript" src="jsp/js/jquery.min.js"></script>
	<script type="text/javascript" src="jsp/execle/laydate/laydate.js"></script>
	<script src="jsp/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		function dowdload(){
         var date1 = "date="+$("#downDate").val()+"&type="+$("#seltype").val();
          this.window.open(  "<%=basePath%>profit/downloadExelce.do?" + date1);
		}
		var toDate = new Date();//获取系统当前时间
		laydate.render({
			elem : '#downDate',
			type : 'month',
			format : 'yyyyMM',
			value : toDate,
			btns : [ 'confirm' ]
		});
	</script>
</body>
</html>
