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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 폰트 -->
<link rel="stylesheet" href="http://fonts.cdnfonts.com/css/rock-salt">
<!-- js -->
<script src="/semi/resources/js/event.js"></script>
<!-- css -->
<link rel="stylesheet" href="/semi/resources/css/header.css">
</head>
<body>
	<div class="header_area">
	   	<div class="row">
	      <div class="header_logo ">
	         <a class="logo_detail" href="">HELLOPT</a>
	      </div>
	      <div class="header_meun ">
	      <!-- 로그인이 안 되어 있는 경우  -->          
	      <c:if test="${ empty sessionScope.loginMember }">
	         <input type="button" class="loginPage" value="로그인" id="loginPage">
	      </c:if>
	      <!-- 로그인이 되어 있는 경우 -->
	      <c:if test="${ ! empty sessionScope.loginMember }">
	      	<span><c:out value="${ sessionScope.loginMember.name }"/>님 환영합니다.</span>
	      	<input type="button" class="logout" value="로그아웃" id="logout">
	      	<!-- 관리자페이지 -->
	      	<c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">
	      	<input type="button" class="adminPage" value="관리자 페이지" id="adminPage">
	      	</c:if>
	      </c:if>
	         <a class="menu_list" href="#">마이페이지</a>
	         <a class="menu_list" href="#">게시판</a>
	         <a class="menu_list" href="#">멤버쉽</a>
	         <a class="menu_list" href="#">트레이너</a>
	         <a class="menu_list" href="#">소개</a>
	      </div>
	   </div>
	</div>
<br><br><br><br><br>
</body>
</html>