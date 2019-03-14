 
 function wzcfExecle(){
	 $(".bodys").addClass("showC");
	 $("#lirun").html('<ul id="zhanshiTitle" class="nav nav-tabs"></ul><div id="zhanshiTable"  class="tab-content "></div>');

   	$.ajax({
	  	url:"profit/download6.do",
	  	type:"get",
	  	data:{
	  		"fileName":"6",
	  		"startDate":$("#startDate1").val(),
	  		"endDate":$("#endDate").val()
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  		$(".bodys").removeClass("showC");
	  	}, 
	  	success:function(result){
	  		$(".bodys").removeClass("showC");
	  		$("#lirun").html("<div >"+result+"</div>");
	  		$(".daochu").show();//隐藏div  
	  	}
	}); 
 }
   	
 
 
 
 
 
 function tjjcfExecle(){
	 $(".bodys").addClass("showC");
	 $("#lirun").html('<ul id="zhanshiTitle" class="nav nav-tabs"></ul><div id="zhanshiTable"  class="tab-content "></div>');

   	$.ajax({
	  	url:"profit/download7.do",
	  	type:"get",
	  	data:{
	  		"fileName":"7",
	  		"startDate":$("#startDate1").val(),
	  		"endDate":$("#endDate").val()
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  		$(".bodys").removeClass("showC");
	  	}, 
	  	success:function(result){
	  		$(".bodys").removeClass("showC");
	  		$("#lirun").html("<div >"+result+"</div>");
	  		$(".daochu").show();//隐藏div  
	  	}
	}); 
 }
   	

