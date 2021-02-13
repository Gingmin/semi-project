<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="/semi/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/semi/resources/css/classRegist.css">
<link rel="stylesheet" href="/semi/resources/css/index.css">
<script src="/semi/resources/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<!-- 헤더끝 -->

	<form action="" method="post">
		
		<div class="container">
			<h1 align="center">수업등록</h1>
			<label class="regist_text">클래스 이름 <span class="text_detail">*</span></label>
			<input type="text" name="name" class="input_detail">
			
			<label class="regist_text">클래스 종류 선택 <span class="text_detail">*</span></label>
			<div class="row">
			
	    		<input type="checkbox" class="btn-check" id="btn-check-2-outlined" checked autocomplete="off" name="ptclass">
				<label class="btn btn-outline-secondary" for="btn-check-2-outlined">1:1 클래스</label><br>
	    		<input type="checkbox" class="btn-check" id="btn-check-3-outlined" name="groupclass">
				<label class="btn btn-outline-secondary" for="btn-check-3-outlined">그룹 클래스</label><br>
	    		
			</div>	
			
			
			<label class="regist_text">카테고리</label>
			<div class="row">
				<input type="checkbox" class="btn-check" id="btn-check-4-outlined" name="health">
				<label class="btn btn-outline-secondary" for="btn-check-4-outlined">헬스</label><br>
				<input type="checkbox" class="btn-check" id="btn-check-5-outlined" disabled>
				<label class="btn btn-outline-secondary" for="btn-check-5-outlined">요가</label><br>
				<input type="checkbox" class="btn-check" id="btn-check-6-outlined" disabled>
				<label class="btn btn-outline-secondary" for="btn-check-6-outlined">필라테스</label><br>
			</div>
			
			<div>
				<label class="regist_text">
					수업을 소개할 문구 (3가지)<span class="text_detail">*</span>
				</label><br>
			<input type="text" name="intro1"><input type="text" name="intro2"><input type="text" name="intro3"></div>
			
			<div><label class="regist_text">개설할 클래스 소개*</label><br>
			<textarea rows="10" cols="10" class="textarea" name="introduce"></textarea></div>
			
			<label class="regist_text">수업 가능 시간을 선택해 주세요*</label>
			<div><input type="datetime-local" name="time"></div>
			<br>
			
			<div class="btn_area">
				<button type="submit" class="btn btn-default" id="classinsert">개설하기</button><br>
			</div>

   		 </div>
	
	</form>



	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
	<!-- 푸터끝 -->
</body>
</html>