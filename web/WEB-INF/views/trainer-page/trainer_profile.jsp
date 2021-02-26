<%@page import="com.greedy.semi.member.model.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/trainer_profile.css">
	<link rel="stylesheet" type="text/css" href="/semi/resources/css/index.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<title>Insert title here</title>

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 헤더 끝 -->
	<div class="headerimg_area">
      <div class="row">
         <div class="classimg_area">
            <img class="classimg_detail" src="/semi/resources/images/testimg.JPG">
         </div>
					
         <div class="classinfo_area">
          
            <div class="class_type">
         	     
					<c:out value="${ trainer.category }"/>
					
            </div>
            <div class="class_name">
     	     	   <c:out value="${ trainer.intro }"/>
            </div>
            <div class="class_score">
               <i class="fas fa-star"></i>
                <c:out value="${ trainer.count }"/>
            </div>
            <div class="trainerinfo">
               <div class="row">
                  <div class="trainerimg">
                     <img class="trainerimg_detail" src="/semi/resources/images/testimg.JPG">
                  </div>
                  <div class="trainer_name">
               		     <c:out value="${ trainer.memberNo.name }"/>
                  </div>
               </div>
            </div>
            <div class="classbtn_area">
               <button class="classbtn_detail on" id="application">
                  1:1 신청하기
               </button>
               <button class="classbtn_detail">
               	   그룹 예약하기
               </button>
            </div>
         </div>
      </div>
   </div>

   <div class="container">
      <div class="classinfomation_area">
         <div class="row">
            <div class="trainer_intro">
               <p class="intro_text">코치 프로필</p>
               <div class="intro_img">
                  <img class="intro_img_detail" src="./img/testimg.JPG">
               </div>
            </div>
            <div class="trainer_intro2">
               <div class="intro_text2">
             	     자격증
               </div>
            </div>
         </div>
      </div>
      <div class="classinfomation_area2">
         <div class="intro_text3">
         	   <c:out value="${ trainer.introduce }"/>
         </div>
      </div>
      
      <div class="review_area">
         <div class="review_text">
      	      리뷰
            <i class="fas fa-star"></i>
            5.0
         </div>
         <div class="review_table">
            <table class="table_detail">
               <tr>
                  <td class="score"><i class="fas fa-star"></i> : 5점</td> 
                  <td class="nickname">닉네임 : 관***</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용</td>
                  <td colspan="2"><textarea class="text_detail"></textarea></td>
               </tr>
            </table>
         </div>
         <div class="review_table">
            <table class="table_detail">
               <tr>
                  <td class="score"><i class="fas fa-star"></i> : 5점</td> 
                  <td class="nickname">닉네임 : 관***</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용</td>
                  <td colspan="2"><textarea class="text_detail"></textarea></td>
               </tr>
            </table>
         </div>
         <div class="review_table">
            <table class="table_detail">
               <tr>
                  <td class="score"><i class="fas fa-star"></i> : 5점</td> 
                  <td class="nickname">닉네임 : 관***</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용</td>
                  <td colspan="2"><textarea class="text_detail"></textarea></td>
               </tr>
            </table>
         </div>
         <div class="review_table">
            <table class="table_detail">
               <tr>
                  <td class="score"><i class="fas fa-star"></i> : 5점</td> 
                  <td class="nickname">닉네임 : 관***</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용</td>
                  <td colspan="2"><textarea class="text_detail"></textarea></td>
               </tr>
            </table>
         </div>
         
      </div>
   </div>
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp"/>
	<!-- 푸터끝 -->
	<script>
		$("#application").click(function() {
			
			let memberNo = "${ sessionScope.loginMember.no }";
			console.log(memberNo);
			
			$.ajax({
				url: "semi/pt/reservation",
				type: "post",
				data: { memberNo: memberNo },
				success: function(data, textStatus, xhr) {
					alert(data);
				},
				error: function(xhr, status, error) {
					console.log(error);
				}
			});
			
		});
	</script> 
	
</body>
</html>