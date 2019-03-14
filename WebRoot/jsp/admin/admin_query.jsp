<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>My JSP 'admin_query.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="favicon.ico">
<link href="jsp/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="jsp/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="jsp/css/animate.css" rel="stylesheet">
<link href="jsp/css/style.css?v=4.1.0" rel="stylesheet">
<link rel="stylesheet" href="jsp/admin/css/adminQuery.css" type="text/css"></link>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="container-fluid">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h3>管理员用户列表</h3>
					<div class="ibox-tools">
						<button id="btnAdd" type="button" class="btn btn-primary"
							data-toggle="modal" data-target="#add_admin">
							<i class="glyphicon glyphicon-plus"></i>
						</button>
						<button id="btnUpdate" type="button" class="btn btn-default"
							data-toggle="modal" data-target="#update_admin">
							<i class="glyphicon glyphicon-align-justify"></i>
						</button>
						<button id="btnDel" type="button" class="btn btn-danger">
							<i class="glyphicon glyphicon-trash"></i>
						</button>
					</div>
				</div>
				<div id="selOrPower" class="ibox-content">
					<div class="tableDiv">
						<table id="adminShow" class="table table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>用户ID</th>
								<th>用户名</th>
								<th>生效时间</th>
								<th>失效时间</th>
								<th>是否生效</th>
								<th>性别</th>
								<th>手机号</th>
								<th>E-mail</th>
								<!-- <th>部门</th> -->
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					</div>
					<div id="powerSet">
						<form id="powerForm" action="">
							<div><b>权限</b></div>
						<div id="">
							<input name="a" type="checkbox" value="100"><span>子公司报表</span>
						</div>
						<div id="">
							<input name="a" type="checkbox" value="101"><span>物装报表</span>
						</div>
						<div id="">
							<input name="a" type="checkbox" value="102"><span>成套报表</span>
						</div>
						<div id="">
							<input name="a" type="checkbox" value="103"><span>总表</span>
						</div>
						<div id="">
							<input name="a" type="checkbox" value="104"><span>应收账款余额表</span>
						</div>
						<div id="">
							<input name="a" type="checkbox" value="105"><span>应收账款余额表（统计基础表）</span>
						</div>
						<div>
							<button id="addPower" type="button" class="btn btn-primary">添加权限</button>
							<button id="delPower" type="button" class="btn btn-danger">删除权限</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加管理员 -->
	<div id="add_admin" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">新增管理员</h4>
				</div>
				<div class="modal-body">
					<form id="addForm" class="form-horizontal m-t" autocomplete='off'>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-8">
								<input id="addName" name="addName" class="form-control"
									type="text" placeholder="请输入用户名">
								<span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">登录密码：</label>
							<div class="col-sm-8">
								<input id="addPwd" name="addPwd" class="form-control"
									type="password" placeholder="请输入密码">
									<span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">生效时间：</label>
							<div class="col-sm-8">
								<input id="startTime" name="startTime" class="form-control"
									type="date">
									<span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">失效时间：</label>
							<div class="col-sm-8">
								<input id="endTime" name="endTime" class="form-control"
									type="date">
									<span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否生效：</label>
							<div id="state" class="col-sm-8">
								<input name="state"
									type="radio" value="1" checked>是
								<input class="jg" name="state"
									type="radio" value="1">否
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别：</label>
							<div id="sex" class="col-sm-8">
								<input name="sex"
									type="radio" value="1" checked>男
									<input class="jg" name="sex"
									type="radio" value="0">女							
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">手机号：</label>
							<div class="col-sm-8">
								<input id="addPhone" name="addPhone" class="form-control"
									type="phone" placeholder="请输入当前手机号">
									<span></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">E-mail：</label>
							<div class="col-sm-8">
								<input id="addEmail" name="addEmail" class="form-control"
									type="email">
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label">部门：</label>
							<div class="col-sm-8">
								<input id="addSection" name="addSection" class="form-control"
									type="test" placeholder="请输入所在部门">
									<span></span>
							</div>
						</div> -->
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-3">
								<button id="add-data" class="btn btn-primary" type="button">提交</button>
								<button type="reset" class="btn btn-info">重置</button>
								<button class="btn btn-danger btn-r" data-dismiss="modal">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- 修改管理员信息 -->
	<div id="update_admin" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改管理员信息</h4>
				</div>
				<div class="modal-body">
					<form id="upForm" class="form-horizontal m-t" id="signupForm" autocomplete='off'>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户ID：</label>
							<div class="col-sm-8">
								<span id="upid"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-8">
								<input id="updateName" name="updateName" class="form-control"
									type="text" aria-required="true" aria-invalid="true"
									class="error">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">登录密码：</label>
							<div class="col-sm-8">
								<input id="updatePwd" name="updatePwd" class="form-control"
									type="password">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">生效时间：</label>
							<div class="col-sm-8">
								<input id="ustartTime" name="ustartTime" class="form-control"
									type="date">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">失效时间：</label>
							<div class="col-sm-8">
								<input id="uendTime" name="uendTime" class="form-control"
									type="date">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否生效：</label>
							<div id="updateState" class="col-sm-8">
								<input name="updateState"
									 type="radio" value="1" checked>是
								<input class="jg" name="updateState"
									 type="radio" value="0">否
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别：</label>
							<div  id="usex"  class="col-sm-8">
								<input name="usex"
									 type="radio" value="1" checked>男
									<input class="jg" name="usex"
									 type="radio" value="0">女
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">手机号：</label>
							<div class="col-sm-8">
								<input id="updatePhone" name="updatePhone" class="form-control"
									type="text">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">E-mail：</label>
							<div class="col-sm-8">
								<input id="updateEmail" name="updateEmail" class="form-control"
									type="email">
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label">部门：</label>
							<div class="col-sm-8">
								<input id="updateSection" name="updatSection"
									class="form-control" type="test">
							</div>
						</div> -->
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-3">
								<button id="up-data" class="btn btn-primary" type="button">提交</button>
								<button class="btn btn-danger btn-r" data-dismiss="modal">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- 全局js -->
	<script src="jsp/js/jquery.min.js?v=2.1.4"></script>
	<script src="jsp/js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript" src="jsp/js/plugins/layer/layer.min.js"></script>
	<script type="text/javascript" src="jsp/admin/js/adminQuery.js"></script>
	<script type="text/javascript" src="jsp/admin/js/adminPower.js"></script>
	
</body>
</html>
