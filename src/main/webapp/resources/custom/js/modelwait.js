$(document).ready(function() {
	
	$("#btnReady").click(function(){

		var idUser = $('#user-current').data('id');
		$.ajax({
				url:'/api/join/create/'+idUser,
				type:"GET",
				success: function(data){
					var idjoin = data.joinId;
					if(data.status == false){
						$('#confirm').modal('toggle');
						$('#wait').modal('toggle');//đang đợi
						setInterval(function(){
							$.ajax({
								url:'/api/join/wait/'+idjoin,
								type:"GET",
								success: function(data){
									console.log(data.status);
									if(data.status == true)
									{
										clearInterval(this);
										window.location.href = "/singleChallenge?id="+idjoin;
									}
								}
							});
						} , 1000);
					}
					if(data.status == true){
						window.location.href = "/singleChallenge?id="+idjoin;
					}
				}
			});
		
	});
	
	
});