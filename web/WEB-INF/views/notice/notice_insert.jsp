<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<link rel="stylesheet" href="/semi/resources/css/index.css">
	<link rel="stylesheet" href="/semi/resources/css/notice_board.css">
	<link rel="stylesheet" href="/semi/resources/css/notice_detail.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">


	<title>HelloPT</title>



</head>
<body>
	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<!-- 메인 배너 -->
		<div class="banner_area">
			<img class="banner_detail" src="/semi/resources/images/notice_banner.JPG">
		</div>
		<!-- 메인 배너 끝 -->
		<div class="container">
			<div class="notice_menu_area">
				<div class="row">
					<div class="menu_list col-sm-4">
						<input type="button" class="list_detail on" value="공지사항" id="noticeNotice">
					</div>
					<div class="menu_list col-sm-4">
						<input type="button" class="list_detail" value="신고 내역" id="noticeReport">
					</div>
					<div class="menu_list col-sm-4">
						<input type="button" class="list_detail" value="자주 묻는 질문" id="noticeQuestion">
					</div>
				</div>
			</div>
			<div class="notice_name">
				공지사항
			</div>
			<div class="line"></div>
			<form action="${ pageContext.servletContext.contextPath }/notice/insert" method="post">
				<div class="notice_detail_area">
					<div class="row">
						<div class="notice_title">
							제목 : 
							<input class="no_title_detail" type="text" name="title"/>
						</div>	
						<div class="notice_writer">작성자 : <input class="no_writer_detail" type="text" value="${ sessionScope.loginMember.name}" name="writer"></div>
					</div>	
					<div class="content_area">
						<div class="writing_date" >${ requestScope.creatDate }</div>
						<textarea class="textarea_detail" name="body"></textarea>
					</div>
				</div>	
				<div class="btn_area">
					<div class="row">					
						<button type="reset" class="btn_detail" id="cancle">취소</button>
						<button type="submit" class="btn_detail">등록하기</button>
					</div>
				</div>
			
			</form>

			

			
	

			
		</div>
		<jsp:include page="../common/footer.jsp"/>
	</div>


		
</body>
</html>