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
	<meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
	
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
            <div class="thumnail-area" id="thumbnailArea">
				<div class="thumb-list">
					<img class="thumb_detail" src="/semi/resources/images/trainertest_1.jpg">
					<%-- <img class="thumb_detail" id="img" src="${ pageContext.servletContext.contextPath }${ trainer.attachmentList[0].thumbnailPath }"> --%>
				</div>
			</div>
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
                     <div class="thumnail-area" id="thumbnailArea">
						<div class="thumb-list">
							<div>
								<img class="thumb_detail" src="/semi/resources/images/trainertest_2.jpg">
								<%-- <img class="thumb_detail" id="img" src="${ pageContext.servletContext.contextPath }${ trainer.attachmentList[0].thumbnailPath }"
								width="120px" style="border-radius: 20px"> --%>
							</div>
						</div>
					 </div>
                  </div>
                  <div class="trainer_name">
               		  <c:out value="${ trainer.memberNo.name }"/>
                  </div>
               </div>
            </div>
            <div class="classbtn_area">
               <button class="classbtn_detail on" id="ptapplication">
                  1:1 신청하기
               </button>
               <button type="button" class="classbtn_detail" id="participateClass">
               	   수업참가
               </button>
               <script>
	               if(document.getElementById("participateClass")) {
	            	   /* 환경에 맞춰 https:// (ip)주소 써줘야 */
	               		const $participateClass = document.getElementById("participateClass");
	               		$participateClass.onclick = function() {
	               			location.href = "https://192.168.66.140:3000";
	               		}
	               }
               </script>
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
                   <div class="thumnail-area" id="thumbnailArea">
						<div class="thumb-list">
							<div>
								<img class="thumb_detail" src="/semi/resources/images/trainertest_3.jpg">
								<%-- <img id="img" src="${ pageContext.servletContext.contextPath }${ trainer.attachmentList[0].thumbnailPath }"
								width="460px" height="500px"> --%>
							</div>
						</div>
					</div>
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
                  <td class="nickname">닉네임 : 김**</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용 : </td>
                  <td colspan="2"><textarea class="text_detail">수업 너무 좋았어요</textarea></td>
               </tr>
            </table>
         </div>
         <div class="review_table">
            <table class="table_detail">
               <tr>
                  <td class="score"><i class="fas fa-star"></i> : 5점</td> 
                  <td class="nickname">닉네임 : 정**</td>
                  <td class="reviewdate">날짜 : 2021-02-21</td>
               </tr>
               <tr>
                  <td class="content">내용 : </td>
                  <td colspan="2"><textarea class="text_detail">수업 또 언제 하시나요 !!!! 너무 재밌어요</textarea></td>
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
                  <td class="content">내용 : </td>
                  <td colspan="2"><textarea class="text_detail">다음에 또 들을께요 !!</textarea></td>
               </tr>
            </table>
         </div>
         
         
      </div>
      <div id="comment_add">
      	<table class="comment_table">
      		<tr>
      			<td class="title">작성자</td>
      			<td class="input"><c:out value="${ sessionScope.loginMember.name }"/></td>
      		</tr>
      		<tr>
      			<td class="title">댓글내용</td>
      			<td class="input"><textarea rows="3" cols="50" id="content" class="text_detail"></textarea></td>
      		</tr>
      		<tr>
      			<td colspan="2" class="btn"></td>
      		</tr>
      	</table>
      	<button class="btn_detail" type="button" id="add_btn">댓글등록</button>
      	<div id="add_message">&nbsp;</div>
      </div>
      
      <div id="comment_list"></div>
      
      <div id="comment_modify">
      	<table class="comment_table">
      		<tr>
      			<td class="title">작성자</td>
      			<td class="input"><input type="text" id="modify_writer"></td>
      		</tr>
      		<tr>
      			<td class="title">댓글내용</td>
      			<td class="input"><textarea rows="3" cols="50" id="modify_content"></textarea></td>
      		</tr>
      		<tr>
      			<td colspan="2" class="btn"><button type="button" id="modify_btn">댓글수정</button>&nbsp;
      				<button type="button" id="modify_cancel_btn">수정취소</button>
      			</td>
      		</tr>
      	</table>
      	<div id="modify_message">&nbsp;</div>
      </div>
      
      <div id="comment_remove">
      	<div id="remove_message">
      		<b>정말로 삭제 하시겠습니까?</b>
      		<button type="button" id="remove_btn">댓글삭제</button>
      		<button type="button" id="remove_cancel_btn">삭제취소</button>
      	</div>
      	<div id="remove_message">&nbsp;</div>
      </div>
      

   </div>
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp"/>
	<!-- 푸터끝 -->
	<script>
		$("#ptapplication").click(function() {
			
			let memberNo = "${ sessionScope.loginMember.no }";
			let trainerNo = "${ requestScope.trainer.trainerNo }";
			let classNo = "${ requestScope.trainer.no}";
			console.log(memberNo);
			console.log(trainerNo);
			console.log(classNo);
			
			$.ajax({
				url: "/semi/pt/reservation",
				type: "post",
				data: { memberNo: memberNo, trainerNo: trainerNo, classNo: classNo },
				success: function(data, textStatus, xhr) {
					alert("1:1PT 예약이 완료되었습니다!");
				},
				error: function(xhr, status, error) {
					console.log(error);
				}
			});
			
		});
		
		
	</script>
	
	<script>
	
	
	let classNo1 = "${ requestScope.trainer.no}";
	
	console.log(classNo1);
			
			$.ajax({
				url: "/semi/member/mypage",
				type: "get",
				data: { classNo1: classNo1 },
				success: function(data, textStatus, xhr) {

				},
				error: function(xhr, status, error) {
					console.log(error);
				}
			});
			
		
	</script> 
	
	<script>
		/* loadComment(); */
		
		function loadComment() {

			
			$.ajax({
				type: "GET",
				url: "/semi/trainer/comment_list.jsp",
				dateType: "xml",
				
				success: function(xmlDoc) {
					let code = $(xmlDoc).find("code").text();
					if(code == "success") {
						let commentArray = JSON.parse($(xmlDoc).find("data").text());
						
						$("#comment_list").children().remove();
						
						$(commentArray).each(function() {
							$("#comment_list").append("<div id='comment_"+this.no+"' class='comment' no='"+this.no+"'><b>["+this.writer+"]</b><br>"+this.content.replace(/\n/g, "<br>")+"<br>("+this.writeDate+")<br><button>수정</button>&nbsp;<button>삭제</button></div>");
						});
					} else {
						let message = $(xmlDoc).find("message").text();
						$("#comment_list").html("<div class='no_comment'>"+message+"</div>");
					}
				},
				error: function(xhr) {
					alert("ERROR CODE : " + xhr.status);
				}
			});
		}
		
		$("#add_btn").click(function() {
			let writer = $("#writer").val();
			if(writer == "") {
				$("#add_message").html("작성자를 입력하세요!");
				$("#writer").focus();
				return;
			}
			let content = $("#content").val();
			if(content == "") {
				$("#add_message").html("내용을 입력하세요!");
				$("#content").focus();
				return;
			}
			
			$("#writer").val("");
			$("#content").val("");
			$("#add_message").html("");
			
			$.ajax({
				type: "POST",
				url: "/semi/trainer/comment_add.jsp",
				data: "writer="+writer+"&content="+content,
				dataType: "xml",
				
				success: function(xmlDoc) {
					let code = $(xmlDoc).find("code").text();
					if(code == "success") {
						loadComment();
					}
				},
				error: function(xhr) {
					alert("ERROR CODE : " + xhr.status);
				}
			});
		});
	</script>
	
	
	
</body>
</html>