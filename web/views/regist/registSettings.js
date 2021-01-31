
//팝업창으로 submit하기 

	$(document).ready(function() {
		$('#btn_submit').on('click', function() {
			$('#myForm').submit();
			alert($('#myForm').submit());
		})
	});