 function dl3(){
//	 $(".daochu").css("display", "block");  
//	 $("#daochu").attr("style", "display:block;");//第2种方法  
	 $(".bodys").addClass("showC");
//	 $("#lirun").html("");
	 $("#lirun").html('<ul id="zhanshiTitle" class="nav nav-tabs"></ul><div id="zhanshiTable"  class="tab-content "></div>');


   	$.ajax({
	  	url:"profit/download5.do",
	  	type:"get",
	  	data:{
	  		"fileName":"5",
	  		"startDate":$("#startDate").val(),
	  		"endDate":$("#endDate").val()
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  		$(".bodys").removeClass("showC");

	  	}, 
	  	success:function(result){
	  		$("#lirun").html("<div>"+result+"</div>");

//	  		$("#lirun").append("<div style='display:none;'>"+result+"</div>");
//	  		data(result);
	  		$(".bodys").removeClass("showC");
	  		$(".daochu").show();//隐藏div  
	  	}
	}); 
  }
 
 
 
 function zgsExecle(){
	 $(".bodys").addClass("showC");
	 $("#lirun").html('<ul id="zhanshiTitle" class="nav nav-tabs"></ul><div id="zhanshiTable"  class="tab-content "></div>');

   	$.ajax({
//	  	url:"profit/download4.do",
	  	url:"profit/download.do",
	  	type:"get",
	  	data:{
	  		"fileName":"4",
	  		"startDate":$("#startDate").val(),
	  		"endDate":$("#endDate").val()
	  		},
	  	dataType: "json", 
	  	error: function(result){ //失败 
	  		$(".bodys").removeClass("showC");
	  	}, 
	  	success:function(result){
	  		$(".bodys").removeClass("showC");
	  		$("#lirun").html("<div >"+result+"</div>");
//	  		$("#lirun").html("<div style='display:none;'>"+result+"</div>");

//	  		$("#lirun").append("<div style='display:none;'>"+result+"</div>");
//	  		data(result);
	  		$(".daochu").show();//隐藏div  
	  	}
	}); 
 }
   	
   	

    function wzExecle4(){
   	 $(".bodys").addClass("showC");
   	 $("#lirun").html('<ul id="zhanshiTitle" class="nav nav-tabs"></ul><div id="zhanshiTable"  class="tab-content "></div>');

      	$.ajax({
   	  	url:"profit/download4.do",
   	  	type:"get",
   	  	data:{
   	  		"fileName":"3",
   	  		"startDate":$("#startDate").val(),
   	  		"endDate":$("#endDate").val()
   	  		},
   	  	dataType: "json", 
   	  	error: function(result){ //失败 
   	  		$(".bodys").removeClass("showC");
   	  	}, 
   	  	success:function(result){
   	  		$(".bodys").removeClass("showC");
   	  		$("#lirun").html("<div >"+result+"</div>");
//   	 	$("#lirun").append("<div style='display:none;'>"+result+"</div>");
//  		data(result);
   	  		$(".daochu").show();//隐藏div  
   	  	}
   	}); 
   	
    }
   	
   	function data(result){
//   		var element = $(result).get(0);
//  		var jqueryobj=$(element).context.ownerDocument;//jqueryobj就是一个Jquery对象。
  		var jqueryobj=document;
  		var title = jqueryobj.getElementsByTagName("h2");
  		var table = jqueryobj.getElementsByTagName("tbody");
//  		var style = jqueryobj.getElementsByTagName("style");
  		var titleNum= title.length;
  		var clazz = " active";
  		for ( var int = 0; int <titleNum; int++) {
  			if(int!=0){
  				clazz="";
  			}
  			$("#zhanshiTitle").append(" <li class='tab-pane"+clazz+"'><a data-toggle='tab' href='#tab-"+int+"'> "+title[int].innerText+"</a></li>");
//  			$("#zhanshiTable").append("<div id='tab-"+int+"' class='tab-pane"+clazz+"'><div class='panel-body'><strong>"+title[int].innerText+"</strong>"+
//  			"<table class='ti'>"+table[(int+int)].innerHTML+"</table>"+"</div></div>");
  			$("#zhanshiTable").append("<div id='tab-"+int+"' class='tab-pane"+clazz+"'><div id ='"+int+"' class='panel-body'>"+
  		  			"<table class='ti'>"+table[(int+int)].outerHTML+"</table>"+"</div></div>");
		}
  		
   	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 