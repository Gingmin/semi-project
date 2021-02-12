<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 회원가입</title>
<link rel="stylesheet" href="/semi/resources/css/registMember.css">
<!-- <script type="text/javascript" src="/semi/resources/js/registSettings.js"></script> -->
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="container">
		<div class="info_area">
			<div class="info_text">회원가입</div>
			<br>

			<div class="submit_reset">
				<input type="button" class="choice ch1" value="일반회원"
					onclick="location.href='http://127.0.0.1:8001/semi/views/regist/registMember.html'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="choice ch2" value="트레이너"
					onclick="location.href='http://127.0.0.1:8001/semi/views/regist/registTrainer.html'">
			</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						이메일 주소 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="email" id="email"
						placeholder="이메일주소를 입력해주세요" autofocus>
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						비밀번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password" id="password"
						placeholder="비밀번호를 입력하세요">
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						비밀번호 확인 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password" id="password2"
						placeholder="비밀번호를 입력하세요">
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
						placeholder="이름를 입력하세요">
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						연락처 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="tel" name="phone" id="phone"
						placeholder="전화번호를 입력하세요">
				</div>

				<br><br>

				<!-- <div class="info_item1">
					<div class="info_text1">
						성별 <span class="info_detail">*</span>
					</div>
					<br><br>
					<div class="radio_align">

						<label for="male">남자</label>&nbsp;&nbsp;&nbsp; 
						<input class=""	type="radio" name="gender" id="male"> &nbsp;&nbsp;&nbsp;
						<label for="female">여자</label>&nbsp;&nbsp;&nbsp; 
						<input class=""	type="radio" name="gender" id="female">

					</div>
				</div> -->

				<br><br><br><br><br><br>
				<div>
					<div class="terms">
						<input type="checkbox" name="terms_p" id="terms_p">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label for="terms_p"></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>개인정보 제공 동의</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="http://kordzor.cafe24.com/semiproject/privacy_policy.html">[보기]</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>[필수]</label>
					</div>
					<br><br><br>
					<div class="terms">
						<input type="checkbox" name="terms_t" id="terms_t">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label for="terms_t"></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>이용 약관 동의</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="http://kordzor.cafe24.com/semiproject/terms_service.html">[보기]</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<label>[필수]</label>
					</div>
					<br><br><br>
					<div class="terms">
						<input type="checkbox" name="terms_m" id="terms_m">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label for="terms_m"></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>마케팅 수신 정보 동의</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>[선택]</label>
					</div>
				</div>
				<br><br><br><br><br><br>

				<div class="submit_reset">
					<input type="button" id="registMember" value="회원가입" onclick="return confirmRegist();">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="취소" id="cancel">
				</div>
				<!-- 팝업 -->
				<!-- <div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<i class="fas fa-dumbbell"></i>
							</div>
							<div class="modal-body">
								<div class="modal_text">회원가입 하시겠습니까?</div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal" id="btn_submit"
									onclick="location.href='http://127.0.0.1:8001/semi/'">확인</button>
							</div>
						</div>
					</div>
				</div> -->

			</form>

			<!-- 팝업 -->
		</div>
	</div>
	<br><br><br><br><br>
	<jsp:include page="../common/footer.jsp"/>
	
	<script>
		/* 필수 항목이 다 눌렸을 때만 회원가입 버튼을 눌를 수 있도록 */
		function confirmRegist() {

			const email = document.getElementById("email").value;
			const password = document.getElementById("password").value;
			const password2 = document.getElementById("password2").value;
			const name = document.getElementById("name").value;
			const phone = document.getElementById("phone").value;
			/* const male = document.getElementById("male");
			const female = document.getElementById("female"); */
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
			
			/* if(!(male.checked || female.checked)) {
				alert("성별을 선택해야 합니다.");
				document.getElementById("male").focus();
				return false;
			} */
			
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