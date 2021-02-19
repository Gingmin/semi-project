<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
		
	<link rel="stylesheet" href="/semi/resources/css/index.css">
	<link rel="stylesheet" href="/semi/resources/css/notice_board.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">
	
	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">


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
						<input type="button" class="list_detail on" value="공지사항" id="noticeNotice">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail" value="리뷰" id="noticeReview">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail" value="신고 내역" id="noticeReport">
					</div>
					<div class="menu_list col-sm-3">
						<input type="button" class="list_detail" value="자주 묻는 질문" id="noticeQuestion">
					</div>
				</div>
			</div>
			<div class="notice_name">
				공지사항
			</div>
			<div class="line"></div>

			<div class="notice_content_area">
				<table class="table_detail">
					<tr class="tr_detail">
						<th class="th_detail">번호</th>
						<th class="th_detail1">내용</th>
						<th class="th_detail2">작성자</th>
						<th class="th_detail2">날짜</th>
						<th class="th_detail">조회수</th>
					</tr>
					<c:forEach var="notice" items="${ requestScope.noticeList }">
						<tr>
							<td><c:out value="${ notice.no }"/></td>
							<td><c:out value="${ notice.title }"/></td>
							<td><c:out value="${ notice.writer.name }"/></td>
							<td><c:out value="${ notice.createdDate }"/></td>
							<td><c:out value="${ notice.count }"/></td>
						</tr>
					</c:forEach>
										
				</table>
			</div>

			<div class="page_area">
				<c:choose>
					<c:when test="${ empty requestScope.searchValue }">
					
						<i class="fas fa-backward"></i>
						<i class="fas fa-caret-left"></i>
						
						<span>1</span>
						
						<i class="fas fa-caret-right"></i>
						<i class="fas fa-forward"></i>
					</c:when>
				</c:choose>
			</div>

			<div class="search_area" >
				<select id="searchCondition" name="searchCondition">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="body">내용</option>
				</select> <input type="search" name="searchValue">
				<button type="submit">검색하기</button>
				<c:if test="${ sessionScope.loginMember.role eq 'ADMIN'}">
					<button id="writeNotice">작성하기</button>		
				</c:if>
			</div>
		</div>
	

		<jsp:include page="../common/footer.jsp"/>
	</div>

	<script type="text/javascript">
		if(document.getElementsByTagName("td")){
			const $no_list = document.getElementsByTagName("td");
			
			for(let i = 0; i < $no_list.length; i++){
				
				$no_list[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no=" + no;
				}
				
			}
		}
	</script>

		
</body>
</html>