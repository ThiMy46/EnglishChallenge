$(document).ready(function() {
	
	$('#inputMessage').on('keydown', function(e) {
	    if (e.which == 13) {
	        e.preventDefault();
	        $('#btnSend').click();
	    }
	});
	
	$('#btnSend').click(function(){
		var message = $('#inputMessage').val();
		if(message) {
			$.ajax({
		    	type : "GET",
		    	url : "/api/join/send/" +idJoin + "?userId="+userId+"&message=" + message
		    }).then(function(data) {
		    	$('#inputMessage').val('');
		    	if(data.message){
		    		var element = createMessageElement(data.message, data.me);
		    		addMessage(element);
		    	}
		    });
		}
	});
			
	var callMessage = setInterval(function(){
		$.ajax({
		    	type : "GET",
		    	url : "/api/join/receive/" +idJoin + "?userId="+userId
		    }).then(function(data) {
		    	if(data.message){
		    		var element = createMessageElement(data.message, data.me);
		    		addMessage(element);
		    	}
		    });
	}, 100);
	
	function createMessageElement(message, isRight){
		var divParent;
		if(isRight == true){
			divParent = `<div class="direct-chat-msg right">`;
		} else{
			divParent = `<div class="direct-chat-msg">`;
		}
		
		return divParent +
		`<div class="direct-chat-info clearfix">
              <span class="direct-chat-name pull-right">Sarah Bullock</span>
              <span class="direct-chat-timestamp pull-left">23 Jan 6:10 pm</span>
              </div>
              <img class="direct-chat-img" src="/resources/dist/img/user5-128x128.jpg" alt="message user image">
              <div class="direct-chat-text">
              ${message}
              </div>
              </div>
        </div>`;
	}
	
	function addMessage(messageElement) {
		$('#div-chat-box').append(messageElement);
	}
});