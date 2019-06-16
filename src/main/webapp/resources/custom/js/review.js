$(document).ready(function() {
	
	/*Get current time */
	var urlParams = new URLSearchParams(window.location.search);
	var idJoin = urlParams.get('id');
	
	$.ajax({
    	type : "GET",
    	url : "/api/join/complete/" +idJoin
    }).then(function(data) {
    	console.log(data);
    	
    });
	
	
});