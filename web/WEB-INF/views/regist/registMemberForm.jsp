<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 회원가입</title>
<link rel="stylesheet" href="/semi/resources/css/member/registMember.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<div class="info_area">
			<div class="info_text">회원가입</div>
			<br>

			<div class="submit_reset">
				<input type="button" class="choice ch1" value="일반회원" id="ge">
				<input type="button" class="choice ch2" value="트레이너" id="tr">
			</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="verifyForm">
				<div class="info_item1">
					<div class="info_text1">
						이메일 주소 <span class="info_detail">*</span>
					</div>
				<c:if test="${ empty requestScope.verificationNumber }">
					<input class="box_detail2" type="text" name="email" id="email"
						placeholder="이메일주소를 입력해주세요" autofocus>
				</c:if>
				<c:if test="${ !empty requestScope.verificationNumber }">
					<input class="box_detail2" type="text" name="email" id="email" value="${ requestScope.requestMember.email }"
						placeholder="이메일주소를 입력해주세요" autofocus readonly>
				</c:if>
					<button class="certify" disabled onclick="return sendVerificationNumber();">인증번호 받기</button>
				</div>
				<br>
				<p id="id_check"></p>
				
				<br>
				<div class="info_item1">
					<input class="box_detail2" type="text" name="verificationNumber" id="verificationNumber" placeholder="인증번호를 입력하세요">
					<button class="certify2" type="button" disabled onclick="return confirm();">확인</button>
				</div>
			</form>
			
				<form class="info" action="" method="post" id="myForm">
				<input type="email" name="email2" id="email2" value="${ requestScope.requestMember.email }" style="display: none;">
				<br>
				<div class="info_item1">
					<div class="info_text1">
						비밀번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password" id="password"
						placeholder="비밀번호를 입력하세요" disabled>
				</div>
				<br>
				<p id="pwd_check"></p>
				<p id="caps_check"></p>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						비밀번호 확인 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password" id="password2"
						placeholder="비밀번호를 입력하세요" disabled>
					<div class="guide">
						<br> 8글자 이상 / 영문 숫자 조합
					</div>
				</div>

				<br>
				<br>

				<div class="info_item1">
					<div class="info_text1">
						이름 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="name" id="name"
						placeholder="이름를 입력하세요" disabled>
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						연락처 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="tel" name="phone" id="phone"
						placeholder="전화번호를 입력하세요" disabled>
				</div>

				<br><br>

				<br><br><br>
				<div class="terms">
					<table>
						<tr>
							<td>
								<input type="checkbox" name="terms_p" id="terms_p">
								<label for="terms_p"></label>
							</td>
							<td>
								<label>개인정보 제공 동의</label>
							</td>
							<td>
								<label id="agree1">[보기]</label>
							</td>
							<td>
								<label>[필수]</label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="terms_t" id="terms_t">
								<label for="terms_t"></label>
							</td>
							<td>
								<label>이용 약관 동의</label>
							</td>
							<td>
								<label id="agree2">[보기]</label>
							</td>
							<td>
								<label>[필수]</label>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="terms_m" id="terms_m">
								<label for="terms_m"></label>
							</td>
							<td>
								<label>마케팅 수신 정보 동의</label>
							</td>
							<td></td>
							<td>
								<label>[선택]</label>
							</td>
						</tr>
					</table>
				</div>
				<br><br><br>

				<div class="submit_reset">
					<input type="button" id="registMember" value="회원가입" onclick="return confirmRegist();">
					<input type="button" value="취소" id="cancel">
				</div>
			</form>
		</div>
	</div>
	<br><br><br><br><br>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		/* 비밀번호 유효성 체크 */
		$('#password').change(function() {
			checkPassword($('#password').val());
		});
		
		const reg_pwd = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; /* 영문 숫자 혼합 8 - 20자 */
		
		function checkPassword(pwd) {
			
			let isUsePwd = false;
			
			if(!reg_pwd.test(pwd)) {
				/* alert('영문 + 숫자 조합 8자리 이상 사용해야 합니다.');
				$('#password').val('').focus(); */
				isUsePwd = false;
			} else {
				
			
			/* var checkNumber = password.search(/[0-9]/g);
			var checkEnglish = password.search(/[a-z]/ig);
			if(checkNumber < 0 || checkEnglish < 0) {
				alert('숫자와 영문을 혼용하여야 합니다.');
				$('#password').val('').focus();
				return false;
			}
			
			if(/(\w)\1\1\1/.test(password)) {
				alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
				$('#password').val('').focus();
				return false;
			} */
			
				isUsePwd = true;
			}
		
			if(!isUsePwd) {
				$('#pwd_check').text('영문 + 숫자 조합 8자리 이상 사용해야 합니다.');	
				$('#pwd_check').css('color', 'orangered');
				$('#password').val('').focus();
				return false;
			} else {
				$('#pwd_check').text('사용 가능합니다.');	
				$('#pwd_check').css('color', '#1EA4FF');
				return true;
			}
			
		}
	</script>
	
	<script>
		/* 아이디(이메일) 중복 체크 */
		$('#email').blur(function() {
			
				$.ajax({
					url : '/semi/member/infoCheck',
					data : { email: $('#email').val() },
					method : 'GET',
					success : function(data, textStatus, xhr) {
						
						var obj = JSON.parse(data);
						
						if(obj.result === 'unable') {
							$('#id_check').text('사용중인 아이디 입니다.');
							$('#id_check').css('color', 'orangered');
							$('#email').focus();
							$('.certify').attr('disabled', true);
						} else if(obj.result === 'able' && $('#email').val() !== "") {
							$('#id_check').text('사용 가능합니다.');
							$('#id_check').css('color', '#1EA4FF');
							$('.certify').attr('disabled', false);
						}
					},
					error : function(xhr, status, error) {
						console.log(xhr);
						console.log(status);
						console.log(error);
					},
				});
			});
	</script>
	
	<script>
		/* 메일인증 가입 */ 
		function sendVerificationNumber() {
			
			const email = document.getElementById("email").value;
			const $verifyForm = document.getElementById("verifyForm");
			
			if(!email || email === "") {
				alert("이메일을 반드시 입력해야 합니다.");
				document.getElementById("email").focus();
				return false;
			}
			
			$verifyForm.action = "${ pageContext.servletContext.contextPath }/member/registVerfication";
			$verifyForm.submit();
			
			alert("인증번호가 발송되었습니다. 메일을 확인해보세요.");
			
		}
		
		//인증번호를 쳐야지만 확인 버튼이 눌리는 로직
		$(document).ready(function() {
		         		$('#verificationNumber').on('keyup', function() {
		         			var flag = true;
		         			flag = $(this).val().length > 0 ? false : true;
		         			$('.certify2').attr('disabled', flag);
		         		});
		         		
		         		/* caps lock 체크 */
		         		$("#password").on("keypress", function(e) { 
		         			
		         			var text = String.fromCharCode( e.which );
		         			
		         		    if ( text.toUpperCase() === text && text.toLowerCase() !== text && !e.shiftKey ) { 
		         		    	$('#caps_check').text('Caps Lock이 켜져있습니다.');	
		        				$('#caps_check').css('color', 'orangered');
		         		    } else {
		         		    	$('#caps_check').text('');	
		         		    }
		         		});
		         			         		
		});
		
		/* 인증번호 확인 */
		function confirm() {
			
			const verificationNumber = document.getElementById("verificationNumber").value;

			const $password = document.getElementById("password");
			const $password2 = document.getElementById("password2");
			const $name = document.getElementById("name");
			const $phone = document.getElementById("phone");
			
			/* 인증번호 확인 */
			if(!verificationNumber || verificationNumber === "") {
				alert("인증번호를 입력해야 합니다.");
				document.getElementById("verificationNumber").focus();
				return false;
			}
			
			if(verificationNumber != "${ requestScope.verificationNumber }") {
				alert("인증번호가 다릅니다.");
				document.getElementById("verificationNumber").focus();
				return false;
			}
			
			alert("인증되었습니다.");
			
			$password.disabled = false;
			$password2.disabled = false;
			$name.disabled = false;
			$phone.disabled = false;
			
		}
		
	</script>
	
	<script>
		/* 필수 항목이 다 눌렸을 때만 회원가입 버튼을 눌를 수 있도록 */
		function confirmRegist() {

			const email = document.getElementById("email").value;
			const password = document.getElementById("password").value;
			const password2 = document.getElementById("password2").value;
			const name = document.getElementById("name").value;
			const phone = document.getElementById("phone").value;
			const termsP = document.getElementById("terms_p");
			const termsT = document.getElementById("terms_t");
			
			if(!email || email === "") {
				alert("이메일을 반드시 입력해야 합니다.");
				document.getElementById("email").focus();
				return false;
			}
			
			if(!password || password === "") {
				alert("비밀번호를 반드시 입력해야 합니다.");
				document.getElementById("password").focus();
				return false;
			}
			
			if(!password2 || password2 === "") {
				alert("비밀번호를 반드시 입력해야 합니다.");
				document.getElementById("password2").focus();
				return false;
			}
			
			if(!(password === password2)) {
				alert("비밀번호가 다릅니다.")
				document.getElementById("password2").focus();
				return false;
			}
			
			if(!name || name === "") {
				alert("이름을 반드시 입력해야 합니다.");
				document.getElementById("name").focus();
				return false;
			}
			
			if(!phone || phone === "") {
				alert("전화번호를 반드시 입력해야 합니다.");
				document.getElementById("phone").focus();
				return false;
			}
			
			if(!(termsP.checked)) {
				alert("개인정보 제공에 동의하셔야 합니다.");
				/* 왜 포커스가 안될까? */
				document.getElementById("terms_p").focus();
				return false;
			}
			
			if(!(termsT.checked)) {
				alert("이용약관에 동의하셔야 합니다.");
				/* 왜 포커스가 안될까? */
				document.getElementById("terms_t").focus();
				return false;
			}
			
			const $myform = document.getElementById("myForm");
			$myform.action = "${ pageContext.servletContext.contextPath }/member/regist";
			$myform.submit(); 
			
			
			
			/* /* const path = "${ pageContext.servletContext.contextPath }/member/regist";
			/* 스크립트로 form 보내기  */
			
			/* form 생성 */
			/* var form = document.createElement("form"); */
			
			/* method와 action 추가 */
			/* form.setAttribute("method", "post");
			form.setAttribute("action", path); */
			
			/* body에 form 추가 */
			/* document.body.appendChild(form); */
			
			/* input태그 생성  */
			/* var input_email = document.createElement("input"); */
			
			/* input_email.setAttribute("type", "email")
			input_email.setAttribute("name", "email")
			input_email.setAttribute("value", email); */
			/* form에 input 추가 */
			/*form.appendChild(input_email);
			
			var input_name = document.createElement("input");
			input_name.setAttribute("type", "text");
			input_name.setAttribute("name", "name");
			input_name.setAttribute("value", name);
			form.appendChild(input_name);
			
			var input_password = document.createElement("input");
			input_password.setAttribute("type", "password");
			input_password.setAttribute("name", "password");
			input_password.setAttribute("value", password);
			form.appendChild(input_password);
			
			var input_phone = document.createElement("input");
			input_phone.setAttribute("type", "tel");
			input_phone.setAttribute("name", "phone");
			input_phone.setAttribute("value", phone);
			form.appendChild(input_phone);
			
			form.submit(); */
			
		
		}
	</script>
</body>
</html>