<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/Trainer_sales_details.css">
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
	
	
	<!-- 테이블 시작 -->

	<table class="container">
		<thead>
			<tr>
				<th>
					<h1>실시간 그룹 수업일자</h1>
				</th>
				<th>
					<h1>수업 참여인원</h1>
				</th>

				<th>
					<h1>실시간 라이브 그룹 수업 수입</h1>
				</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2021-02-01</td>
				<td>100</td>
				<td>6369</td>
			</tr>
		</tbody>
	</table>
	<br>

	<table class="container">
		<thead>
			<tr>
				<th>
					<h1>영상 수업 제목</h1>
				</th>
				<th>
					<h1>조회수</h1>
				</th>

				<th>
					<h1>영상 수입</h1>
				</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2021-02-01</td>
				<td>100</td>
				<td>6369</td>
			</tr>
		</tbody>
	</table>
	<br>

	<table class="container">
		<thead>
			<tr>
				<th>
					<h1>1:1 수업 일자</h1>
				</th>
				<th>
					<h1>회원 이름</h1>
				</th>

				<th>
					<h1>1:1 수업 수입</h1>
				</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2021-02-01</td>
				<td>100</td>
				<td>6369</td>
			</tr>
		</tbody>
	</table>
	<br>

	<table class="container">
		<thead>
			<tr>
				<th>
					<h1>정산일자</h1>
				</th>
				<th>
					<h1>트레이너 이름</h1>
				</th>

				<th>
					<h1>총 수익 금액</h1>
				</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2021-02-01</td>
				<td>100</td>
				<td>6369</td>
			</tr>
		</tbody>
	</table>
	<br>

	<!-- 테이블 끝 -->

	<!-- 수익 정산 배분 비율 시작 -->
	<!--Accordion wrapper-->
	<div class="container">
		<div class="accordion md-accordion accordion-4" id="accordionEx2" role="tablist" aria-multiselectable="true">

			<!-- Accordion card -->
			<div class="card">

				<!-- Card header -->
				<div class="card-header z-depth-1 teal lighten-4" role="tab" id="heading10">
					<a data-toggle="collapse" data-parent="#accordionEx2" href="#collapse10" aria-expanded="true"
						aria-controls="collapse10">
						<h4 class="mb-0 black-text text-center font-weight-bold text-uppercase">
							실시간 수업 수익 산정 배분 비율
						</h4>
					</a>
				</div>

				<!-- Card body -->
				<div id="collapse10" class="collapse show" role="tabpanel" aria-labelledby="heading10"
					data-parent="#accordionEx2">
					<div class="card-body rgba-teal-strong white-text">
						<p>실시간 수업 참여인원 당 10원<br>
							트레이너 60% 헬로피티 중개 수수료 40%<br>
							예) 회원 300명이 수업에 참여했을 경우 1,800원이 적립됩니다. <br>
							이후 해당 영상은 30일간 자유롭게 볼수있도록 노출되고 해당영상 조회수당 5원씩 적립됩니다. <br>
							실시간 수업 정산 금액은 매월 30일에 합산하여 지급됩니다. (세금제외) <br>
							수익 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
						</p>

					</div>
				</div>
			</div>

			<div class="card">

				<!-- Card header -->
				<div class="card-header z-depth-1 teal lighten-3" role="tab" id="heading11">
					<a class="collapsed" data-toggle="collapse" data-parent="#accordionEx2" href="#collapse11"
						aria-expanded="false" aria-controls="collapse11">
						<h4 class="mb-0 black-text text-center font-weight-bold text-uppercase">
							1:1 수업 수익 산정 배분 비율
						</h4>
					</a>
				</div>

				<!-- Card body -->
				<div id="collapse11" class="collapse" role="tabpanel" aria-labelledby="heading11"
					data-parent="#accordionEx2">
					<div class="card-body rgba-teal-strong white-text">
						<p>1회 수업 당 15,000원 <br>
							트레이너 60% 헬로피티 중개 수수료 40% <br>
							예) 회원 1명을 23일 1:1 수업 진행하셨으면 9,000원이 적립됩니다. <br>
							1:1수업 정산 금액은 매월 30일에 합산하여 지급됩니다. (세금제외) <br>
							수익 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
						</p>


					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 수인 정산 배분 비율 끝 -->
	
	
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
	<!-- 푸터끝 -->

</body>
</html>