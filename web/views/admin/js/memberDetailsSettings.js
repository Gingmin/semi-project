//수정을 누르면 수정이 되도록,
$(document).ready(function() {
	
	$("#enroll").click(function() {
		if($('.search').prop('disabled')) {
			$('.search').attr('disabled', false);
		} else {
			$('.search').attr('disabled', true);
		}
	});
	
	$("#modify").click(function() {
		if($('.search').prop('disabled')) {
			$('.search').attr('disabled', false);
		} else {
			$('.search').attr('disabled', true);
		}
	});
});