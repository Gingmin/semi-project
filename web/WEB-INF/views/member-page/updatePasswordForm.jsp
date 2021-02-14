<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="/semi/resources/css/member/updatePasswordForm.css">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
		<div class="info_area">
			<div class="info_text">비밀번호 변경</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						현재 비밀번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password" id="password"
						placeholder="현재 비밀번호를 입력하세요" value="" >
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						새 비밀번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="newPassword" id="newPassword"
						placeholder="새 비밀번호를 입력하세요">
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						새 비밀번호 확인 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="newPassword2" id="newPassword2"
						placeholder="새 비밀번호를 입력하세요">
				</div>
				<br>
				<br>
				<div class="submit_reset">
					<input type="button" value="확인" name="confirm" id="confirm"
					  onclick="return movePath();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" name="cancel" id="cancel">
				</div>

			</form>
		</div>
	</div>
	<br><br><br><br><br>
	
	<jsp:include page="../common/footer.jsp"/>
	<script>
		function movePath() {

			const password = document.getElementById("password").value;
			const newPassword = document.getElementById("newPassword").value;
			const newPassword2 = document.getElementById("newPassword2").value;
			
			const $myForm = document.getElementById("myForm");
			
			if(!password || password === "") {
				alert("비밀번호를 반드시 입력해야합니다.");
				document.getElementById("password").focus();
				return false;
			}
			
			if(!newPassword || newPassword === "") {
				alert("새 비밀번호를 반드시 입력해야합니다.");
				document.getElementById("newPassword").focus();
				return false;
			}
			
			if(!newPassword2 || newPassword2 === "") {
				alert("새 비밀번호를 반드시 입력해야합니다.");
				document.getElementById("newPassword2").focus();
				return false;
			}
			
			if(password === newPassword) {
				alert("바꾸기 전 비밀번호와 똑같습니다.");
				document.getElementById("newPassword").focus();
				return false;
			}
			
			const requestPath = "${ pageContext.servletContext.contextPath }/member/passwordChange";
			$myForm.action = requestPath;
			$myForm.submit();
		}
	</script>
</body>
</html>