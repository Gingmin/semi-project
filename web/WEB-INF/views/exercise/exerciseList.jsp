<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/exerciseList.css">
<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">
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
	<div class="container">
		<!-- 메인베너 시작 -->
		<div class="mainbanner">
			<div class="mainbannerfont">꾸준함이 진리다 가입하고 바로 경험하라!<br><br>
				내 자세를 봐주는 라이브 클래스</div>
		</div>
		<!-- 메인베너 끝 -->
		<!-- 이번 주 스케쥴 시작 -->
		<div class="schedule">이번 주 스케쥴</div>
		<!-- 이번 주 스케쥴  끝-->
		<!-- 요일 시작 -->
		<button type="button" class="btn btn-primary btn-rounded">월요일</button>
		<button type="button" class="btn btn-primary btn-rounded">화요일</button>
		<button type="button" class="btn btn-primary btn-rounded">수요일</button>
		<button type="button" class="btn btn-primary btn-rounded">목요일</button>
		<button type="button" class="btn btn-primary btn-rounded">금요일</button>
		<button type="button" class="btn btn-primary btn-rounded">토요일</button>
		<button type="button" class="btn btn-primary btn-rounded">일요일</button>
		<!-- 요일 끝 -->
		<!-- 트레이너 시작 -->
		<!-- Card 월요일 -->
		<div class="day">월요일 MON</div>
		<div class="row">
			<div class="card col-4">
				
				<!-- Card image -->
					
					
					<div class="thumnail-area" id="thumbnailArea">
					<c:forEach var="thumbnail" items="${ requestScope.thumbnailList }">
						<div class="thumb-list">
							<div>
								<img src="${ pageContext.servletContext.contextPath }${ thumbnail.attachmentList[0].thumbnailPath }"
									width="350" height="250">
							</div>
					수업번호: <label><c:out value="${ thumbnail.trainerNo }"/></label>번<br>
					<c:out value="${ thumbnail.category }"/><br>
						</div>
					</div>
				<div class="card-body" id="thumbnailArea">
					<hr>
					
					<c:out value="${ thumbnail.name }"/>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i><c:out value="${ thumbnail.createdDate }"/></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i></a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i><c:out value="${ thumbnail.count }"/></a></li>
					</ul>
				</div>
			</c:forEach>
			</div> 
			
			<!-- 월요일 끝 -->
			<!-- 화요일 시작 -->

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>
			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
					</ul>
				</div>

			</div>

			<div class="card col-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top" src="https://mdbootstrap.com/img/Photos/Others/food.jpg"
						alt="Card image cap">
					<a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">완뀨 헬스</h4>
					<hr>
					<!-- Text -->
					<p class="card-text">하루의 마무리. 골반과 어깨를 개운하게!꿀잠예약</p>

				</div>

				<!-- Card footer -->
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
						<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>05/10/2015</li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="far fa-comments pr-1"></i>12</a></li>
						<li class="list-inline-item pr-2"><a href="#" class="white-text"><i
									class="fab fa-facebook-f pr-1">
								</i>21</a></li>
						<li class="list-inline-item"><a href="#" class="white-text"><i class="fab fa-twitter pr-1">
								</i>5</a></li>
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