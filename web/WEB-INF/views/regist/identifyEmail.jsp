<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 확인</title>
<link rel="stylesheet" href="/semi/resources/css/member/identifyEmail.css">
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="container">
	   <div class="info_area">
	      <div class="info_text">
	         계정 확인
	      </div>
	      <br><br>
	      <form class="info" action="" method="post" id="myform">
	         <div class="info_item1">
	            <br>
	            <input class="box_detail" type="email" name="email" id="email" placeholder="이메일을 입력해주세요" autofocus>
	         </div>
	         
	         <br><br>
	         
	          <div class="submit_reset">
	         	<input type="button" value="다음" id="confirm" onclick="return movePath();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	         	<input type="button" value="취소" id="cancelIdentify">
	         </div>
	         
	      </form>
	      
	   </div>
	</div>

	<br><br><br><br><br>
	
	<jsp:include page="../common/footer.jsp"/>
	<script>
		function movePath() {
			
			const $myform = document.getElementById("myform");
			const email = document.getElementById("email").value;
			
			if(!email || email === "") {
				alert("이메일을 반드시 입력해야 합니다.");
				document.getElementById("email").focus();
				return false;
			}
			
			$myform.action = "${ pageContext.servletContext.contextPath }/member/identify";
			$myform.submit();
		}
	</script>
</body>
</html>