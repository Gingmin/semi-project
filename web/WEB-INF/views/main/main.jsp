<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HELLO PT!</title>
	<!-- 파비콘 -->
	<link rel="shortcut icon" href="/semi/resources/images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="/semi/resources/images/favicon.ico">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/index.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">


	<!-- 스와이퍼 -->
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

	<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	
	<!-- book -->


	
</head>
<body>
	
	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<!-- 메인 배너 -->
		<div class="banner_area">
			<img class="banner_detail" src="/semi/resources/images/anigif.gif">
		</div>
		<!-- 메인 배너 끝 -->

		<!-- 이용방법 -->
	
		
		<div class="container">
		

		

	
			<div class="howuse_area">
				<div class="row">
					<div class="howuse_img_area">				
					    <div id="myCarousel" class="carousel slide">
					    	<div class="row">	
					   
					    		<div class="maintext">HelloPT 이용 방법</div>	
					    			
				    			<div class="carousel-inner" role="listbox">
									<div class="item active ">
										<img class="img_detail" src="/semi/resources/images/registerimg.JPG">
										<div class="ex_text1">
											<span class="ex_number">1.</span>
											홈페이지 접속시 회원가입을 하세요.
										</div>
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/loginimg.JPG">
										<div class="ex_text1">
											<span class="ex_number">2.</span>
											회원가입이 완료되었다면 로그인을 해주세요
										</div>
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/membershipimg.JPG">
										<div class="ex_text1">
											<span class="ex_number">3.</span>
											로그인후 상단에 맴버십 페이지에서 원하는 이용권을 구매하세요
										</div>
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/ex_img_4.JPG">
										<div class="ex_text1">
											<span class="ex_number">4.</span>
											이용권을 구매했으면 클래스 페이지에서 원하는 수업을 선택하세요.
										</div>
									</div>
									<div class="item">
										<img class="img_detail" src="/semi/resources/images/ex_img_5.JPG">
										<div class="ex_text1">
											<span class="ex_number">5.</span>
											마음에 드는 수업을 고르셨다면 클릭후 예약 버튼을 눌러주세요
										</div>
									</div>
									<div class="item">
										<img class="img_detail" src="/semi/resources/images/ex_img_6.png">
										<div class="ex_text1">
											<span class="ex_number">6.</span>
											예약을 하셨다면 시간에 맞춰 수업에 들어가시면됩니다.
										</div>
									</div>
									<div class="item">
										<img class="img_detail" src="/semi/resources/images/ex_img_7.JPG">
										<div class="ex_text1">
											<span class="ex_number">7.</span>
											수업이 끝났다면 리뷰를 남겨주세요
										</div>
									</div>
								</div>	 	
				    		 		
					    	</div>		    	


						   <!--  Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" role="button">
								<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>							
							</a>
							<a class="right carousel-control" href="#myCarousel" role="button">
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>							
							</a>
					    </div>
					</div>
				</div>
			</div> 
		<!-- 이용방법 끝 -->
		<!-- 트레이너 영역 -->
			


		</div>
		<div class="trainer_area">
			<div class="swiper-container">
				<div class="contant_name">TRAINER</div>
			    <div class="swiper-wrapper">
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/trainerimg_1.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				양*승
			    			</div>
			    			<div class="trainer_info">
			    				바디스페이스 대표
			    			</div>
			    		</div>			    		
			    	</div>
					<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/trainerimg_2.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				심*뜸
			    			</div>
			    			<div class="trainer_info">
			    				모델, 필라테스
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/trainerimg_3.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				정*우
			    			</div>
			    			<div class="trainer_info">
			    				2015 미스터 대구 그랑프리
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/trainerimg_4.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				김*호
			    			</div>
			    			<div class="trainer_info">
			    				보디빌더
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/trainerimg_5.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				구*희
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_1.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				김*기
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_2.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				김*린
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_3.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				박*아
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_4.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				신*록
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_5.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				최*림
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_6.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				이*욱
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_7.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				최*상
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/mainimg_8.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				정*서
			    			</div>
			    			<div class="trainer_info">
			    				트레이너
			    			</div>
			    		</div>			    		
			    	</div>
			      
			    </div>
			    <!-- Add Pagination -->
			    <!-- <div class="swiper-pagination"></div> -->
			  </div>

			  <!-- Swiper JS -->
			  <script src="../package/swiper-bundle.min.js"></script>

			  <!-- Initialize Swiper -->

			
		</div>
		<!-- 트레이너영역 끝 -->
		<!-- 목표 몸 -->

		<div class="target_area">
			<div class="swiper-container">
				<div class="contant_name">TARGET</div>
			    <div class="swiper-wrapper">
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_1.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
					<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_2.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				 
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_3.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_4.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_5.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_6.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_7.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/befoafterimg_8.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				회원님들 다이어트 전후
			    			</div>
			    			<div class="trainer_info">
			    				
			    			</div>
			    		</div>			    		
			    	</div>
			      
			    </div>
			</div> 
		</div>	
		<!-- 목표몸 끝 -->

		<jsp:include page="../common/footer.jsp"/>
	</div>


<script type="text/javascript">
	$(function() {
		 $("#myCarousel").carousel("pause");

		 $(".left").click(function(e){
		 	e.preventDefault()

		 	$("#myCarousel").carousel("prev");
	 	

		 })
		 $(".right").click(function(e){
		 	e.preventDefault()

		 	$("#myCarousel").carousel("next");
		 	
		 })
		 $("#myCarousel").on('slid.bs.carousel', function () {
 				
 			


 		 });

	})

    var swiper = new Swiper('.swiper-container', {
      slidesPerView: 4,
      centeredSlides: true,
      spaceBetween: 30,
      grabCursor: true,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
    });


</script>

<script>
		
			
			$.ajax({
				url: "/semi/main/img",
				type: "get",
				
				success: function(data, textStatus, xhr) {
					
				},
				error: function(xhr, status, error) {
					console.log(error);
				}
			});
			
		
	</script> 

	
</body>
</html>