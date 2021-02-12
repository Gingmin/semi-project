<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<link rel="stylesheet" href="/semi/resources/css/index.css">
	<link rel="stylesheet" href="/semi/resources/css/notice_board.css">
	<link rel="stylesheet" href="/semi/resources/css/notice_question.css">

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
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail " value="공지사항" id="noticeNotice">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail" value="리뷰" id="noticeReview">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail" value="신고 내역" id="noticeReport">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail on" value="자주 묻는 질문" id="noticeQuestion">
					</div>
				</div>
			</div>
			<div class="notice_name">
				자주 묻는 질문
			</div>
			<div class="line"></div>

			<div class="qna_list_area">
				<div class="q_text">계정 및 청구</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo">자세히 보기 >></button>
						<div id="demo" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo1">자세히 보기 >></button>
						<div id="demo1" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo2">자세히 보기 >></button>
						<div id="demo2" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo3">자세히 보기 >></button>
						<div id="demo3" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>								
			</div>
			<div class="qna_list_area">
				<div class="q_text">계정 및 청구</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo4">자세히 보기 >></button>
						<div id="demo4" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo5">자세히 보기 >></button>
						<div id="demo5" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo6">자세히 보기 >></button>
						<div id="demo6" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo7">자세히 보기 >></button>
						<div id="demo7" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>								
			</div>
			<div class="qna_list_area">
				<div class="q_text">계정 및 청구</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo8">자세히 보기 >></button>
						<div id="demo8" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo9">자세히 보기 >></button>
						<div id="demo9" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">비밀번호 변경 또는 재설정</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo10">자세히 보기 >></button>
						<div id="demo10" class="collapse">
							비번 이케 바꿔 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo11">자세히 보기 >></button>
						<div id="demo11" class="collapse">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						</div>	
					</div>
				</div>								
			</div>

			
			


			
	

		
	</div>
	<jsp:include page="../common/footer.jsp"/>
	
	</div>

		
</body>
</html>