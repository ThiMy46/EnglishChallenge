$(document).ready(function() {
	
	function formatNum(num){
		if(num < 10)
			return "0" + num;
		return num;
	}
	
	/*Get current time */
	var idJoin = getUrlParameter('id');
	
	var idquestion;
	var userId = getUrlParameter('userId');
	var interval;

	$.ajax({
		type : "GET",
		url : "/api/join/start/" +idJoin+ "?userId="+ userId
	}).then(function(data) {
		/*Load question*/
		loadQuestion(idquestion, idJoin, userId);
	});
	
	
	$('#submit').click(function(){
		var ans = $('input[name="ans"]:checked').val();
		$.ajax({
	    	type : "GET",
	    	url : "/api/join/" +idJoin+"?userId="+userId+"&answer="+ans
	    	}).then(function(data) {
	    	console.log(data);
	    	//check question end
	    	if(data.status == true){
	    		$('#wait').modal('toggle');
	    		var waitForRedirect = setInterval(function(){
	    			$.ajax({
	    		    	type : "GET",
	    		    	url : "/api/join/review/" +idJoin
	    		    }).then(function(data) {
	    		    	if(data == true){
	    		    		result(idJoin);
	    		    	}
	    		    });
	    		}, 700);
	    	}else{
	    		//set id question
	    		idquestion = data.nextQuestion;
		    	//re-load question
	    		loadQuestion(idquestion, idJoin, userId);
	    	}
	    });
	});
	
	function loadQuestion(idquestion, idJoin, userId){
		$('#question').html('');
		$('#answer1').text('');
		$('#answer2').text('');
		$('#answer3').text('');
		$('#answer4').text('');
		$('input[name="ans"]:checked').prop("checked", false);
		
		
		$.ajax({
			type : "GET",
			url : "/api/testquestion/" +idJoin+"?userId=" + userId
		}).then(function(data) {
			console.log(data);
			//question
			$('#question').append(data.content);
			idquestion = data.id;
			$('#questionId').text(idquestion);
			if(idquestion == 10){
				$('#submit').text('Submit');
			}
			//answer
			$('#answer1').append(data.answer1);
			$('#answer2').append(data.answer2);
			$('#answer3').append(data.answer3);
			$('#answer4').append(data.answer4);
			//time current
			
			interval = setInterval(function(){
				$.ajax({
			    	type : "GET",
			    	url : "/api/join/progress/" +idJoin
			    }).then(function(countTime) {
			    	if(countTime == 0 ){
			    		clearTimeCount();
			    		result(idJoin);
			    	}else{
				    	countTime /= 1000;
				    	var time = formatNum(parseInt(countTime/60)) + ":" + formatNum(countTime%60);
				    	$('#time').text(time);
			    	}
			    });
			} , 500);
			
		});
	}
	function clearTimeCount(){
		clearInterval(interval);
	}
	function result(idJoin){
		location.href = '/reviewQuestion?id='+idJoin+"&userId="+userId;
	}

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