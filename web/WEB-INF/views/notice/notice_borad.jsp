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
						<th class="th_detail1">제목</th>
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
						<i id="startBtn" class="fas fa-backward"></i>
						<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
							<i class="fas fa-caret-left"></i>						
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
							<i id="prevBtn" class="fas fa-caret-left"></i>
						</c:if>
						
						<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end = "${ requestScope.pageInfo.endPage }" step="1">
							<c:if test="${ requestScope.pageInfo.pageNo eq p }">
								<button class="btn_detail"><c:out value="${ p }"/></button>
							</c:if>
							
							<c:if test="${ requestScope.pageInfo.pageNo ne p }">
								<button class="btn_detail" onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
							</c:if>
						</c:forEach>
						
						<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
							<i class="fas fa-caret-right"></i>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
							<i id="nextBtn" class="fas fa-caret-right"></i>
						</c:if>
						<i id="endBtn" class="fas fa-forward"></i>
					</c:when>
					
					
					<%--검색 했을시 페이징처리 --%> 
					<c:otherwise>
						<i id="searchStartBtn" class="fas fa-backward"></i>
						<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
							<i class="fas fa-caret-left"></i>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
							<i id="searchPrevBtn" class="fas fa-caret-left"></i>
						</c:if>
						
						<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end = "${ requestScope.pageInfo.endPage }" step="1">
							<c:if test="${ requestScope.pageInfo.pageNo eq p }">
								<button class="btn_detail" disabled><c:out value="${ p }"/></button>
							</c:if>
						
							<c:if test="${ requestScope.pageInfo.pageNo ne p }">
								<button class="btn_detail" onclick="searchPageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
							</c:if>
						
						</c:forEach>
						
						<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
							<i class="fas fa-caret-right"></i>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
							<i id="searchNextBtn" class="fas fa-caret-right"></i>
						</c:if>
						<i id="searchEndBtn" class="fas fa-forward"></i>
					</c:otherwise>
				</c:choose>
			</div>


			<%-- 검색폼 --%>
			<form id="serchForm" action="${ pageContext.servletContext.contextPath }/notice/search">
				<div class="search_area" >
					<select id="searchCondition" name="searchCondition" class="select_detail">
						<option value="writer" <c:if test="${ requestScope.searchCondition eq 'writer' }">seleted</c:if>>작성자</option>
						<option value="title" <c:if test="${ requestScope.searchCondition eq 'title' }">seleted</c:if>>제목</option>
						<option value="body" <c:if test="${ requestScope.searchCondition eq 'content' }">seleted</c:if>>내용</option>
					</select>
					<input class="searchinput_detail" type="search" name="searchValue" value="${ requestScope.searchValue }">
					<button class="searchBtn_detail" type="submit">검색하기</button>
					<c:if test="${ sessionScope.loginMember.role eq 'ADMIN'}">
						<input class="searchBtn_detail" type="button" id="writeNotice" value="작성하기">		
					</c:if>
				</div>			
			</form>
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
		
		const link = "${ pageContext.servletContext.contextPath }/notice/notice";
		const searchLink = "${ pageContext.servletContext.contextPath}/notice/search";
		
		if(document.getElementById("startBtn")){
			const $startBtn = document.getElementById("startBtn");
			$startBtn.onclick = function() {
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("prevBtn")){
			const $prevBtn = document.getElementById("prevBtn");
			$prevBtn.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1}";
			}
		}
		
		if(document.getElementById("nextBtn")){
			const $nextBtn = document.getElementById("nextBtn");
			$nextBtn.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1}";
			}
		}
		
		if(document.getElementById("endBtn")){
			const $endBtn = document.getElementById("endBtn");
			$endBtn.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage}";
			}
		}
		
		if(document.getElementById("searchStartBtn")){
			const $searchStartBtn = document.getElementById("searchStartBtn");
			$searchStartBtn.onclick = function() {
				location.href = searchlink + "?currentPage=1&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
			}
		}
		if(document.getElementById("searchPrevBtn")){
			const $searchPrevBtn = document.getElementById("searchPrevBtn");
			$searchPrevBtn.onclick = function() {
				location.href = searchlink + "?currentPage=${ requestScope.pageInfo.pageNo - 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchNextBtn")){
			const $searchNextBtn = document.getElementById("searchNextBtn");
			$searchNextBtn.onclick = function() {
				location.href = searchlink + "?currentPage=${ requestScope.pageInfo.pageNo + 1 }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue}";
			}
		}
		
		if(document.getElementById("searchEndBtn")){
			const $searchEndBtn = document.getElementById("searchEndBtn");
			$searchEndBtn.onclick = function() {
				location.href = searchlink + "?currentPage=${ requestScope.pageInfo.maxPage }&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue}";
			}
		}
		
		
		 function pageButtonAction(text){
	    	  location.href = link + "?currentPage=" + text;
	      }
	    
	      
	      function searchPageButtonAction(text) {
	    	  location.href = searchLink + "?currentPage=" + text + "&searchCondition=${ requestScope.searchCondition }&searchValue=${ requestScope.searchValue }";
	      }
	</script>

		
</body>
</html>