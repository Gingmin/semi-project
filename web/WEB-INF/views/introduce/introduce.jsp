<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소개</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="/semi/resources/css/introduce.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 	
 	
 	 <!-- 스와이퍼 -->
   <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css" />
   <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

   <script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
   <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 헤더 끝 -->
	<div class="header_banner_area">
      <img class="introimg_detail" src="/semi/resources/images/introduceimg.png">
   </div>

   <div class="container">
      <div class="contentarea">
         <div class="exercise_type_area">
            <div class="typetext_area">
               <div class="typetext1">
                  모든 종류의 운동
               </div>
               <div class="typetext2">
                  유산소 운동과 근력 운동에서 요가에 이르기까지 가족 모두를 위한 완벽한 운동을 제공합니다. 매주 새로운 라이브 수업을 즐기거나 광범위한 주문형 운동 라이버르리를 통해 언제든지 수업을 들을 수 있습니다. 수천개의 수업은 운동이 항상 신선함을 의미합니다.
               </div>
            </div>

            <div class="swiper-container">               
               <div class="swiper-wrapper">
                  <div class="swiper-slide">
                     <img class="img_detail" src="/semi/resources/images/exkind1.PNG">                                        
                  </div>
                  <div class="swiper-slide">
                     <img class="img_detail" src="/semi/resources/images/exkind2.PNG">                                         
                  </div>
                  <div class="swiper-slide">
                     <img class="img_detail" src="/semi/resources/images/exkind3.PNG">                                      
                  </div>
                  <div class="swiper-slide">
                     <img class="img_detail" src="/semi/resources/images/exkind4.PNG">                                        
                  </div>
                  

                  
               </div>
             <!-- Add Pagination -->
             
            </div>

            <div class="questbtn_area">
               <input type="button" class="questbtn_dateil" value="운동 탐색" name="" id="questBtn">     
            </div>
         </div>


         <div class="helloPT_intro">
            <div class="intro_textarea">
               <div class="intro_text1">
                  HELLOPT 디지털
               </div>
               <div class="intro_text2">
                  HELLOPT 웹을 통해 HELLOPT의 최강 운동을 무제한으로 액세스하세요, 휴대폰, 태블릿 및 스마트 TV 장치에서 전체 HELLOPT 운동 라이브러리를 액세스 하고 연중 무휴로 수천개의 수업을 즐기십시오. HELLPT 소유자는 구매 즉시 액세스 할수 있습니다.
               </div>
            </div>
            <div class="intro_imgarea">
               <img class="introimg_detail" src="/semi/resources/images/introduceimg2.png">
            </div>
         </div>


         <div class="CEO_into_area">
            <div class="row">
               <div class="CEO_text_area">
                  <div class="CEO_text">
                     HELLOPT 이야기
                  </div>
                  <div class="CEO_text1">
                    임완규,김민기,정민서,최희상 HELLOPT의 설립자이자 공동CEO입니다.
          THE JOEUN ACADEMY에서 PROGRAMMER로 인연되어 사업파트너로서 성장하고 있고,
                    운동산업의 혁신적인 HELLOPT 플랫폼을 만들었으며, 집에서 뷰티크 스튜디오 경험을 제공함으로써 사람들이 편안하고 좀 더 개별적인 운동하는 방식을 할수있도록 돕고 있습니다.
                  </div>
               </div>
               <div class="CEO_img_area">
                  <div id="myCarousel" class="carousel slide" data-ride="carousel">
                     <!-- Wrapper for slides -->
                     <div class="carousel-inner" role="listbox">

                        <div class="item active">
                           <img class="CEOimg_detail" src="/semi/resources/images/CEOimg1.jpg" alt="임완규" >
                           <div class="carousel-caption">
                              <h3>임완규</h3>                              
                           </div>
                        </div>

                        <div class="item">
                           <img class="CEOimg_detail" src="/semi/resources/images/CEOimg2.jpg" alt="김민기" >
                           <div class="carousel-caption">
                              <h3>김민기</h3>                             
                           </div>
                        </div>

                        <div class="item">
                           <img class="CEOimg_detail"src="/semi/resources/images/CEOimg4.jpg" alt="정민서" >
                           <div class="carousel-caption">
                              <h3>정민서</h3>                             
                           </div>
                        </div>

                        <div class="item">
                           <img class="CEOimg_detail" src="/semi/resources/images/CEOimg3.jpg" alt="최희상" >
                           <div class="carousel-caption">
                              <h3>최희상</h3>                              
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>         
      </div>   
   </div>

   <div class="ptstartbtn_area">
      <div class="btntext_area">
         <div class="btntext">
          	  지금 HELLOPT를 경험하세요
         </div>                            
      </div>
      <div class="startbtn_area">
            <input class="startbtn_detail" type="button" name="" value="지금 쇼핑" id="shopingBtn">   
      </div> 
   </div>

   <!-- Swiper JS -->
   <script src="../package/swiper-bundle.min.js"></script>
	
	<jsp:include page="../common/footer.jsp"/>
	
	<script type="text/javascript">
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
</body>
</html>