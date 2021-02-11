//수정을 누르면 수정이 되도록,
$(document).ready(function() {
	
	$("#enroll").click(function() {
		if($(".search").prop("disabled")) {
			$(".search").attr("disabled", false);
		} else {
			$(".search").attr("disabled", true);
		}
	});
	
	$("#modify").click(function() {
		if($(".search").prop("disabled")) {
			$(".search").attr("disabled", false);
		} else {
			$(".search").attr("disabled", true);
		}
	});
	
//누계 1, 2, 3일 때 다 다르게
	$(".result").each(function() {
			if($(this).text() == 0) {
				$(this).css({"background-color":"white", "color":"#868886"});
			} else if($(this).text() == 1) {
				$(this).css({"background-color":"yellow", "color":"#000000"});
			} else if($(this).text() == 2) {
				$(this).css({"background-color":"red", "color":"#FFFFFF"});
			} else if($(this).text() == 3) {
				$(this).css({"background-color":"black", "color":"#FFFFFF"});
			}
		 });
	
	
});