$(document).ready(function() {
	$("#vocabulary").hide();
	$("#grammar").hide();
	$("#reading").hide();
	$("#listening").hide();
	
	var url_string = window.location.href;
	var url = new URL(url_string);
	var typeMission = url.searchParams.get("type");
	
	if (typeMission == 1) {
		$("#vocabulary").show();
	} else if (typeMission == 2) {
		$("#grammar").show();
	} else if (typeMission == 3) {
		$("#listening").show();
	} else if (typeMission == 4) {
		$("#reading").show(); 
	}
	
	$(".button-submit").click(function() {
		Swal.fire({
			  imageUrl: 'https://leadcycle.co.uk/wp-content/uploads/meet-the-team/ec-success-firework.gif',
			  imageHeight: 200,
			  imageAlt: 'A tall image'
			})
	});
		
	
});
