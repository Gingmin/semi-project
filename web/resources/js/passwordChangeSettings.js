//인증번호를 쳐야지만 확인 버튼이 눌리는 로직
$(document).ready(function() {
         		$('.number_input').on('keyup', function() {
         			var flag = true;
         			flag = $(this).val().length > 0 ? false : true;
         			$('.number_confirm').attr('disabled', flag);
         		});
});

