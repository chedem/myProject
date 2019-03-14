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
<link rel="stylesheet" type="text/css" href="jsp/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="jsp/css/font-awesome.min.css" />
<link rel="stylesheet" href="jsp/css/jexcel/jquery.jexcel.css"
	type="text/css"></link>
<!-- <link rel="stylesheet" href="css/leading.css" type="text/css"></link> -->

<style type="text/css">
	#uploadFile{
		height: 30px;
		line-height: 30px;
		font-size: 16px;
	}
	#sel,#type{
		width: 150px;
		height: 30px;
		line-height: 30px;
		font-size: 16px;
	}
.row {
	margin: 20px auto;
}

#my {
	height: 450px;
	width: 100%;
	overflow:hidden;
	overflow: auto;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<form id="postForm" class="form-inline row" action="extract/setProfitData1.do" method="post"
		enctype="multipart/form-data">
		<div class="form-group col-sm-3">
			<label for="date">时间：</label><input class="form-control" type="text" id="date" name="date"> 
		</div>
		<div class="form-group col-sm-3">
			<label for="type">请选择：</label>
			<select id="type" name="type">
				<option value ="_1">抵消表</option>
				<option value ="-2">同期表</option>
				<option value ="_201">预算目标表</option>
  				<option value ="_202">奋斗目标表</option>
				<!-- <option value ="_3"></option> -->
			</select>
		</div>
		<div class="form-group col-sm-4">
			<label for="uploadFile" class="col-xs-4 text-right"> 上传execle</label>
			<input class="col-xs-8" type="file" name="uploadFile"
				id="uploadFile" onchange="importf(this)"/> 
		</div>
			
		<div>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">预览</button>
			<input class="btn btn-primary" type="button" value="上传"
			onclick="doUpload()" /> 
			<span id="messageTip" hidden="true"></span>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-body">
			      	<label>请选择</label>
		        	<select id="sel" name="">
		        		
		        	</select>
			      </div>
			      <div class="modal-footer">
			        <!--<button type="button" class="btn btn-default" >Close</button>-->
			        <button id="btnOk" type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>
		</form>
		<div id="my"></div>
	</div>
<script type="text/javascript" src="jsp/js/jquery.min.js"></script>
<script type="text/javascript" src="jsp/execle/laydate/laydate.js"></script>
<script src="jsp/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="jsp/js/xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="jsp/js/jexcel/jquery.jexcel.js"></script>
<script type="text/javascript" src="jsp/onload/js/onload.js"></script>
</head>
<script type="text/javascript">
  function doUpload(){
  var formData = new FormData($( "#postForm" )[0]); 
            $.ajax({  
                 url:"<%=basePath%>extract/setProfitData1.do",
                 type : "POST",  
                 data : formData,  
                 async: false,  
	             cache: false,  
	             contentType: false,  
	             processData: false,
                 success : function(data) {  
                 	alert("上传成功！");
                 },  
                 error : function(data) {  
                 }  
            }); 
        } 
         
      var myDate = new Date();//获取系统当前时间 
  	  laydate.render({
	  elem: '#date'
	  ,type: 'month'
	  ,format: 'yyyyMM'
	  ,value: myDate
	  ,btns: ['confirm']
	});
        //使用jquery.form.js的表单插件来提交表单，这个可以异步上传文件
        /* function doUpload(){
            var options = {
                url: 'getParamFromFileForAjax',//表单提交的地址。缺省值： 表单的action的值
                type: 'POST',
                dataType:'text',
                data :{
                    fileName : 'uploadFile'                     
                },
                //clearForm: true,//成功提交后，清除所有表单元素的值
                //timeout: 3000 ,//限制请求的时间，当请求大于3秒后，跳出请求
                // 从服务传过来的数据显示在这个div内部也就是ajax局部刷新
                //target: '#output1',
                 
                // 处理之后的处理
                success: function(data){
                    alert(data);
                    var result = $.parseJSON(data);
                    alert(result);
                }
            };
             
            //使用jquery的ajax upload插件可以上传文件
            $('#postForm').ajaxSubmit(options);
        } */
</script>

</html>
