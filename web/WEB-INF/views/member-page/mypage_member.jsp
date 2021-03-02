<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/mypage_member.css">
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/index.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

	<title>마이페이지</title>
</head>
<body>

	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<div class="container">
			<div class="member_info_area">
				<div class="member_area">
					<div class="member_text">
						마이 페이지
					</div>
					<div class="row">
						<form action="${ pageContext.servletContext.contextPath }/member/mypage" method="post">
							<div class="member_info">
								<div class="member_img_area" id="profilearea">
									<img class="img_detail" id="memberProfile">
								</div>
								<div class="member_name">
									<c:out value="${ sessionScope.loginMember.name }"/>
								</div>
								<div class="infobtn_area">
									<div class="row">
										<div class="membership_btn">
											<i class="far fa-star"></i>
											<label class="member_text1">
												프로필사진
												<input type="file" id="profilePhoto" class="member_text1" onchange="loadProfile(this, 1)" style="display:none;">
											</label>										
										</div>
										<div class="membership_btn">
											<i class="fas fa-credit-card"></i>
											<a href="#payment1" class="member_text1">
												결제 관리
											</a>
										</div>
									</div>
								</div>
							</div>
						</form>

						<div class="exercise_regi_area">
							<div class="row">
								<div class="regi_area">
									<div class="member_text2">
										정민서 님의 운동기록
									</div>
									<div class="row">
										<div class="exercise_count">
											<div class="member_text3">
												나의 운동횟수												
											</div>																						
											<div class="member_text4"> 
												그룹 클래스 
												<span class="member_count">1 회</span>
											</div>
											<div class="member_text4"> 
												1:1 클래스 
												<span class="member_count">0 회</span>
											</div>
											<div class="line"></div>
											<div class="count_sum">
												1 회
											</div>
										</div>
										<div class="exercise_time">
											<div class="member_text3">
												총 운동 시간												
											</div>																						
											<div class="member_text4"> 
												그룹 클래스 
												<span class="member_count">50 분</span>
											</div>
											<div class="member_text4"> 
												1:1 클래스 
												<span class="member_count">0 분</span>
											</div>
											<div class="line"></div>
											<div class="time_sum">
												1 분
											</div>
										</div>
									</div>	
								</div>

								<div class="myticket_area">
									<input type="button" value="무제한 클레스 참여하기" class="member_text5" id="participation">
									
									<div class="myticket">
										<div class="member_text6">
											나의 이용권											
										</div>																						
										<div class="member_text7"> 
											현재 이용중인 멤버십 
											<div class="ticket_kinds">free plan</div>
										</div>
										<div class="member_text7"> 
											남은횟수
											<div class="ticket_count">2 회</div>
										</div>
										
									</div>
								</div>									
							</div>							
						</div>
					</div>
				</div>
				<div class="memberbtn_area">
					<div class="row">
						<div class="declaration_btn">
							<input type="button" class="btn_detail" value="신고" id="report">
						</div>
						<div class="secession_btn">
							<input type="button" class="btn_detail" value="내정보" id="memberInfo">
						</div>
					</div>
				</div>
			</div>
			<!-- 회원정보 끝 -->


			
			<!-- <div class="line"></div> -->

			<div class="calendar_area">
				<div class="row">
					<div class="cld_left_area">
						<div class="cld_text">
							나의 수업 일정	
						</div>						
					</div>
					<div class="cld_right_area">
						<div class="cld_list">
							<div class="row">
								<div class=list_kinds>
									전체
								</div>
								<div class=list_kinds>
									그룹
								</div>
								<div class=list_kinds>
									1:1
								</div>
							</div>
						</div>
						<div class="line2"></div>
						<div class="cld_btnlist">
							<div class="row">
								<div class="btnlist_kinds col-4" >
									<div class="btn_area">
										<button class="btnlist_detail">예약</button>
									</div>											
									<div class="calendar_text">
										아직 일정이 없습니다.
									</div>
								</div>
								<div class="btnlist_kinds col-4" >
									<div class="btn_area">
										<button class="btnlist_detail">완료</button>
									</div>											
									<div class="calendar_text">
										
									</div>
								</div>
								<div class="btnlist_kinds col-4" >
									<div class="btn_area">
										<button class="btnlist_detail">취소</button>
									</div>											
									<div class="calendar_text">
										
									</div>
								</div>
							</div>	

						</div>
					</div>
				</div>
			</div>

			<div id="payment1" class="payment_history_area">
				<div class="ph_text">
					결제 내역
				</div>
				<div class="line3"></div>
				<div class="row">
					<div class="history_list">
						<span class="histry_item col-3">
							결제일
						</span>		
						<span class="histry_item col-3">
							클래스이름
						</span>
						<span class="histry_item col-3">
							결제금액
						</span>
						<span class="histry_item col-3">
							환불내역
						</span>				
					</div>
				</div>
				<div class="line3"></div>
			</div>

			<!-- <div class="line"></div> -->
		</div>
		<!-- 푸터 -->
		<jsp:include page="../common/footer.jsp"/>
		<!-- 푸터끝 -->
	</div>




<script type="text/javascript">
	$(function(){ 
		$(".btnlist_detail").click(function(){
			

			var $t = $(this);
			var $s = $(".calendar_text")

			$t.toggleClass("on");
			$s.toggleClass("on");
		})
	})
	
	
	function loadProfile(value, num) {
		if(value.files){
			const reader = new FileReader();
			
			reader.onload = function(e) {
				switch(num){
					case 1 :
						document.getElementById("memberProfile").src = e.target.result;
						break;
				}
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
	
</script>


		
</body>
</html>