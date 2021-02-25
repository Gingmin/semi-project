<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<link rel="stylesheet" href="/semi/resources/css/membership_buy.css">
	<link rel="stylesheet" href="/semi/resources/css/index.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">


	

	<title>멤버쉽 구매</title>



</head>
<body>
	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<div class="container">
			<div class="membership_area">
				<div class="member_textarea">
					<div class="membet_text1">
						HELLO Public, Personal Training
					</div>
					<div class="membet_text2">
						Membership
					</div>					
				</div>
				<div class="membership_type_area">
					<div class="row">
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									1개월 이용권
								</div>
								<div class="ticket_text2">
									그룹 클래스 30일동안 무제한 참여 가능
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 모든 카테고리 제한없이 이용가능
								</div>
								<div class="ticket_text3">
									★ 무제한으로 이용 가능
								</div>
							</div>
							<form action="${ pageContext.servletContext.contextPath }/member/buy" method="get">
								<input value="MEM_1" name="productValue" style="display:none;">
								<div class="ticket_btn_area">
									<input type="submit" class="ticket_btn_detail" value="30,000원" id="ticketBtn" >
								</div>
							</form>
						</div>
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									1:1 PT 1회 이용권
								</div>
								<div class="ticket_text2">
									1:1 P.T 1회 참여가능 
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 50분 간의 몸의 대화
								</div>
								
							</div>
							<form action="${ pageContext.servletContext.contextPath }/member/buy" method="get">
							<input value="PT_1" name="productValue" style="display:none;">
							<div class="ticket_btn_area type">
								<input type="submit" class="ticket_btn_detail" value="15,000원" id="ticketBtn">
							</div>
							</form>
						</div>
					</div>
				</div>
				<div class="membership_type_area">
					<div class="row">
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									3개월 이용권
								</div>
								<div class="ticket_text2">
									그룹 클래스 30일동안 무제한 참여 가능
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 모든 카테고리 제한없이 이용가능
								</div>
								<div class="ticket_text3">
									★ 무제한으로 이용 가능
								</div>
							</div>
							<form action = "${ pageContext.servletContext.contextPath }/member/buy">
							<input value="MEM_3" name="productValue" style="display:none;">
							<div class="ticket_btn_area">
								<input type="submit" class="ticket_btn_detail" value="90,000원" id="ticketBtn">
							</div>
							</form>
						</div>
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									1:1 PT 5회 이용권
								</div>
								<div class="ticket_text2">
									1:1 P.T 1회 참여가능 
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 50분 간의 몸의 대화
								</div>
								
							</div>
							<form action = "${ pageContext.servletContext.contextPath }/member/buy">
							<input value="PT_5" name="productValue" style="display:none;">
							<div class="ticket_btn_area type">
								<input type="submit" class="ticket_btn_detail" value="75,000원" id="ticketBtn">
							</div>
							</form>
						</div>
					</div>
				</div>
				<div class="membership_type_area">
					<div class="row">
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									6개월 이용권
								</div>
								<div class="ticket_text2">
									그룹 클래스 30일동안 무제한 참여 가능
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 모든 카테고리 제한없이 이용가능
								</div>
								<div class="ticket_text3">
									★ 무제한으로 이용 가능
								</div>
							</div>
							<form action="${ pageContext.servletContext.contextPath }/member/buy">
							<input value="MEM_6" name="productValue" style="display:none;">
							<div class="ticket_btn_area">
								<input type="submit" class="ticket_btn_detail" value="180,000원" id="ticketBtn">
							</div>
							</form>
						</div>
						<div class="ticket_area">
							<div class=ticket_textarea>
								<div class="ticket_text1">
									1:1 PT 10회 이용권
								</div>
								<div class="ticket_text2">
									1:1 P.T 1회 참여가능 
								</div>
								<div class="ticket_text3">
									★ 클래스 시작알림
								</div>
								<div class="ticket_text3">
									★ 운동 시간 자동 기록
								</div>
								<div class="ticket_text3">
									★ 50분 간의 몸의 대화
								</div>
								
							</div>
							<form action="${ pageContext.servletContext.contextPath }/member/buy">
							<input value="PT_10" name="productValue" style="display:none;">
							<div class="ticket_btn_area type">
								<input type="submit" class="ticket_btn_detail" value="150,000원" id="ticketBtn">
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<!-- 푸터 -->
		<jsp:include page="../common/footer.jsp"/>
		<!-- 푸터끝 -->
	</div>
	
