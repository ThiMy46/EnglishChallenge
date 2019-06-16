var userId;
var idJoin;
$(document).ready(function() {
	
	/*Get current time */
	idJoin = getUrlParameter('id');
	
	userId = getUrlParameter('userId');
	
	$.ajax({
    	type : "GET",
    	url : "/api/join/complete/" +idJoin
    }).then(function(data) {
    	var info1 = '';
    	var info2 ='';
    	var user1 = data.userInfos[0];
    	var user2 = data.userInfos[1];

    	var result = '';
    	
    	if(user1.id == userId){
    		if(user1.score < user2.score){
    			//thất bại
    			result += displayResultFail(user1.score, user2.score, user1.time, user2.time);
    		}else if(user1.score > user2.score){
    			//chiến thắng
    			result += displayResultWin(user1.score, user2.score, user1.time, user2.time);
    		}else{
    			if(user1.time < user2.time){
        			//thất bại
        			result += displayResultFail(user1.score, user2.score, user1.time, user2.time);
        		}else if(user1.time > user2.time){
        			//chiến thắng
        			result += displayResultWin(user1.score, user2.score, user1.time, user2.time);
        		}
    		}
    	}else{
    		if(user2.score < user1.score){
    			//thất bại
    			result += displayResultFail(user2.score, user1.score, user2.time, user1.time);
    		}else if(user2.score > user1.score){
    			//chiến thắng
    			result += displayResultWin(user2.score, user1.score, user2.time, user1.time);
    		}else{
    			if(user2.time < user1.time){
        			//thất bại
        			result += displayResultFail(user2.score, user1.score, user2.time, user1.time);
        		}else if(user2.time > user1.time){
        			//chiến thắng
        			result += displayResultWin(user2.score, user1.score, user2.time, user1.time);
        		}
    		}
    	}
    	$('#info_result').append(result);
    	
    	var question = '';
    	$.each(data.questionInfos, function(i, item) {
    		question += '<span><b>Câu hỏi '+item.id+'/10:</b></span>'+item.question+'<h5>Đáp án đúng : '+item.answer+'</h5>'
            +'<h5>Giải thích: '+item.review+'</h5>';
    	});
    	$('#content_review').append(question);
    });

	function displayResultWin(score1, score2, time1, time2){
		time1 /= 1000;
		time2 /= 1000;
		time1 = formatNum(parseInt(time1/60)) + " phút " + formatNum(time1%60) + " giây";
		time2 = formatNum(parseInt(time2/60)) + " phút " + formatNum(time2%60) + " giây";
		var info = '<div><img  style="margin: auto; width: 300px" class="img-responsive text-center" src="/resources/custom/img/tu-vung-voi-tu-win.png"alt="Photo"></div>'
    		+'<h2 style="text-align: center;">CHÚC MỪNG!!!</h2>'
            +'<h3 style="text-align: center;">Bạn vừa nhận được 30 EXP</h3>'
            +'<h5 style="text-align: center;">Kết quả bạn đạt được: '+score1+'/10 câu - thời gian '+time1+'</h5>'
            +'<h5 style="text-align: center;">Kết quả đối thủ của bạn: '+score2+'/10 câu - thời gian '+time2+'</h5>';
		return info;
	}
	
	function displayResultFail(score1, score2, time1, time2){
		time1 /= 1000;
		time2 /= 1000;
		time1 = formatNum(parseInt(time1/60)) + " phút " + formatNum(time1%60) + " giây";
		time2 = formatNum(parseInt(time2/60)) + " phút " + formatNum(time2%60) + " giây";
		var info = '<div><img  style="margin: auto; width: 300px" class="img-responsive text-center" src="/resources/custom/img/download.jpg"alt="Photo"></div>'
    		+'<h2 style="text-align: center;">CỐ GẮNG LẦN SAU NHÉ!!!</h2>'
            +'<h3 style="text-align: center;">Bạn vừa bị trừ 10 EXP</h3>'
            +'<h5 style="text-align: center;">Kết quả bạn đạt được: '+score1+'/10 câu - thời gian '+time1+'</h5>'
            +'<h5 style="text-align: center;">Kết quả đối thủ của bạn: '+score2+'/10 câu - thời gian '+time2+'</h5>';
		return info;
	}
	function formatNum(num){
		if(num < 10)
			return "0" + num;
		return num;
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