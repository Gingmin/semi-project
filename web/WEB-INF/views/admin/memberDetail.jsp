<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="number" value="${ requestScope.memberDetail.no }">
	<input type="text" value="${ requestScope.memberDetail.email }">
	<input type="text" value="${ requestScope.memberDetail.name }">
	<input type="tel" value="${ requestScope.memberDetail.phone }">
	<input type="text" value="${ requestScope.memberDetail.enrollDate }">
	<input type="text" value="${ requestScope.memberDetail.modifiedDate }">
	<input type="text" value="${ requestScope.memberDetail.blackStatus }">
	<input type="text" value="${ requestScope.memberDetail.role }">
	<input type="text" value="${ requestScope.memberDetail.status }">
	<input type="text" value="${ requestScope.memberDetail.amountDTO.amount }">
	<input type="text" value="${ requestScope.memberDetail.amountDTO.expDate }">
	<input type="text" value="${ requestScope.memberDetail.purchaseProductDTO.purCode }">
	<input type="text" value="${ requestScope.memberDetail.purchaseProductDTO.proCode }">
	<input type="number" value="${ requestScope.memberDetail.purchaseProductDTO.price }">
	<input type="text" value="${ requestScope.memberDetail.purchaseProductDTO.purDate }">
	<input type="number" value="${ requestScope.memberDetail.purchaseProductDTO.permitNo }">
	<input type="text" value="${ requestScope.memberDetail.purchaseProductDTO.purStatus }">
	
</body>
</html>