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
</head>
<body>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<!-- Example Pagination -->
			<div class="example-wrap">
				<h3 class="example-title">子公司管理</h3>
				<div class="example">

					<div class="row">
						<div class="col-xs-8">
							<input class="form-control" type="text" />
						</div>
						<div class="ibox-tools col-md-2 col-md-offset-2">
							<button data-toggle="modal" data-target="#add_section"
								class="btn btn-primary">
								<i class="glyphicon glyphicon-plus"></i>
							</button>
							<button class="btn btn-danger">
								<i class="glyphicon glyphicon-trash"></i>
							</button>
						</div>
						<div id="add_section" class="modal fade" tabindex="-1"
							role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title">新增子公司</h4>
									</div>
									<div class="modal-body">
										<form class="form-horizontal m-t" id="signupForm">
											<div class="form-group">
												<label class="col-sm-3 control-label">机构编码：</label>
												<div class="col-sm-8">
													<input id="subsidiaryCode" name="subsidiaryCode"
														class="form-control" type="text" placeholder="请输入机构编码"
														required aria-required="true">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">部门名称：</label>
												<div class="col-sm-8">
													<input id="subsidiaryName" name="subsidiaryName"
														class="form-control" type="text" aria-required="true"
														aria-invalid="true" class="error" placeholder="请输入机构名称"
														required aria-required="true">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">所属类型：</label>
												<div class="col-sm-8">
													<input id="typeOf" name="typeOf" class="form-control"
														type="text" aria-required="true" aria-invalid="false"
														class="valid" placeholder="请输入所属类型" required
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
						<!-- /.modal -->
					</div>
					<div class="ptable">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th data-checkbox="true"></th>
									<th>机构编码</th>
									<th>机构名称</th>
									<th>所属类型</th>
									<th>备注</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- 全局js -->
	<script src="../js/jquery.min.js?v=2.1.4"></script>
	<script src="../js/bootstrap.min.js?v=3.3.6"></script>
	<!-- Bootstrap table -->
	<script src="../js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="../js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="../js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<!-- Peity -->
	<script src="../js/demo/bootstrap-table-demo.js"></script>
	<script type="text/javascript">
    		$(function() {
			$.getJSON("../js/data/subsidiary.json",function(data){
				$.each(data,function(infoIndex,info){  
					$("table").append('<tr>'+
								'<td data-checkbox="true"></td>'+
				    			'<td>'+info["id"]+'</td>'+
				    			'<td>'+info["name"]+'</td>'+
				    			'<td></td>'+
				    			'<td></td>'+
				    		'</tr>');  
				})
			})
		});
    	</script>
</body>
</html>
