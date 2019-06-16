$(document).ready(function() {
	
	function formatNum(num){
		if(num < 10)
			return "0" + num;
		return num;
	}
	
	/*Get current time */
	var urlParams = new URLSearchParams(window.location.search);
	var idJoin = urlParams.get('id');
	
	var idquestion;
	var userId = $('#user-current').data('id');
	var interval;

	$.ajax({
		type : "GET",
		url : "/api/join/start/" +idJoin+ "?userId="+ userId
	}).then(function(data) {
		/*Load question*/
		loadQuestion(idquestion, idJoin);
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
	    		result(idJoin);
	    	}else{
	    		//set id question
	    		idquestion = data.nextQuestion;
		    	//re-load question
	    		loadQuestion(idquestion, idJoin);
	    	}
	    });
	});
	
	function loadQuestion(idquestion, idJoin){
		$('#question').html('');
		$('#answer1').text('');
		$('#answer2').text('');
		$('#answer3').text('');
		$('#answer4').text('');
		$('input[name="ans"]:checked').prop("checked", false);
		
		
		$.ajax({
			type : "GET",
			url : "/api/testquestion/" +idJoin
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
		/*$.ajax({
	    	type : "GET",
	    	url : "/api/join/complete/" +idJoin
	    }).then(function(data) {
	    	console.log(data);
	    	//result
	    	
	    });*/
		location.href = '/reviewQuestion?id='+idJoin;
	}

});