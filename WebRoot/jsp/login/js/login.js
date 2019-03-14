$(function() {
	$("#getLogin").click(function() {
		let uName=$("[name=userName]").val(),
		pwd=$("[name=password]").val();
		$.ajax({
			url:"profit/getCompanyData.do",
			dataType:"json",
			data:{
				"userName":uName,
				"password":pwd
			},
			success:function(result){
				window.location.href="jsp/index/index.jsp";
			}
		});
	});

});