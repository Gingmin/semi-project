<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반회원 로그인</title>
<link rel="stylesheet" href="/semi/resources/css/loginMember.css">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<!-- body -->
	<div class="container">
		<div class="info_area">
			<div class="info_text">로그인</div>
			<br>

			<div class="submit_reset">
				<input type="button" class="choice ch1" value="일반회원"
					onclick="location.href='http://127.0.0.1:8001/semi/views/login/loginMember.html'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="choice ch2" value="트레이너"
					onclick="location.href='http://127.0.0.1:8001/semi/views/login/loginTrainer.html'">
			</div>
			<br>
			<br>

			<form class="info"
				action="${ pageContext.servletContext.contextPath }/member/login"
				method="post">
				<div class="info_item1">
					<div class="info_text1">
						이메일 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="email" name="email"
						placeholder="이메일을 입력해주세요" autofocus>
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						비밀번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="password" name="password"
						placeholder="비밀번호를 입력하세요">
				</div>

				<br>
				<br>

				<div class="submit_reset">
					<input type="submit" value="로그인" name="login" id="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" name="cancel" id="cancel">
				</div>

				<br>
				<br>
				<div class="info_item1">
					<div class="guide">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="regist" id="regist" value="회원가입">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="regist" id="FindEmail" value="계정찾기">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="regist" id="FindPwd" value="비밀번호 찾기">
					</div>
				</div>

			</form>

		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
</body>
</html>