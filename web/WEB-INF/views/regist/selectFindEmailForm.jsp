<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/member/selectFindEmailForm.css">
<title>계정 찾기</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
		<div class="info_area">
			<div class="info_text">가입한 이메일 찾기</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						이름 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="name" id="name"
						placeholder="가입하신 이름을 입력하세요" value="" >
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						전화번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="phone" id="phone"
						placeholder="가입하신 전화번호를 입력하세요">
				</div>

				<br>
				<br>
				<div class="submit_reset">
					<input type="button" value="찾기" name="confirm" id="confirm"
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
	
		const name = document.getElementById("name").value;
		const phone = document.getElementById("phone").value;
		
		const $myForm = document.getElementById("myForm");
		
		if(!name || name === "") {
			alert("이름을 반드시 입력해야합니다.");
			document.getElementById("name").focus();
			return false;
		}
		
		if(!phone || phone === "") {
			alert("전화번호를 반드시 입력해야합니다.");
			document.getElementById("phone").focus();
			return false;
		}
		
		const requestPath = "${ pageContext.servletContext.contextPath }/member/findEmail";
		$myForm.action = requestPath;
		$myForm.submit();
	}
</script>
</body>
</html>