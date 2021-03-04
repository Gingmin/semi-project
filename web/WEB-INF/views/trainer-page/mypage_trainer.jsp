<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/mypage_trainer.css">
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/index.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">

	<title>마이페이지</title>
</head>
<body>

	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<div class="container">
			<div class="profile_area">
				<div class="profile_text">
					나의 프로필
				</div>
				<div class="row">
					<div class="profile_img_area">
						<div class="profile_img">
							<img class="img_detail" src="/semi/resources/images/testimg.JPG">
						</div>
						<div class="profile_btn_area">
							<a class="edit_btn" href="#">프로필 편집</a>	
						</div>						
					</div>
					<div class="profile_info_area">
						
						<div class="class_btn">
							<label class="switch">
								<input type="checkbox">
								<span class="slider round"></span>
							</label>
							<span class="start_btn">나의클래스</span>
							<p>OFF</p><p style="display:none;">ON</p>
						</div>

						<div class="profile_etc_btn">
							<div class="row">
								<div class="etc_btn">
									<a class="etc_detail" href="#" id="sales-details">매출내역</a>
								</div>
								<div class="etc_btn">
									<a class="etc_detail" href="#">신고</a>
								</div>
								<div class="etc_btn">
									<a class="etc_detail" href="#">회원탈퇴</a>
								</div>
							</div>
						</div>
					</div>					
				</div>

				<div class="line"></div>

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
											아직 일정이 없습니다.
										</div>
									</div>
									<div class="btnlist_kinds col-4" >
										<div class="btn_area">
											<button class="btnlist_detail">취소</button>
										</div>											
										<div class="calendar_text">
											아직 일정이 없습니다.
										</div>
									</div>
								</div>									
							</div>
						</div>
					</div>
				</div>

				<div class="line"></div>

				<div class="class_management_area">
					<div class="class_text">
						나의 클래스 관리
					</div>
					<div class="class_btn_list">
						<div class="row">
							<div class="cm_btn_list">
								<div class="cm_btn">
									모든클래스
								</div>
							</div>
							<div class="cm_btn_list">
								<div class="cm_btn">
									1:1클래스
								</div>
							</div>
							<div class="cm_btn_list">
								<div class="cm_btn">
									그룹클래스
								</div>
							</div>
						</div>
					</div>

					
				</div>

				<div class="insert_btn">
					<a class="insert_detail" href="#" id="insert_class">클래스 추가하기</a>
				</div>




			</div>
		</div>
		<!-- 푸터 -->
		<jsp:include page="../common/footer.jsp"/>
		<!-- 푸터끝 -->
	</div>



<script type="text/javascript">
	
	var check = $("input[type='checkbox']");
	check.click(function(){
	$("p").toggle();
});

	$(function(){ 
		$(".btnlist_detail").click(function(e){
			e.preventDefault();

			var $t = $(this);
			var $s = $(".calendar_text")

			$t.toggleClass("on");
			$s.toggleClass("on");
		})
	})
	$(function(){ 
		$(".cm_btn").click(function(e){
			e.preventDefault();

			var $t = $(this);
			

			$t.toggleClass("on");
			
		})
	})
</script>

		
</body>
</html>