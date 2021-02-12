<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<link rel="stylesheet" type="text/css" href="/web/resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="/web/resources/css/notice_borad.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">


	<title>HelloPT</title>



</head>
<body>
	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<!-- 메인 배너 -->
		<div class="banner_area">
			<img class="banner_detail" src="./img/notice_banner.JPG">
		</div>
		<!-- 메인 배너 끝 -->
		<div class="container">
			<div class="notice_menu_area">
				<div class="row">
					<div class="menu_list col-sm-3">
						<a class="list_detail" href="http://kordzor.cafe24.com/semiproject/notice_borad.html">공지사항</a>
					</div>
					<div class="menu_list col-sm-3">
						<a class="list_detail on" href="http://kordzor.cafe24.com/semiproject/notice_review.html">리뷰</a>
					</div>
					<div class="menu_list col-sm-3">
						<a class="list_detail" href="http://kordzor.cafe24.com/semiproject/notice_report.html">신고 내역</a>
					</div>
					<div class="menu_list col-sm-3">
						<a class="list_detail" href="http://kordzor.cafe24.com/semiproject/notice_question.html">자주 묻는 질문</a>
					</div>
				</div>
			</div>
			<div class="notice_name">
				리뷰
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
					<tr>
						<td>11</td>
						<td><a href="http://kordzor.cafe24.com/semiproject/notice_detail.html">여긴 내용이다</a></td>
						<td>민기찡</td>
						<td>2021.02.11</td>
						<td>1</td>
					</tr>
					<tr>
						<td>10</td>
						<td>여긴 내용이다</td>
						<td>민서찡</td>
						<td>2021.02.11</td>
						<td>1</td>
					</tr>
					<tr>
						<td>9</td>
						<td>여긴 내용이다</td>
						<td>희상찡</td>
						<td>2021.02.11</td>
						<td>1</td>
					</tr>
					<tr>
						<td>8</td>
						<td>여긴 내용이다</td>
						<td>민서찡</td>
						<td>2021.02.11</td>
						<td>1</td>
					</tr>
					<tr>
						<td>7</td>
						<td>여긴 내용이다</td>
						<td>민기찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>6</td>
						<td>여긴 내용이다</td>
						<td>희상찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>5</td>
						<td>여긴 내용이다</td>
						<td>민서찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>4</td>
						<td>여긴 내용이다</td>
						<td>민기찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>3</td>
						<td>여긴 내용이다</td>
						<td>민서찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>2</td>
						<td>여긴 내용이다</td>
						<td>희상찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
					<tr>
						<td>1</td>
						<td>여긴 내용이다</td>
						<td>희상찡</td>
						<td>2021.02.11</td>
						<td>0</td>
					</tr>
				</table>
			</div>

			<div class="page_area">
				<button><</button>
				<span>1</span>
				<span>2</span>
				<span>3</span>
				<span>4</span>
				<span>5</span>
				<button>></button>
			</div>

			<div class="search_area" >
				<select id="searchCondition" name="searchCondition">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="body">내용</option>
				</select> <input type="search" name="searchValue">
				<button type="submit">검색하기</button>		
			</div>
		</div>
	

		<jsp:include page="../common/footer.jsp"/>
	</div>



		
</body>
</html>