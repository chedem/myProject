<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'budgets_lead.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="jsp/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="jsp/css/font-awesome.min.css" />
<link rel="stylesheet" href="jsp/css/jexcel/jquery.jexcel.css"
	type="text/css"></link>
<link rel="stylesheet" href="css/leading.css" type="text/css"></link>
<script type="text/javascript" src="jsp/js/jquery.min.js"></script>
<script src="jsp/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="jsp/js/xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="jsp/js/jexcel/jquery.jexcel.js"></script>
<script type="text/javascript" src="jsp/budget/budgets_leading.js/leading.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="dropdown col-sm-6">
				<input type="file" id="excel-file" onchange="importf(this)" />
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">预览</button>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-body">
							<label>请选择</label> <select id="sel" name="">

							</select>
						</div>
						<div class="modal-footer">
							<!--<button type="button" class="btn btn-default" >Close</button>-->
							<button id="btnOk" type="button" class="btn btn-primary"
								data-dismiss="modal">保存</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-2">
				<button id="btnSubmit" type="button" class="btn btn-primary">提交</button>
			</div>
		</div>
		<div id="my"></div>
	</div>
</body>
</html>


