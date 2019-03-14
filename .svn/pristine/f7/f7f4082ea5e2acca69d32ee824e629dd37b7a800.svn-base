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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

</style>

  
  <body>
      <form id="postForm" action="extract/setProfitData1.do" method="post" 
        enctype="multipart/form-data">
        <span>时间：</span><input type="text" id="date" name="date">
             <select id="type" name="type">
  <option value ="_1">抵消表</option>
  <option value ="_201">预算目标表</option>
  <option value ="_202">奋斗目标表</option>
  <option value ="-2">同期表</option>
  <!-- <option value ="_3"></option> -->
</select>
         <span>   上传execle:</span><input type="file" name="uploadFile" id="uploadFile"/>
          <input type="button" value="上传" onclick="doUpload()"/>
          <span id="messageTip" hidden="true"></span>
    </form>
              <input type="button" value="下载" onclick="dowdload()"/>
    

  </body>
     <script type="text/javascript" src="jsp/execle/laydate/laydate.js"></script>
   <script type="text/javascript" src="jsp/execle/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="welcome/js/jquery-1.11.1.min.js"></script></head>
  
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
        
         function dowdload(){
         var date1 = "date="+$("#date").val()+"&type="+$("#type").val()
          this.window.open(  "<%=basePath%>profit/downloadExelce.do?"+date1 );
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
