<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기 결과</title>
<link rel="stylesheet" href="/semi/resources/css/resultFindEmail.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
		<div class="info_area">
			<div class="info_text">가입한 이메일 찾기</div>
			<br>
			<br>

			<form class="info" action="" method="post" id="myForm">
				<div class="info_item1">
					<div class="info_text1">
						고객님의 정보와 일치하는 이메일입니다.
					</div>
				</div>
				<br>
				<div class="box">
					<table>
						<tr>
							<td>
							    <input class="box_detail" type="text" name="email" id="email" placeholder="현재 비밀번호를 입력하세요" value="${ requestScope.responseMember.email }" readonly >
							</td>
							<td width="60px"></td>
							<td>
							    <label>가입일 : </label>
						        <input class="box_detail" type="text" name="enrollDate" id="enrollDate" value="${ requestScope.responseMember.enrollDate }" readonly>
					       </td>
						</tr>
					</table>
				</div>
				<br>
				<div class="submit_reset">
					<input type="button" value="로그인하기" name="" id="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="비밀번호찾기" name="" id="resetPassword">
				</div>

			</form>
		</div>
	</div>
	<br><br><br><br><br>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>