<script>
	
		/* $(".ticket_btn_detail").click(function()  */
			if("${ requestScope.productPrice }")	{
			var IMP = window.IMP; // 생략가능0
			IMP.init('imp69531077');
			 let movePath = "";
			// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
			// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
			
			IMP.request_pay({
				pg : 'inicis', // version 1.1.0부터 지원.
				/*
				'kakao':카카오페이,
				html5_inicis':이니시스(웹표준결제)
				'nice':나이스페이
				'jtnet':제이티넷
				'uplus':LG유플러스
				'danal':다날
				'payco':페이코
				'syrup':시럽페이
				'paypal':페이팔
				 */
				pay_method : 'card',
				/*
				'samsung':삼성페이,
				'card':신용카드,
				'trans':실시간계좌이체,
				'vbank':가상계좌,
				'phone':휴대폰소액결제
				 */
				merchant_uid : 'merchant_' + new Date().getTime(),
				/*
				merchant_uid에 경우
				https://docs.iamport.kr/implementation/payment
				위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
				참고하세요.
				나중에 포스팅 해볼게요.
				 */
				name : '주문명:HELLOPT결제',
				//결제창에서 보여질 이름
				amount : "${ requestScope.productPrice }",
				//가격
				buyer_email : 'iamport@siot.do',
				buyer_name : '구매자이름',
				buyer_tel : '010-1234-5678',
				buyer_addr : '서울특별시 강남구 삼성동',
				buyer_postcode : '123-456',
				m_redirect_url : 'https://www.yourdomain.com/payments/complete'
			
				
			/*
			모바일 결제시,
			결제가 끝나고 랜딩되는 URL을 지정
			(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
			 */
			})
			
			,function(rsp) {
	            if (rsp.success) {
	                jQuery.ajax({
	                       url: "http://www.myservice.com/payments/complete", // 가맹점 서버
	                       method: "POST",
	                       headers: { "Content-Type": "application/json" },
	                       data: {
	                           imp_uid: rsp.imp_uid,
	                           merchant_uid: rsp.merchant_uid
	                       }

	                   }).done(function (data) {
	                     // 가맹점 서버 결제 API 성공시 로직
	                   })
	                   
	                var msg = '결제가 완료되었습니다.';
	                msg += '고유ID : ' + rsp.imp_uid;
	                msg += '상점 거래ID : ' + rsp.merchant_uid;
	                msg += '결제 금액 : ' + rsp.paid_amount;
	                msg += '카드 승인번호 : ' + rsp.apply_num;
	                movePath = "${ pageContext.servletContext.contextPath }/member/list";
	                
	                console.log(rsp);
	             	
	                $.ajax({
	                	url: "${ pageContext.servletContext.contextPath }",
	                	type: "POST",
	                
	             	data: rsp,
	             	
	             	success : function(data, textStatus, xhr){
	             		console.table(data);
	             	},
	             	error : function(xhr, status, error){
	             		console.log(error);
	             	}
	             	
	                })
	            } else {
	                var msg = '결제에 실패하였습니다.';
	                msg += '에러내용 : ' + rsp.error_msg;
	                movePath = "${ pageContext.servletContext.contextPath }";
	             }
	             alert(msg);
	             location.href = movePath;
			}
			};
	          

	          
	       </script>
	    </body>
	 </html>
	          
	     