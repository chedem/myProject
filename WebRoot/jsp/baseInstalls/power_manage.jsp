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
<title>My JSP 'power_manage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet"
	href="css/plugins/bootstrap-table/bootstrap-table.min.css" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<style type="text/css">
#powertab { /*padding: 0;*/
	position: relative;
	width: 100%;
	margin-top: 20px;
	border: 1px solid #CCCCCC;
	box-sizing: border-box;
}

.table-one {
	width: 700px;
}

.rowbg,.table-one table tr:first-child {
	background-color: #faf9f9;
}

.table-one table tr:hover {
	background-color: #faf9f9;
}

.table-two {
	width: 400px;
	position: absolute;
	top: 0;
	right: 0;
}

.table {
	margin: 0;
	padding: 0;
}

#operateBtn {
	width: 100%;
	text-align: center;
}

#operateBtn button {
	margin: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div id="powertab" class="row clearfix">
			<div class="table-one">
				<table id="mytable" class="table table-bordered">
					<tr>
						<th><input type="checkbox"/></th>
						<th>主键</th>
						<th>编码</th>
						<th>名称</th>
						<th>类型</th>
						<th>生效</th>
						<th>备注</th>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td>
						<td name="aid">Data</td>
						<td name="acode">Data</td>
						<td name="aname">Data</td>
						<td name="atypeOf">Data</td>
						<td name="take-effect">Data</td>
						<td name="remark">Data</td>
					</tr></table>
			</div>
			<div class="table-two">
				<table class="table table-striped">
					<tr>
						<th>主键</th>
						<th>编码</th>
						<th>名称</th>
						<th>生效</th>
					</tr>
					<tr>
						<td name="">Data</td>
						<td name="">Data</td>
						<td name="">Data</td>
						<td name="">Data</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="operateBtn">
			<button id="add" class="btn btn-primary">增加</button>
			<button class="btn btn-danger">删除</button>
			<button class="btn btn-info">修改</button>
		</div>
	</div>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"
		charset="utf-8"></script>
	<!--<script type="text/javascript" src="js/demo/bootstrap-table-demo.js" ></script>-->
	<script src="js/plugins/bootstrap-table/bootstrap-table.min.js"
		type="text/javascript"></script>
	<script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"
		type="text/javascript"></script>
	<script>
		$(function() {
			selectRow();
			$("#add").click(function() {
				getTableData();
			});
		});
		//选择一行，获取当前行的数据，并展示在右边
		function selectRow() {
			$("input[type=checkbox]:checked").each(
					function(key, value) {
						if ($(value).prop('checked')) {//判断是否被选中
							alert('dwifpi');
							var tablerow = $(this).parents('tr');
							tablerow.addClass('rowbg');
							console.log(tablerow);
							var id = tablerow.find("[name='aid']").text();
							var code = tablerow.find("[name='acode']").text();
							var name = tablerow.find("[name='aname']").text();
							var typeOf = tablerow.find("[name='atypeOf']")
									.text();
							var takeEffect = tablerow.find(
									"[name='take-effect']").text();
							var remark = tablerow.find("[name='remark']")
									.text();
						}
					});
		}
		//选择多行，获取数据
		function getTableData() {
			var selectedData = [];
			$("input[type=checkbox]:checked").each(function() {
				var tablerow = $(this).parents('tr');
				//			  console.log(tablerow);
				var id = tablerow.find("[name='aid']").text();
				var code = tablerow.find("[name='acode']").text();
				var name = tablerow.find("[name='aname']").text();
				var typeOf = tablerow.find("[name='atypeOf']").text();
				var takeEffect = tablerow.find("[name='take-effect']").text();
				var remark = tablerow.find("[name='remark']").text();
				selectedData.push({
					Id : id,
					Code : code,
					Name : name,
					Type : typeOf,
					TakeEffect : takeEffect,
					Remark : remark
				});
				//			  console.log(selectedData);
			});
		}
	</script>
</body>
</html>
