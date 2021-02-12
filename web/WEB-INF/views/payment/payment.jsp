<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" type="text/css" href="/web/resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="/web/resources/css/payment.css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


	<!-- Rock Salt font -->
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">

	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

	<title>멤버쉽 구매</title>
</head>
<body>

	<div id="wrap">
		<!-- 헤더 -->
		<jsp:include page="../common/header.jsp"/>
		<!-- 헤더 끝 -->
		<div class="container">
			<div class="card_info_area">
				<div class="card_text">
					카드 정보 입력
				</div>
				<form>
					<div class="card_info">
						<div class="card_text1">
							카드 번호 <span class="icon_detail">*</span>	
						</div>
						<div class="input_area">
							<input class="input_detail" type="text" name="카드앞자리">
							<span>-</span>
							<input class="input_detail" type="text" name="카드두번쨰">
							<span>-</span>
							<input class="input_detail" type="password" name="카드세번쨰">
							<span>-</span>
							<input class="input_detail" type="password" name="카드네번쨰">
						</div>

					</div>
					<div class="card_info">
						<div class="card_text1">
							유효 기간(월/년) <span class="icon_detail">*</span>	
						</div>
						<div class="input_area">
							<input class="input_detail type" type="text" name="">
							
						</div>

					</div>
					<div class="card_info">
						<div class="card_text1">
							생년월일 <span class="icon_detail">*</span>	
						</div>
						<div class="input_area">
							<input class="input_detail type" type="text" name="">
							
						</div>

					</div>
					<div class="card_info">
						<div class="card_text1">
							비밀번호 앞 두자리 <span class="icon_detail">*</span>	
						</div>
						<div class="input_area">
							<input class="input_detail type" type="text" name="">
							
						</div>
					</div>
					<div class="buybtn_area">
						<button class="btn_detail" type="submit" data-toggle="modal" data-target="#myModal">멤버쉽 등록</button>
					</div>						
				</form>				
			</div>


			<!-- 팝업 부분 -->

			<div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    	<div class="modal-content">
				        <div class="modal-header">
				       		<i class="fas fa-dumbbell"></i>			        	
				        </div>
				        <div class="modal-body">
				        	<div class="modal_text">결제가 완료 되었습니다.</div>
				        </div>
				        <div class="modal-footer">
				        	<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
				        </div>
			    	</div>			      
			    </div>
			</div>
			<!-- 팝업 끝 -->	  
		</div>






		</div>
		<!-- 푸터 -->
		<jsp:include page="../common/footer.jsp"/>
		<!-- 푸터끝 -->
	



		
</body>
</html>