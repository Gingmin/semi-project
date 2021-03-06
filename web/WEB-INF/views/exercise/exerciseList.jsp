<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/exerciseList.css">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
	<!-- JQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<!-- 헤더끝 -->
		<!-- 메인베너 시작 -->
		<div class="mainbanner">
			<img class="banner_detail" alt="" src="/semi/resources/images/212312.png">	
		</div>
	<div class="container">
		<!-- 메인베너 끝 -->
		<!-- 이번 주 스케쥴 시작 -->
		<div class="schedule">이번 주 스케쥴</div>
		<!-- 이번 주 스케쥴  끝-->
		<!-- 요일 시작 -->
		<button type="button" class="btn btn-rounded">월요일</button>
		<button type="button" class="btn btn-rounded">화요일</button>
		<button type="button" class="btn btn-rounded">수요일</button>
		<button type="button" class="btn btn-rounded">목요일</button>
		<button type="button" class="btn btn-rounded">금요일</button>
		<button type="button" class="btn btn-rounded">토요일</button>
		<button type="button" class="btn btn-rounded">일요일</button>
		<!-- 요일 끝 -->
		<!-- 트레이너 시작 -->
		<!-- Card 월요일 -->
		<div class="day">월요일 MON</div>
		<div class="row">
			<div class="card col-4">				
				<!-- Card image -->					
				<div class="thumnail-area" id="thumbnailArea">
					<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="0" end="0" >
					<div class="thumb-list">
						<div>
							<img src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"width="350" height="250">
						</div>
						No. 
						<label><c:out value="${ thumbnail.no }"/></label><br>					
						<c:out value="${ thumbnail.category }"/><br>
					</div>
					</c:forEach>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>					
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			
			<!-- 월요일 끝 -->
			<!-- 화요일 시작 -->

			<div class="card col-4">			
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="1" end="1" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample1.jpg" width="350" height="250">
							</div>
							No.
							<label><c:out value="4"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->		
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="2" end="2" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample5.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="5"/></label><br>
							<c:out value="요가"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>
		<!-- 카드 2번 -->
		<div class="day">화요일 TUE</div>
		<!-- Card 화요일 -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="3" end="3" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample6.jpg" width="350" height="250" alt="운동사진">
							</div>
							No. 
							<label><c:out value="6"/></label><br>
							<c:out value="요가"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="4" end="4" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample2.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="7"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="5" end="5" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample7.jpg"width="350" height="250">
							</div>
							No.
							<label><c:out value="8"/></label><br>					
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>
		<div class="day">수요일 WEN</div>
		<!-- Card 수요일 -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="6" end="6" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample4.jpg"width="350" height="250">
							</div>
							No.
							<label><c:out value="9"/></label><br>						
							<c:out value="요가"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="7" end="7" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample8.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="10"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="8" end="8" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample9.jpg"width="350" height="250">
							</div>
							No.
							<label><c:out value="11"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>

		<div class="day">목요일 THU</div>
		<!-- Card 목요일 -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="9" end="9" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample10.jpg"width="350" height="250">
							</div>
							<label>No.<c:out value="12"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="10" end="10" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample11.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="13"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="11" end="11" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample12.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="14"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>
		<div class="day">금요일 FRI</div>
		<!-- Card 금요일 -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
				<%-- 	<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="12" end="12" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample13.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="15"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="13" end="13" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample14.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="16"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="14" end="14" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample15.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="17"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>
		<div class="day">토요일 SAT</div>
		<!-- Card 토요일 -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="15" end="15" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample16.jpg"width="350" height="250">
							</div>
							No.
							<label><c:out value="18"/></label><br>
							<c:out value="요가"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
				<%-- 	<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="16" end="16" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample17.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="19"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="17" end="17" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample18.png"width="350" height="250">
							</div>
							No. 
							<label><c:out value="20"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
		</div>

		<div class="day">일요일 SUN</div>
		<!-- Card  -->
		<div class="row">
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="18" end="18" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample19.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="21"/></label><br>
							<c:out value="헬스"/><br>
						</div>
				<%-- 	</c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<div class="card col-4">
				<!-- Card image -->
				<div class="thumnail-area" id="thumbnailArea">
					<%-- <c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="19" end="19" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample3.jpg"
									width="350" height="250">
							</div>
							No. 
							<label><c:out value="22"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 

			<div class="card col-4">
				<!-- Card image -->
					<div class="thumnail-area" id="thumbnailArea">
				<%-- 	<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }" begin="20" end="20" > --%>
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }/resources/images/sample20.jpg"width="350" height="250">
							</div>
							No. 
							<label><c:out value="23"/></label><br>
							<c:out value="헬스"/><br>
						</div>
					<%-- </c:forEach> --%>
				</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					<p class="card-text"><c:out value="${ thumbnail.name }"/></p>
				</div>
				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i	class="fab fa-facebook-f pr-1"></i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1"></i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</div> 
			<!-- 밑에 div 로우 -->
			<script>
					$("#thumbnailArea > div").click(function() {
						const no = $(this).find("label").text();
						console.log(no);
						location.href = "${ pageContext.servletContext.contextPath }/trainer/detail?no=" + no;
					});
			</script>
		</div>

		<!-- 트레이너 끝 -->
				
	</div>
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
</body>
</html>