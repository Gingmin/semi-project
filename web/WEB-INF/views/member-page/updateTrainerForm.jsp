<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/semi/resources/css/member/updateTrainerForm.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
		<div class="info_area">
			<div class="info_text">추가정보</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						계좌번호 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="account" id="account"
						value="${ requestScope.trainerInfo.accountNumber }" placeholder="계좌번호를 입력하세요">
				</div>

				<br>

				
				<div class="info_item1">
					<div class="info_text1">
						은행명 <span class="info_detail">*</span>
					</div>
					<select class="box_detail" name="bankname" id="bankname">
						<option selected disabled hidden>선택하세요</option>
						<option value="KB국민은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'KB국민은행' }">selected</c:if>>KB국민은행</option>
						<option value="NH농협은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'NH농협은행' }">selected</c:if>>NH농협은행</option>
						<option value="SH수협은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'SH수협은행' }">selected</c:if>>SH수협은행</option>
						<option value="우리은행" <c:if test="${ requestScope.trainerInfo.bankName eq '우리은행' }">selected</c:if>>우리은행</option>
						<option value="신한은행" <c:if test="${ requestScope.trainerInfo.bankName eq '신한은행' }">selected</c:if>>신한은행</option>
						<option value="하나은행" <c:if test="${ requestScope.trainerInfo.bankName eq '하나은행' }">selected</c:if>>하나은행</option>
						<option value="SC제일은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'SC제일은행' }">selected</c:if>>SC제일은행</option>
						<option value="힌극씨티은행" <c:if test="${ requestScope.trainerInfo.bankName eq '한국씨티은행' }">selected</c:if>>힌극씨티은행</option>
						<option value="IBK기업은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'IBK기업은행' }">selected</c:if>>IBK기업은행</option>
						<option value="KDB산업은행" <c:if test="${ requestScope.trainerInfo.bankName eq 'KDB산업은행' }">selected</c:if>>KDB산업은행</option>
						<option value="카카오뱅크" <c:if test="${ requestScope.trainerInfo.bankName eq '카카오뱅크' }">selected</c:if>>카카오뱅크</option>
					</select>
				</div>
				<br>

				<div class="info_item1">
					<div class="info_text1">
						예금주 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="holder" id="holder"
						placeholder="예금주를 입력하세요" value="${ requestScope.trainerInfo.accountHolder }">
				</div>
				<br>

				<div class="info_item1">
					<div class="info_text1">
						승인여부 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="text" name="name" id="name"
						value="${ requestScope.trainerInfo.approvalStatus }" readonly>
				</div>

				<br>

				<div class="info_item1">
					<div class="info_text1">
						누적평점 <span class="info_detail">*</span>
					</div>
					<input class="box_detail" type="number" name="averageScore" 
					id="averageScore" value="${ requestScope.trainerInfo.averageScore }" readonly>
				</div>
				
				<br><br><br>

				<div class="submit_reset">
					<input type="button" id="modify" value="수정" onclick="return movePath();">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" id="cancel">
				</div>
				<br><br><br>
			</form>
			<!-- 팝업 -->
		</div>
	</div>
	<br><br><br><br><br>
	
	<jsp:include page="../common/footer.jsp"/>
	<script>
	function movePath() {

		const account = document.getElementById("account").value;
		const holder = document.getElementById("holder").value;
		
		const $bankname = document.getElementById("bankname");
		const bankname = $bankname.options[$bankname.selectedIndex].value;
		
		const $myForm = document.getElementById("myForm");
		
		if(!bankname || bankname === "" || bankname === "선택하세요") {
			alert("은행을 반드시 선택해야 합니다.");
			document.getElementById("bankname").focus();
			return false;
		}
		
		if(!account || account === "") {
			alert("계좌번호를 반드시 입력해야 합니다.");
			document.getElementById("account").focus();
			return false;
		}
		
		if(!holder || holder === "") {
			alert("예금주를 반드시 입력해야 합니다.");
			document.getElementById("holder").focus();
			return false;
		}
		
		let requestPath = "${ pageContext.servletContext.contextPath }/member/trainerInfo"; 
		
		$myForm.action = requestPath;
		$myForm.submit();
	}
	</script>
	
</body>
</html>