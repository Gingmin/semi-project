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
						      비밀번호가 기억 나지 않는 경우 :
                                                      로그인 페이지 하단에서 "비밀번호 찾기"를 선택하십시오. 
                           HELLOPT에서 사용하던 이메일을 입력하고 "다음"을 선택하십시오.
                                                      사용하던 이메일의 등록된 이름과 이메일을 입력 후 인증번호받기를 클릭합니다. 
                                                      입력 된 이메일에서 전송 된 인증번호를 확인하십시오. 
                                                      새 비밀번호와 새 비밀번호 확인을 입력하고 확인을 선택합니다. 
						</div>	
					</div>
					<div class="question_list type">					
						<div class="q_text1">멤버십 일시 중지</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo1">자세히 보기 >></button>
						<div id="demo1" class="collapse">
							귀하의 계정이 활성화되어있는 한 귀하의 멤버십을 일시 중지할 수 있습니다. 
							멤버십을 일시 중지하려면 별도의 양식을 작성하여 제출해 주십시오 . 
							일시 중지 된 기간이 만료되면 멤버십이 자동으로 복원됩니다. 
							멤버십을 일시 중지하면 HELLOPT 콘텐츠에 대한 액세스도 일시 중지됩니다.
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="question_list">					
						<div class="q_text1">계정 이메일 업데이트</div>
						<button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo2">자세히 보기 >></button>
						<div id="demo2" class="collapse">
							HELLOPT 멤버십의 이메일 주소를 변경하려면 다음 단계를 따르십시오.
							 페이지 하단에서 "로그인"을 클릭합니다 (왼쪽 하단).
							이메일 주소와 비밀번호를 입력하세요
							왼쪽 메뉴에서 "내 계정"을 선택합니다.
							"이메일 주소"옆에있는 "(변경)"을 클릭합니다.
							새 이메일 주소를 입력하고 "이메일 변경"을 선택하십시오.
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