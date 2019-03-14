$(function(){
	selData();
	$("#addName").blur(function(){
		$(this).next("span").text("");
		if($(this).val()==""){
			$(this).next("span").text("用户名不能为空!").addClass("errorConfirm");
		}
	});
	$("#addPwd").blur(function(){
		$(this).next("span").text("");
		if($(this).val()==""){
			$(this).next("span").text("密码不能为空!").addClass("errorConfirm");
		}
	});
	$("#startTime").blur(function(){
		$(this).next("span").text("");
		if($(this).val()==""){
			$(this).next("span").text("生效时间不能为空!").addClass("errorConfirm");
		}
	});
	$("#endTime").blur(function(){
		$(this).next("span").text("");
		if($(this).val()==""){
			$(this).next("span").text("失效时间不能为空!").addClass("errorConfirm");
		}
	});
//	$("#addPhone").blur(function(){
//		$(this).next("span").text("");
//		if($(this).val()==""){
//			$(this).next("span").text("手机号不能为空!").addClass("errorConfirm");
//		}
//	});
//	$("#addSection").blur(function(){
//		$(this).next("span").text("");
//		if($(this).val()==""){
//			$(this).next("span").text("部门不能为空!").addClass("errorConfirm");
//		}
//	});
	let id,name,pwd,startTime,endTime,state,sex,phone,email;
	let sjsonData={};
	//点击新增管理员，把新增管理员信息传递给后台
	$("#add-data").on("click",function(){
		name=$("#addName").val();
		pwd=$("#addPwd").val();
		startTime=$("#startTime").val();
		endTime=$("#endTime").val();
		state=$('#state input[name="state"]:checked ').val();
		sex=$('#sex input[name="sex"]:checked ').val();
		phone=$("#addPhone").val();
		email=$("#addEmail").val();
//		section=$("#addSection").val();
		if(name!=""&&pwd!=""&&startTime!=""&&endTime!=""){
			sjsonData = {
					"name":name,
					"password":pwd,
					"effect_Time":startTime,
					"fail_Time":endTime,
					"is_Valid":state,
					"gender":sex,
					"phone":phone,
					"email":email
//					"department":section
			};
			var addurl="welcome/saveUserInfo.do";
			sendData(sjsonData,addurl);
		}else{
			layer.open({
				title: '错误提示'
					,content: '保存失败！'
						,offset: '100px'
			}); 
		}

	});
	//点击修改管理员,把修改的信息传递给后台
	$("#up-data").click(function(){
		id=$("#upid").text();
		name=$("#updateName").val();
		pwd=$("#updatePwd").val();
		startTime=$("#ustartTime").val();
		endTime=$("#uendTime").val();
		state=$('#updateState input[name="updateState"]:checked').val();
		sex=$('#usex input[name="usex"]:checked ').val();
		phone=$("#updatePhone").val();
		email=$("#updateEmail").val();
//		section=$("#updateSection").val();
		layer.confirm('是否要修改',	
				{
			title:'提示'
				,offset: '100px'
				},function(){
			sjsonData={
				"userId":id,
				"name":name,
				"password":pwd,
				"effect_Time":startTime,
				"fail_Time":endTime,
				"is_Valid":state,
				"gender":sex,
				"phone":phone,
				"email":email
//				"department":section
			};
			var updateUrl="welcome/updateUserInfo.do";
//			console.log(sjsonData);
			sendData(sjsonData,updateUrl);
			layer.closeAll();
		});

	});

});
function delBtn(uid){
	//点击删除按钮，根据id
	$("#btnDel").click(function(){
		layer.confirm('是否要删除',
				{
			title:'提示'
				,offset: '100px'
				},function(){
			$.ajax({
				type:"post",
				url:"welcome/deleteUserInfo.do",
				async:true,
				dataType:"json",
				data:{
					userId:uid
				},
				error:function(e){
//					console.log(e);
					layer.open({
						title: '提示'
							,content: '删除失败！'
								,offset: '100px'
					}); 
				},
				success:function(){
					layer.open({
						title: '提示'
							,content: '删除成功！'
								,offset: '100px'
					}); 
					selData();
				}
			});
			layer.closeAll();
		});

	});
}
//将新增或修改的数据发送到后台
function sendData(jdata,url){
	$.ajax({
		type:"post",
		url:url,
		async:true,
		dataType:"json",
		data:jdata,
		error:function(e){
			console.log(e);
			layer.open({
				title: '错误提示'
					,content: '保存失败！'
						,offset: '100px'
			}); 
			$("form")[1].reset();
		},
		success:function(){
			layer.open({
				title: '提示'
					,content: '保存成功！'
						,offset: '100px'
			}); 
			$("form")[1].reset();
			$('#add_admin').modal('hide');
			$('#update_admin').modal('hide');
			
			selData();
		}
	});
}

