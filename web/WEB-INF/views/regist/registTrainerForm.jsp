<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트레이너 회원가입</title>
<link rel="stylesheet" href="/semi/resources/css/member/registTrainer.css">
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
					<input type="text" value="trn" name="trn" style="display: none;">
				</div>
				<br>
				<p id="id_check"></p>
				
				<br>
				<div class="info_item1">
					<input class="box_detail2" type="text" name="verificationNumber" id="verificationNumber" placeholder="인증번호를 입력하세요">
					<button class="certify2" type="button" disabled onclick="return confirm();">확인</button>
				</div>
			</form>
			
				<form class="info" action="" method="post" id="myForm" encType="multipart/form-data">
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
				<div class="info_item1">
					<div class="info_text1">
						계좌번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" id="account" name="account" placeholder="계좌번호를 입력하세요" disabled>
				</div>

				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						은행명 <span class="info_detail">*</span>
					</div>
					<select class="box_detail" name="bankname" id="bankname" disabled>
						<option selected disabled hidden>선택하세요</option>
						<option>KB국민은행</option>
						<option>NH농협은행</option>
						<option>SH수협은행</option>
						<option>우리은행</option>
						<option>신한은행</option>
						<option>하나은행</option>
						<option>SC제일은행</option>
						<option>힌극씨티은행</option>
						<option>IBK기업은행</option>
						<option>KDB산업은행</option>
						<option>카카오뱅크</option>
					</select>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						에금주 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" id="holder" name="holder" placeholder="예금주를 입력하세요" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						경력사항 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" id="placeWork" name="placeWork" placeholder="근무처를 입력하세요" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						근무시작일 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="date" id="startDate" name="startDate" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						근무종료일 <span class="info_detail"></span>
					</div>
					<input class="box_detail" type="date" id="endDate" name="endDate" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						재직여부 <span class="info_detail">*</span>
					</div>
					<select class="box_detail" name="empStatus" id="empStatus" disabled>
						<option selected disabled hidden>선택하세요</option>
						<option>N</option>
						<option>Y</option>
					</select>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						자격증번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="licenseCode" id="licenseCode" placeholder="자격증번호 or 면허증번호" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						자격증명 <span class="info_detail">*</span>
					</div>
					<select class="box_detail" name="licenseName" id="licenseName" disabled>
						<option selected disabled hidden>선택하세요</option>
						<option>생활스포츠지도사</option>
						<option>물리치료사</option>
					</select>	
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						급수 <span class="info_detail">*</span>
					</div>
					<select class="box_detail" name="grade" id="grade" disabled>
						<option selected disabled hidden>선택하세요</option>
						<option>1급</option>
						<option>2급</option>
					</select>	
				</div>

				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						발급기관 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" id="institution" name="institution" readonly>
				</div>
				
				<script>
				/* 자격증마다 자동으로 발급기관 띄우기 */
					$('#licenseName').change(function() {
						
						var value = $(this).children('option:selected').text();
						
						if('생활스포츠지도사' === value) {
							$('#grade').attr('disabled', false);
							$('#institution').val('국민체육공단');
						}
						if('물리치료사' === value) {
							$('#grade').attr('disabled', true);
							$('#institution').val('한국보건의료인국가시험원');
							document.getElementById("grade").value = "선택하세요";
						}
					
					});
				</script>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						발급일자 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="date" name="issueDate" id="issueDate" disabled>
				</div>
				
				<br>
				
				<div class="info_item1">
					<div class="info_text1">
						만료일자 <span class="info_detail"></span>
					</div>
					<input class="box_detail" type="date" name="expDate" id="expDate" disabled>
				</div>
				
				<br>
				<div class="info_item1">
					<div class="info_text1">
						자격증 첨부 <span class="info_detail">*</span>
					</div>
				</div>
				<div class="filebox preview-image">
					<input class="upload-name" value="파일선택" disabled>
					<label for="inputFile">업로드</label>
					<input type="file" id="inputFile" class="upload-hidden" name="inputFile" multiple disabled>
				</div>
				
				<script>
					var fileTarget = $('.filebox .upload-hidden'); 
					fileTarget.on('change', function(){ // 값이 변경되면 
							
					if(window.FileReader){ // modern browser 
						var filename = $(this)[0].files[0].name; 
					} else { // old IE var 
						filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
					} // 추출한 파일명 삽입 
					$(this).siblings('.upload-name').val(filename);
						
					}); 
					
					var imgTarget = $('.preview-image .upload-hidden'); 
					
					imgTarget.on('change', function(){ 
						var parent = $(this).parent(); 
						parent.children('.upload-display').remove(); 
						
						if(window.FileReader){ //image 파일만
							if (!$(this)[0].files[0].type.match(/image\//)) return; 
						
						var reader = new FileReader(); 
						reader.onload = function(e){ 
							var src = e.target.result; 
							parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>'); 
						} 
						reader.readAsDataURL($(this)[0].files[0]); 
						
					} else { 
						$(this)[0].select(); 
						$(this)[0].blur(); 
						var imgSrc = document.selection.createRange().text; 
						parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');
						
						var img = $(this).siblings('.upload-display').find('img'); 
						img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")"; 
					} 
				});
				</script>
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
		
		$(document).ready(function() {
		//인증번호를 쳐야지만 확인 버튼이 눌리도록
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
			const $account = document.getElementById("account");
			const $bankname = document.getElementById("bankname");
			const $holder = document.getElementById("holder");
			const $placeWork = document.getElementById("placeWork");
			const $startDate = document.getElementById("startDate");
			const $endDate = document.getElementById("endDate");
			const $empStatus = document.getElementById("empStatus");
			const $licenseCode = document.getElementById("licenseCode");
			const $licenseName = document.getElementById("licenseName");
			const $grade = document.getElementById("grade");
			const $issueDate = document.getElementById("issueDate");
			const $expDate = document.getElementById("expDate");
			const $inputFile = document.getElementById("inputFile");
			
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
			$account.disabled = false;
			$bankname.disabled = false; 
			$holder.disabled = false; 
			$placeWork.disabled = false; 
			$startDate.disabled = false; 
			$endDate.disabled = false; 
			$empStatus.disabled = false;
			$licenseCode.disabled = false; 
			$licenseName.disabled = false; 
			$grade.disabled = false; 
			$issueDate.disabled = false; 
			$expDate.disabled = false; 
			$inputFile.disabled = false;
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
			const account = document.getElementById("account").value;
			const holder = document.getElementById("holder").value;
			const placeWork = document.getElementById("placeWork").value;
			const startDate = document.getElementById("startDate").value;
			const licenseCode = document.getElementById("licenseCode").value;
			const issueDate = document.getElementById("issueDate").value;
			const inputFile = document.getElementById("inputFile").value;
			
			const $bankname = document.getElementById("bankname");
			const bankname = $bankname.options[$bankname.selectedIndex].value;
			
			const $empStatus = document.getElementById("empStatus");
			const empStatus = $empStatus.options[$empStatus.selectedIndex].value;
			
			const $licenseName = document.getElementById("licenseName");
			const licenseName = $licenseName.options[$licenseName.selectedIndex].value;
			
			const $grade = document.getElementById("grade");
			const grade = $grade.options[$grade.selectedIndex].value;
			
				
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
			
			if(!account || account === "") {
				alert("계좌번호를 반드시 입력해야 합니다.");
				document.getElementById("account").focus();
				return false;
			}
			
			if(!bankname || bankname === "" || bankname === "선택하세요") {
				alert("은행을 반드시 선택해야 합니다.");
				document.getElementById("bankname").focus();
				return false;
			}
			
			if(!holder || holder === "") {
				alert("예금주를 반드시 입력해야 합니다.");
				document.getElementById("holder").focus();
				return false;
			}
			
			if(!placeWork || placeWork === "") {
				alert("근무처를 반드시 입력해야 합니다.");
				document.getElementById("placeWork").focus();
				return false;
			}
			
			if(!startDate || startDate === "") {
				alert("근무시작일을 반드시 입력해야 합니다.");
				document.getElementById("startDate").focus();
				return false;
			}
			
			if(!empStatus || empStatus === "" || empStatus === "선택하세요") {
				alert("재직여부를 반드시 선택해야 합니다.");
				document.getElementById("empStatus").focus();
				return false;
			}
			
			if(!licenseCode || licenseCode === "") {
				alert("자격증 번호를 반드시 입력해야 합니다.");
				document.getElementById("licenseCode").focus();
				return false;
			}
			
			if(!licenseName || licenseName === "" || licenseName === "선택하세요") {
				alert("자격증명을 반드시 입력해야 합니다.");
				document.getElementById("licenseName").focus();
				return false;
			}
			
			if(licenseName === "생활스포츠지도사") {
				if(!grade || grade === "" || grade === "선택하세요") {
					alert("급수를 반드시 선택해야 합니다.");
					document.getElementById("grade").focus();
					return false;
				}
			}
			
			if(!issueDate || issueDate === "") {
				alert("발급일자를 반드시 입력해야 합니다.");
				document.getElementById("issueDate").focus();
				return false;
			}
			
			if(!inputFile || inputFile === "") {
				alert("자격증을 반드시 첨부해야 합니다.");
				document.getElementById("inputFile").focus();
				return false;
			}
			
			if(!(termsP.checked)) {
				alert("개인정보 제공에 동의하셔야 합니다.");
				/* 왜 포커스가 안될까? */
				return false;
			}
			
			if(!(termsT.checked)) {
				alert("이용약관에 동의하셔야 합니다.");
				/* 왜 포커스가 안될까? */
				return false;
			}
			
			const $myform = document.getElementById("myForm");
			$myform.action = "${ pageContext.servletContext.contextPath }/trainer/regist";
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