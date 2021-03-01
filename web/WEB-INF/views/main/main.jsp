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
		<div class="thumnail-area" id="thumbnailArea">
					<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="0" end="1">
					
						<div class="thumb-list">
							<div>
								<img id="img" src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"
									width="200" height="150" style="margin: 5px">
							</div>
							<p>
							<div id="label">수업번호: <label><c:out value="${ thumbnail.no }"/></label>번</div>
							<%-- className: <c:out value="${ thumbnail.name }"/><br>
							조회수 : <c:out value="${ thumbnail.count }"/><br>
							TrainerNo. <c:out value="${ thumbnail.trainerNo }"/> --%>
							</p>
						</div>
					
					</c:forEach>
					<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="0" end="1">
						<div class="thumb-list">
							<div>
								<img id="img" src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"
									width="200" height="150">
							</div>
							<p>
							<div id="label">수업번호: <label><c:out value="${ thumbnail.no }"/></label>번</div>
							className: <c:out value="${ thumbnail.name }"/><br>
							조회수 : <c:out value="${ thumbnail.count }"/><br>
							TrainerNo. <c:out value="${ thumbnail.trainerNo }"/>
							</p>
						</div>
					</c:forEach>
				</div>
		
		<div class="container">
		
				
			<div class="howuse_area">
				<div class="row">
					<div class="howuse_img_area">				
					    <div id="myCarousel" class="carousel slide">
					    	<div class="row">	
					   
					    	
					    			
				    			<div class="carousel-inner" role="listbox">
									<div class="item active ">
										<img class="img_detail" src="/semi/resources/images/testimg.JPG">
										
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/testimg.JPG">
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/testimg.JPG">
									</div>

									<div class="item">
										<img class="img_detail" src="/semi/resources/images/testimg.JPG">
									</div>
								</div>	 	
				    		 		
					    	</div>		    	


						    <!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel" role="button">
								<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>							
							</a>
							<a class="right carousel-control" href="#myCarousel" role="button">
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>							
							</a>
					    </div>
						
					</div>
					<div class="howuse_text_area">
						<div class="howuse_text">
							HelloPT 이렇게 이용하세요!
						</div>
						<div class="howuse_text1 ">
							<div class="text1_detail">
								이렇게 하면 넘어가낭	
								이렇게 하면 넘어가낭이렇게 하면 넘어가낭이렇게 하면 넘어가낭
							</div>						 	
						</div>
						<div class="howuse_text2  ">
							<div class="text1_detail">
								음 무슨방법이있을까음 무슨방법이있을까음 무슨방법이있을까음 무슨방법이있을까음 무슨방법이있을까
							</div>						 	
						</div>    
						<div class="howuse_text3">
							<div class="text1_detail">
								요러먼되나?요러먼되나?요러먼되나?요러먼되나?요러먼되나?
							</div>						 	
						</div>
						<div class="howuse_text4">
							<div class="text1_detail">
								생각이 안나내 ..	생각이 안나내 ..	생각이 안나내 ..	생각이 안나내 ..	생각이 안나내 ..	생각이 안나내 ..	
							</div>						 	
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
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				김민기
			    			</div>
			    			<div class="trainer_info">
			    				롤쟁이 
			    			</div>
			    		</div>			    		
			    	</div>
					<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				정민서
			    			</div>
			    			<div class="trainer_info">
			    				운동인 
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				이경철
			    			</div>
			    			<div class="trainer_info">
			    				어디감?...계신가용
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				최희상
			    			</div>
			    			<div class="trainer_info">
			    				사업인
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				임완규
			    			</div>
			    			<div class="trainer_info">
			    				귀찮다.. 
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
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				슬림핏
			    			</div>
			    			<div class="trainer_info">
			    				롤쟁이 
			    			</div>
			    		</div>			    		
			    	</div>
					<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				좋은체격
			    			</div>
			    			<div class="trainer_info">
			    				운동인 
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				근육질
			    			</div>
			    			<div class="trainer_info">
			    				어디감?...계신가용
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				볼륨감
			    			</div>
			    			<div class="trainer_info">
			    				사업인
			    			</div>
			    		</div>			    		
			    	</div>
			    	<div class="swiper-slide">
			    		<img class="img_detail" src="/semi/resources/images/testimg.JPG">	
			    		<div class="trainer_text">
			    			<div class="trainer_name">
			    				S라인
			    			</div>
			    			<div class="trainer_info">
			    				귀찮다.. <button id="chat" type="button" onclick="chat();">chat</button>
			    				<button id="video" type="button" onclick="video();">video</button>
			    				<script>
			    					function chat() {
			    						location.href = "/semi/chat";
			    					}
			    					function video() {
			    						location.href = "http://127.0.0.1:1337/";
			    					}
			    				</script>
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