//选择一行，获取当前行的数据，并展示在右边
function selectRow () {
	var id,name,effectTime,failTime,isValid,gender,phone,email;
	var $input=$("#adminShow tbody tr").find("input");
	var $flag;
	$input.click(function(){
		$input.parents("tr").prev().removeClass("rowbg");
		$("#powerSet input[type='checkbox']").removeAttr("checked");
		$("form")[0].reset();
		$flag=$input.is(":checked");
		if($flag==true){
			var tablerow=$(this).parents("tr");
			tablerow.addClass("rowbg");
			id=tablerow.find("[name='aid']").text();
			name= tablerow.find("[name='aName']").text();
			effectTime= tablerow.find("[name='effectTime']").text();
			failTime = tablerow.find("[name='failTime']").text();
			isValid = tablerow.find("[name='isValid']").text();
			gender = tablerow.find("[name='gender']").text();
			phone= tablerow.find("[name='aPhone']").text();
			email= tablerow.find("[name='aEmail']").text();
//			section= tablerow.find("[name='aSection']").text();
			getPower(id);
			addNewPower(id);
			delPower(id);
			updateSave();
			delBtn(id);
//			delBtn(id);
		}else{
			$(this).parents("tr").removeClass("rowbg");
		}
	});
	function updateSave(){
		$("#btnUpdate").click(function(){
			$("form")[2].reset();
			$("#upid").text(id);
			$("#updateName").val(name);
//			var now = new Date(Date.parse(effectTime));
//			//格式化日，如果小于9，前面补0  
//			var day = ("0" + now.getDate()).slice(-2);  
//			//格式化月，如果小于9，前面补0  
//			var month = ("0" + (now.getMonth() + 1)).slice(-2);  
//			//拼装完整日期格式  
//			var today = now.getFullYear()+"-"+(month)+"-"+(day) ; 
			$("#ustartTime").val(effectTime);
			$("#uendTime").val(failTime);
			if(isValid=="是"){
				$("#updateState [name=updateState]:eq(0)").attr("checked","checked");
			}
			if(isValid=="否"){
				$("#updateState [name=updateState]:eq(1)").attr("checked","checked");
			}
			if(gender=="男"){
				$("#updateSex [name=updateState]:eq(0)").attr("checked","checked");
			}
			if(gender=="女"){
				$("#updateSex [name=updateState]:eq(1)").attr("checked","checked");
			}
			$("#updatePhone").val(phone);
			$("#updateEmail").val(email);
//			$("#updateSection").val(section);
		});
	}
	
	
}

//查询所有数据
function selData(){
	$.ajax({
		type:"post",
		url:"welcome/selUserInfo.do",
		async:true,
		dataType:"json",
		error: erryFunction,  //错误执行方法  
		success: succFunction //成功执行方法  
	})
}
function erryFunction(e) {
	console.log(e);
}
function succFunction(result) {
//	console.log(result);
	$("#adminShow tbody").html('');
	var jsonData = eval(result); //数组       
	$.each(jsonData, function (index, item) {
//		console.log(item);
		if(item["id"]==null||item["id"]==undefined){
			item["id"]="";
		}
		if(item["name"]==null||item["name"]==undefined){
			item["name"]="";
		}
		if(item["effectTime"]==null||item["effectTime"]==undefined){
			item["effectTime"]="";
		}
		if(item["failTime"]==null||item["failTime"]==undefined){
			item["failTime"]="";
		}
		if(item["isValid"]==""||item["isValid"]==null||item["isValid"]==undefined){
			item["isValid"]="";
		}else if(item["isValid"]=="1"){
			item["isValid"]="是";
		}else{
			item["isValid"]="否"
		}
		if(item["gender"]==""||item["gender"]==null||item["gender"]==undefined){
			item["gender"]="";
		}else if(item["gender"]=="1"){
			item["gender"]="男"
		}else{
			item["gender"]="女"
		}
		if(item["phone"]==null||item["phone"]==undefined){
			item["phone"]="";
		}
		if(item["email"]==null||item["email"]==undefined){
			item["email"]="";
		}
//		if(item["section"]==null||item["section"]==undefined){
//			item["section"]="";
//		}
		//循环获取数据  
		$("#adminShow tbody").append('<tr>'+
				'<td><input name="b" type="radio"/></td>'+
				'<td name="aid">'+item["id"]+'</td>'+
				'<td name="aName">'+item["name"]+'</td>'+
				'<td name="effectTime">'+item["effectTime"]+'</td>'+
				'<td name="failTime">'+item["failTime"]+'</td>'+
				'<td name="isValid">'+item["isValid"]+'</td>'+
				'<td name="gender">'+item["gender"]+'</td>'+
				'<td name="aPhone">'+item["phone"]+'</td>'+
				'<td name="aEmial">'+item["email"]+'</td>'+
//				'<td name="aSection">'+item["section"]+'</td>'+
		'</tr>');
	});
	selectRow ();
}