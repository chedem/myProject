<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'report_form.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="../css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link href="../css/animate.css" rel="stylesheet">
<link href="../css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body>
	<div id="example" class="table-responsive">
		<div class="row form-group">
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label">日期：</label>
				<div class="col-sm-10">
					<input placeholder="开始日期" class="form-control layer-date"
						id="start"> <input placeholder="结束日期"
						class="form-control layer-date" id="end">
				</div>
			</div>
		</div>
		<!-- 		<button type="button" class="btn btn-primary">导出</button>
 -->
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th colspan="11"><h3>预算利润表</h3>
					</th>
				</tr>
				<tr>
					<th>项目名称</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
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
	<!-- 自定义js -->
	<script src="../js/content.js?v=1.0.0"></script>
	<!-- layerDate plugin javascript -->
	<script src="../js/plugins/layer/laydate/laydate.js"></script>
	<script>
        //外部js调用
        /* laydate({
           // elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        }); */

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>
	<script>
		$(function() {
			var gsx = null;//部门
			var xmy = null;//项目
			function dl() {
				$.ajax({
					//url:"http://localhost:8080/web/profit/getCompanyData.do",
					url : "../../profit/getCompanyData.do",
					async : false,
					type : "post",
					//contentType: "application/json; charset=utf-8", 
					data : {
						"type" : "bu_men"
					},
					dataType : "json",
					error : function(result) { //失败 
						alert(result);
					},
					success : function(result) {
						if (result) {
							gsx = result;
							for ( var i = 0; i < result.length; i++) {
								var a = "<th>" + result[i].name + "</th>";
								$("#example>table>thead>tr:last()").append(a);
								
							}
						}

					}

				});
				
			}
			//接收的是项目
			function dl1() {

				$.ajax({
					//url:"http://localhost:8080/web/profit/getCompanyData.do",
					url : "../../profit/getCompanyData.do",
					async:false,
					type : "post",
					//contentType: "application/json; charset=utf-8", 
					data : {
						"type" : "xiang_mu"
					},
					dataType : "json",
					error : function(result) { //失败 
						alert(result);
					},
					success : function(result) {
						xmy = result;
						getProject(result);
						/* for(var i=0; i<result.length;i++){
								
								var b = "<tr><td>"+result[i].name+"</td></tr>";
								
								if(result[i].cbList!==" "){
									$("#example>table>tbody").append(b);
									for(var j = 0;j<result[i].cbList.length;j++){
										var c ="<tr><td>"+result[i].cbList[j].name+"</td></tr>"
										$("#example>table>tbody").append(c);
									}
								}
								$("#example>table>tbody").append(b);
							}*/
					}

				});
				bur();
				
				function bur() {

					for ( var i = 0; i < gsx.length; i++) {
						var num = 0;
						for ( var j = 0; j < xmy.length; j++) {
							//dl2(gsx[i].code,xmy[j].code,startDate,endDate);
							$.ajax({
								//url:"http://localhost:8080/web/profit/getCompanyData.do",
								url : "../../profit/getProfitData.do",
								async : false,
								type : "post",
								//contentType: "application/json; charset=utf-8", 
								data : {
									"lngaccountId" : "1101",
									"lngdepartmentId" : "220",
									"startDate" : "2018-02-01",
									"endDate" : "2018-02-28"
								},
								dataType : "json",
								error : function(result) { //失败 
									alert(result);
								},
								success : function(result) {
									/* //return create_row(result);		
									$.each(result,function(i,item){
									
									}); */
									
									if (result) {
										num += result.data;
									}
								}

							});
							
						}
						//alert(num);
					}

					/* var b = "<tr><td>" + result[i].name + "</td>"
							+ create_row() + create_row() + create_row()
							+ create_row() + create_row() + create_row()
							+ create_row() + create_row() + create_row()
							+ create_row() + "</tr>"; */

				}

			}
			//循环读取项目
			function getProject(result) {
				
				var $tbody = $("#example>table>tbody");
				alert($tbody);
				for ( var i = 0; i < result.length; i++) {
					//var td=$("<td>"+result[i].name+"</td>");
					//td.html( );
					var tr=$("<tr><td>"+result[i].name+"</td></tr>");
					for(var m=0;m<gsx.length;m++){
						tr.append(create_row());
					}
					
					if (result[i].cbList !== " ") {
						
						$tbody.append(tr);
						//tr.append(create_row());
						for ( var j = 0; j < result[i].cbList.length; j++) {
					/* var b = "<tr><td>" + result[i].name + "</td>"
							+ create_row() + create_row() + create_row()
							+ create_row() + create_row() + create_row()
							+ create_row() + create_row() + create_row()
							+ create_row() + "</tr>"; */
					//var b = "<tr><td>" + result[i].name + "</td></tr>"+create_row();
							var tr=$("<tr><td>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+result[i].cbList[j].name+"</td></tr>");
							for(var m=0;m<gsx.length;m++){
								tr.append(create_row());
							}
							$tbody.append(tr);
					//if (result[i].cbList !== " ") {
						//$("#example>table>tbody").append(b);
						//for ( var j = 0; j < result[i].cbList.length; j++) {
							/* var c = "<tr><td>" + result[i].cbList[j].name
									+ "</td>" + create_row() + create_row()
									+ create_row() + create_row()
									+ create_row() + create_row()
									+ create_row() + create_row()
									+ create_row() + create_row() + "</tr>"; */
							
							
							//$("#example>table>tbody").append(c);
							//$tbody.append(c);
							//$tbody.append(create_row());
						}
					}

				}
			}
			//接收表格数据
			function dl2() {
				var data2;
				$.ajax({
					//url:"http://localhost:8080/web/profit/getCompanyData.do",
					url : "../../profit/getProfitData.do",
					async : false,
					type : "post",
					//contentType: "application/json; charset=utf-8", 
					data : {
						"lngaccountId" : "1101",
						"lngdepartmentId" : "220",
						"startDate" : "2018-02-01",
						"endDate" : "2018-02-28"
					},
					dataType : "json",
					error : function(result) { //失败 
						alert(result);
					},
					success : function(result) {
						/* //return create_row(result);		
						$.each(result,function(i,item){
						
						}); */
						if (result) {
							data2 = result;
							
						}
					}

				});
				return data2;

			}
			dl();
			dl1();
			/* function create_row(data2){
				for(var i=0;i<10;i++){
					return data2.data;
					}
				} */
			 function create_row() {	
				var col_td=$("<td>"+dl2().data+"</td>");
				/* for(var i= 0; i < gsx.length;i++ ){
					col_td.html(dl2().data);
					
				} */
				return col_td;
			 }  

		});
	</script>
</body>
</html>
