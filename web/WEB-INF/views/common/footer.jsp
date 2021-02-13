<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 폰트 -->
<link rel="stylesheet" href="http://fonts.cdnfonts.com/css/rock-salt">
<!-- js -->
<script src="/semi/resources/js/event.js"></script>
<!-- css -->
<link rel="stylesheet" href="/semi/resources/css/footer.css">

</head>
<body>
	<div class="footer_area">
		<div class="footer_logo">HELLOPT</div>
		<div class="row">
			<div class="company_info">
				<div class="info_text">수원코딩왕과 30대들</div>
				<div class="info_text">사업자등록번호 2324-49-69023</div>
				<div class="info_text">제 2021-서울논현-2324호</div>
				<div class="info_text">서울시 뉴욕 퇴계로 헬로키티빌딩 헬로우좀</div>
				<div class="info_text">2021 HELLOPT,INCALL RIGHTS RESERVED</div>
			</div>
			<div class="service_area">
				<div class="service_info">고객센터</div>
				<div class="service_text">
					<a class="service_text_1" href="#">aHelp@HelloPT.com</a>
				</div>
				<div class="service_text">HELLOPT Recruit</div>
			</div>
			<div class="terms_area">
				<div class="terms_info">약관</div>
				<div class="terms_text">
					<!-- <a class="terms_text_1" id="terms">이용약관</a> -->
					<input type="button" class="terms_text_1" id="terms" value="이용약관">
				</div>
				<div class="terms_text">
					<!-- <a class="terms_text_1"
						href="http://kordzor.cafe24.com/semiproject/privacy_policy.html">개인정보
						처리방침</a> -->
					<input type="button" class="terms_text_1" id="privacy" value="개인정보 처리방침">
				</div>
			</div>
		</div>
	</div>
</body>
</html>