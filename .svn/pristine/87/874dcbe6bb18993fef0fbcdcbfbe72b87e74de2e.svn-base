//function showPower(){
//let id,name;
//var $input=$("#adminShow tbody tr").find("input");
//let jsond={};
//if($input.is(":checked")==true){
//let tablerow = $(this).parents('tr');
//id=tablerow.find("[name='aid']").text();
//name=tablerow.find("[name='aName']").text();
//jsond={"id":id,"name":name};
//getPower(jsond);
//}
//}

//根据用户ID获取用户权限
function getPower(jdata){
	$.ajax({
		type:"post",
		url:"menu/selUserMenu.do",
		async:true,
		dataType:"json",
		data:{
			userId:jdata
		},
		error: function (e){
			console.log(e);
		}, 
		success: function(result){
			
//			console.log(result);
			for(var i in result){
				$("#powerSet input[type='checkbox'][value="+result[i].id+"]").attr("checked","checked");
			}
		}
	});
}
//新增权限
function addNewPower(selectUid){
	$("#addPower").click(function(){
		let addname="";
//		addname.push({"userId":selectUid});
		$("#powerSet input[type=checkbox]:checked").each(function(key,value){
			if($(value).prop('checked')){//判断是否被选中
//				addname[key]={"addid":$(value).val()};
				addname+=$(value).val();
			}
			addname+="_";
		});
		addname=addname.substring(0,addname.length-1);
		console.log(addname);
		let addUrl = "menu/saveUserMenu.do";
		addOrDelPower(selectUid,addname,addUrl);
	});
	
}
//删除权限
function delPower(selectUid){
	//点击删除权限按钮，根据id或name
	$("#delPower").click(function(){
		
		layer.confirm('是否要删除权限',
				{
			title:'提示'
				,offset: '100px'
				},function(){
					let delid="";
					$("#powerSet input[type=checkbox]:checked").each(function(key,value){
						if($(value).prop('checked')){//判断是否被选中
//							delid[key]={"delid":$(value).val()};
//							delid.push({"delid":$(value).val()});
							
							delid+=$(value).val();
						}
						delid+="_";
					});
					delid=delid.substring(0,delid.length-1);
					console.log(delid);
					let delUrl="menu/delUserMenu.do";
					addOrDelPower(selectUid,delid,delUrl);
					layer.closeAll();
			}); 
	});
}

//新增或删除权限，将数据发送给后台
function addOrDelPower(uId,selectId,aurl){
	$.ajax({
		type:"post",
		url:aurl,
		async:true,
		data:{
			userId:uId,
			sendId:selectId
		},
		dataType:"json",
		error:function(e){
			layer.open({
				title: '提示'
					,content: '操作失败！'
						,offset: '100px'
			}); 
		},
		success:function(result){
			layer.open({
				title: '提示'
					,content: '操作成功！'
						,offset: '100px'
			}); 
		}
	});
}