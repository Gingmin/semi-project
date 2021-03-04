<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
				<form action="${ pageContext.servletContext.contextPath }/trainer/profileEdit" method="post" encType="multipart/form-data">
					<div class="profile_img_area">
						<div class="thumb-list">
							<img class="trainerImg" src="/semi/resources/images/메인.jpg">
						</div>
						<div class="profile_btn_area">
						<label for="profileEdit" class="edit_btn">프로필 편집</label>
							<input type="file" class="edit_btn" id="profileEdit" name="profileEdit" onchange="loadImg(this, 1)">
							  
							  <label for="edit" class="edit_btn">수정하기</label>
							  <button type="submit" id="edit"></button>
						</div>						
					</div>
					</form>
					<div class="profile_info_area">

						<!-- <div class="info_item">
							밍키
						</div>
						<div class="info_item">
							abcdefg@abcd.com
						</div> -->

						
						<!-- <div class="class_btn">
							<label class="switch">
								<input type="checkbox">
								<span class="slider round"></span>
							</label>
							<span class="start_btn">나의클래스</span>
							<p>OFF</p><p style="display:none;">ON</p>
						</div> -->

						<div class="profile_etc_btn">
							<div class="row">
								<div class="etc_btn">
									<a class="etc_detail" href="#" id="sales-details">매출내역</a>
								</div>
								<div class="etc_btn">
									<input type="button" class="etc_detail" value="내정보" id="memberInfo">
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
															<div class="thumnail-area" id="thumbnailArea">

					<c:forEach var="thumbnail" items="${ requestScope.reservationList }" begin="0" end="0">
					<%-- <c:if test="${ sessionScope.loginMember.no eq thumbnail.memberNo }"> --%>

						<div class="thumb-list">
							<div>
								<img id="img" src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"
									width="200" height="150" style="margin: 5px">
							</div>
							<p>
							<div id="label">수업번호: <label><c:out value="${ thumbnail.classNo }"/></label>번</div>
							</p>
						</div>
					 <%-- </c:if> --%>
					</c:forEach>
				</div>
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

				<div class="line"></div>

				<div class="class_management_area">
					<div class="class_text">
						나의 수업 관리
					</div>
					<div class="class_btn_list">
						<div class="row">
							<div class="cm_btn_list">
								<button class="cm_btn" id="allButton" style="width: 160px">
									모든수업
								</button>
							</div>
							<div class="cm_btn_list">
								<%-- <c:if test="${ thumbnailList.kind eq '클'}">
								<c:out value="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"></c:out>
								</c:if> --%>
								<button class="cm_btn" id="ptButton" style="width: 160px">
									PT수업
								</button>
							</div>
							<div class="cm_btn_list">
								<button class="cm_btn" id="groupButton" style="width: 160px">
									Group수업
								</button>
							</div>
						</div>
					</div>
				<div class="thumnail-area" id="thumbnailArea">
					<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="0" end="1">
					<c:if test="${ sessionScope.loginMember.no eq thumbnail.trainerNo }">
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
					</c:if>
					</c:forEach>
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="0" end="1">
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
					</c:forEach> --%>
				</div>
				</div>
				<br>
				<br>
				<br>
				<div class="insert_btn">
					<a class="insert_detail" href="#" id="insert_class">클래스 추가하기</a>
				</div>
				<script>
					$("#thumbnailArea > div").click(function() {
						const no = $(this).find("label").text();
						console.log(no);
						location.href = "${ pageContext.servletContext.contextPath }/class/detail?no=" + no;
					});
				</script>



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
<script>
	$('#ptButton').click(function() {
		$('#img').hide();
		$('#label').hide();
	});
</script>
<script>
	$('#groupButton').click(function() {
		$('#img').show();
		$('#label').show();
});
</script>
</body>
</html>
































