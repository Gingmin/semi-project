<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }"
			
			let movePath;
			let message;
			
			switch(successCode) {
				case "insertMember" :
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					message = "회원 가입 성공!";
					break;
				case "updateMember" :
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					message = "회원 정보 수정 성공!";
					break;
				case "deleteMember" :
					movePath = "${ pageContext.servletContext.contextPath }";
					message = "회원 탈퇴 성공!";
					break;
				case "changePassword" :
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					message = "비밀번호 변경 성공! 다시 로그인 해주세요!"
					break;
				case "" :
					movePath = "${ pageContext.servletContext.contextPath }";
					message = ""
					break;
			}
			
			alert(message);
			location.href = movePath;
		})();
	</script>
</body>
</html>