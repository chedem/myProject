$(function(){
//	let cookieArr=$.cookie("data").split(",");
//	console.log($.cookie("name"));
	let cookieArr=$.cookie("name");
	$(".profile-element>a>.clear>.m-t-xs>strong").text(cookieArr);
//	for(var i=1;i<cookieArr.length){
//	byPower(cookieArr[i]);
//	}
	$.ajax({
		url:"menu/selUserMenu.do",
		async:true,
		dataType:"json",
		data:{
			userId:null
		},
		erroe:function(e){
			console.log(e);
		},
		success:function(result){
			console.log(result);
			for(var i in result){
				byPower(result[i].name,result[i].remark1);
			}
		}
	});
//	byPower("成套报表");
	function byPower(cData,aurl){
		let showItem=$("#side-menu>li");
		let num;
		let powerTb=document.getElementsByClassName("baoBiao");
		switch(cData){
		case "子公司报表":
			num=0;
			showItem.eq(2).removeClass("hidden");
			comPower(num);
//			showItem.eq(6).find("ul").children("li").eq(2).removeClass("hidden");
//			powerTb[2].href=aurl;
			break;
		case "物装过程报表":
			num=1;
			showItem.eq(2).removeClass("hidden");
			comPower(num);
//			showItem.eq(6).find("ul").children("li").eq(0).removeClass("hidden");
//			powerTb[0].href=aurl;
			break;
		case "成套过程报表":
			num=2;
			showItem.eq(2).removeClass("hidden");
			comPower(num);
//			showItem.eq(6).find("ul").children("li").eq(1).removeClass("hidden");
//			powerTb[1].href=aurl;
			break;
		case "总报表下载":
			num=3;
			if(showItem.is(":hidden")){
				showItem.removeClass("hidden");
			}
			comPower(num);
			break;
		case "应收账款余额表":
			num=4;
			showItem.eq(2).removeClass("hidden");
			comPower(num);
			break;
		case "应收账款余额表（基础统计表）":
			num=5;
			showItem.eq(2).removeClass("hidden");
			comPower(num);
			break;
		case "用户管理":
			showItem.eq(1).removeClass("hidden");

			document.getElementById("userAdmin").href=aurl;
			break;
		}
		function comPower(n){
			showItem.eq(6).find("ul").children("li").eq(n).removeClass("hidden");
			powerTb[n].href=aurl;
		}
	}
});