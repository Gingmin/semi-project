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
			const failedCode = "${ requestScope.failedCode }"
			
			let movePath;
			let message;
			
			switch(failedCode) {
				case "seachedMember" :
					movePath = "${ pageContext.servletContext.contextPath }/member/identify";
					message = "가입정보가 없는 이메일입니다!";
					break;
				case "verifyFailed" :
					movePath = "${ pageContext.servletContext.contextPath }/member/identify";
					message = "인증번호를 발송하지 못했습니다.";
					break;
			}
			
			alert(message);
			location.href = movePath;
		})();
	</script>
</body>
</html>