<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'project_manage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="../css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="../css/animate.css" rel="stylesheet">
<link href="../css/style.css?v=4.1.0" rel="stylesheet">
<style type="text/css">
#enterMain {
	margin-top: 20px;
	width: auto;
}
.protable {
	overflow-y: auto;
	height: 400px;
	width: 800px;
	display: inline-block;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="ibox example-wrap animated fadeInRight">
		<ul class="nav nav-tabs" role="tablist">
			<li id="pro" role="presentation" class="active"><a
				href="#profit" aria-controls="profit" role="tab" data-toggle="tab">利润</a>
			</li>
			<li id="co" role="presentation"><a href="#cost"
				aria-controls="cost" role="tab" data-toggle="tab">费用</a>
			</li>
		</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane fade in active" id="profit">
				<div id="enterMain" class="container-fluid">
					<div class="row clearfix">
						<div class="col-sm-8">
							<input class="form-control" type="text" />
						</div>
						<div class="ibox-tools col-md-2">
							<button data-toggle="modal" data-target="#add_project"
								class="btn btn-primary">
								<i class="glyphicon glyphicon-plus"></i>添加
							</button>
						</div>
						<div class="protable">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>报表项目编码</th>
										<th><select name="" id=""
											style="border: 0;outline: none;">
												<option value="0">报表项目名称</option>
												<option value="1">营业收入</option>
												<option value="2">营业成本</option>
												<option value="3">业务毛利</option>
												<option value="4">营业利润</option>
												<option value="5">利润总额</option>
												<option value="6">本期调整</option>
												<option value="7">调整后利润总额</option>
												<option value="8">应收账款</option>
										</select></th>
										<th><select name="" style="border: 0;outline: none;">
												<option value="0">报表项目类型</option>
												<option value="1">利润收入</option>
												<option value="2">成本费用</option>
										</select></th>
										<th data-field="remark">备注</th>
									</tr>
								</thead>
							</table>
						</div>

					</div>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane fade in" id="cost">
				<div id="enterMain" class="container">
					<div class="row clearfix">
						<div class="col-sm-8">
							<input class="form-control" type="text" />
						</div>
						<div class="ibox-tools col-md-2">
							<button data-toggle="modal" data-target="#add_project"
								class="btn btn-primary">
								<i class="glyphicon glyphicon-plus"></i>添加
							</button>
							<!--<button class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></button>-->
						</div>
						<div class="cotable">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>报表项目编码</th>
										<th><select name="" id=""
											style="border: 0;outline: none;">
												<option value="0">报表项目名称</option>
												<option value="1">营业收入</option>
												<option value="2">营业成本</option>
												<option value="3">业务毛利</option>
												<option value="4">营业利润</option>
												<option value="5">利润总额</option>
												<option value="6">本期调整</option>
												<option value="7">调整后利润总额</option>
												<option value="8">应收账款</option>
										</select></th>
										<th><select name="" style="border: 0;outline: none;">
												<option value="0">报表项目类型</option>
												<option value="1">利润收入</option>
												<option value="2">成本费用</option>
										</select></th>
										<th data-field="remark">备注</th>
									</tr>
								</thead>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div id="add_project" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">新增项目</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal m-t" id="signupForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">报表项目编码：</label>
								<div class="col-sm-8">
									<input id="projectCode" name="projectCode" class="form-control"
										type="text" placeholder="请输入项目编码" required
										aria-required="true">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">报表项目名称：</label>
								<div class="col-sm-8">
									<input id="projectName" name="projectName" class="form-control"
										type="text" aria-required="true" aria-invalid="true"
										class="error" placeholder="请输入项目名称" required
										aria-required="true">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">报表项目类型：</label>
								<div class="col-sm-8">
									<input id="projectType" name="projectType" class="form-control"
										type="text" aria-required="true" aria-invalid="false"
										class="valid" placeholder="请输入项目类型" required
										aria-required="true">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注：</label>
								<div class="col-sm-8">
									<textarea id="remark" name="remark" class="form-control"></textarea>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<button class="btn btn-primary" type="submit">提交</button>
									<button class="btn btn-danger btn-r close-link"
										data-dismiss="modal">取消</button>
								</div>
							</div>
						</form>

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		<!--<div class="example">
	                    	<div class="row">
	                    	</div>
	               	    </div>-->
	</div>


	<!-- 全局js -->
	<script src="../js/jquery.min.js?v=2.1.4"></script>
	<script src="../js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 自定义js -->
	<script src="../js/content.js?v=1.0.0"></script>
	<!-- Bootstrap table -->
	<script src="../js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="../js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="../js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script>
		$(function() {
			$.getJSON("../js/data/profitProject.json",function(data){
				$.each(data,function(infoIndex,info){  
					$("table").append('<tr>'+
				    			'<td>'+info["id"]+'</td>'+
				    			'<td>'+info["name"]+'</td>'+
				    			'<td>利润收入</td>'+
				    			'<td></td>'+
				    		'</tr>');  
				})
			})
		});
	</script>
</body>
</html>
