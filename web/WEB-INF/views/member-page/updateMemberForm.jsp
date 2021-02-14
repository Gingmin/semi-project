<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/semi/resources/css/member/updateMemberForm.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
		<div class="info_area">
			<div class="info_text">내정보</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						이메일 주소 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="email" id="email"
						value="${ sessionScope.loginMember.email }" readonly>
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
				</div>
				<br>
				<div>
					<table>
						<tr>
							<td width="400px"></td>
							<td><input type="button" id="passwordChange" value="비밀번호 변경"></td>
						</tr>
					</table>
				</div>

				<br>
				<br>

				<div class="info_item1">
					<div class="info_text1">
						이름 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="name" id="name"
						value="${ sessionScope.loginMember.name }" placeholder="이메일주소를 입력해주세요" 
						placeholder="이름를 입력하세요" readonly>
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						연락처 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="tel" name="phone" id="phone"
						placeholder="전화번호를 입력하세요" value="${ sessionScope.loginMember.phone }">
				</div>
				<br>
				<div class="info_item1">
					<div class="info_text1">
						가입일 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="enrollDate" id="enrollDate"
						value="${ sessionScope.loginMember.enrollDate }" readonly>
				</div>

				<br><br>
				<c:if test="${ sessionScope.loginMember.role eq 'TRAINER' }">
					<!-- 트레이너 추가 정보칸 -->
				</c:if>
				<br><br><br>

				<div class="submit_reset">
					<input type="button" id="updateMember" value="수정" onclick="return movePath('updateMember');">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" id="updateMember" value="탈퇴" onclick="return movePath('deleteMember');">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" id="cancel">
				</div>
				<br><br><br>
			</form>
			<!-- 팝업 -->
		</div>
	</div>
	<br><br><br><br><br>
	
	<jsp:include page="../common/footer.jsp"/>
	<script>
	function movePath(intent) {

		const password = document.getElementById("password").value;
		const password2 = document.getElementById("password2").value;
		
		const $myForm = document.getElementById("myForm");
		
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
			alert("비밀번호가 다릅니다.");
			document.getElementById("password2").focus();
			return false;
		}
		
		let requestPath = "${ pageContext.servletContext.contextPath }";
		switch(intent) {
			case "updateMember" :
				requestPath += "/member/update"; break;
			case "deleteMember" :
				requestPath += "/member/delete"; break;
		}
		
		$myForm.action = requestPath;
		$myForm.submit();
	}
	</script>
	
</body>
</html>