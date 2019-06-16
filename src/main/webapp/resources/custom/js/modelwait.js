$(document).ready(function() {
	
	$("#btnReady").click(function(){

		var idUser = getUrlParameter('userId');
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
										window.location.href = "/singleChallenge?id="+idjoin+"&userId="+idUser;
									}
								}
							});
						} , 1000);
					}
					if(data.status == true){
						window.location.href = "/singleChallenge?id="+idjoin+"&userId="+idUser;
					}
				}
			});
		
	});
	
	function getUrlParameter(sParam) {
	    var sPageURL = window.location.search.substring(1),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
	        }
	    }
	}
});