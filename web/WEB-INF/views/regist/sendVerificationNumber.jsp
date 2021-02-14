<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.greedy.semi.member.mail.MailAuth"  %>
<%@ page import="javax.mail.Authenticator"  %>
<%@ page import="javax.mail.PasswordAuthentication"  %>
<%@ page import="java.io.UnsupportedEncodingException"  %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Properties" %>
<%@ page import="javax.mail.Authenticator" %>
<%@ page import="javax.mail.Message" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page import="javax.mail.Session" %>
<%@ page import="javax.mail.Transport" %>
<%@ page import="javax.mail.internet.AddressException" %>
<%@ page import="javax.mail.internet.InternetAddress" %>
<%@ page import="javax.mail.internet.MimeMessage" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/member/sendVerificationNumber.css">
<title>계정 찾기</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
   <div class="info_area">
      <div class="info_text">이메일 인증하기</div>
      <br><br>
	  <input type="text" id="searchedEmail" value="${ requestScope.searchedEmail.email }" style="display:none;">
	  <input type="text" id="searchedName" value="${ requestScope.searchedEmail.name }" style="display:none;">
	  <input type="text" id="requestEmail" value="${ requestScope.requestMember.email }" style="display:none;">
	  <input type="text" id="requestName" value="${ requestScope.requestMember.name }" style="display:none;">
	  <form class="info" action="" method="post" id="myform">
	 <%--  <c:set var="searchedEmail" value="${ requestScope.searchedEmail.email }" scope="request" />
	  <c:set var="searchedName" value="${ requestScope.searchedEmail.name }" scope="request"/> --%>
	  <!-- 다음 비밀번호 찾기를 위해 값을 담아둘 변수 선언 -->
	  <%-- <c:set var="tempEmail" value="${ requestScope.searchedEmail.email }" scope="request" />
	  <c:set var="tempName" value="${ requestScope.searchedEmail.name }" scope="request" /> --%>
	  <!-- 잘못된 접근 -->
	  	<c:if test="${ empty requestScope.searchedEmail && (empty requestScope.verificationNumber && empty requestScope.requestMember) }">
	  		<h3>잘못된 접근입니다.</h3>
	  	</c:if>
	  <!-- 이메일찾기를 성공해야 인증 가능하도록 -->
	      <c:if test="${ !empty requestScope.searchedEmail && (empty requestScope.verificationNumber && empty requestScope.requestMember) }">
	      	 <div class="info_item1">
	            <div class="info_text1">
	               본인확인 이메일 주소와 입력한 이메일 주소가 같아야, <br>인증번호를 받을 수 있습니다.
	            </div>
	            <br><br>
	            <div class="special">
	            	<table>
	            		<tr>
	            			<td width="110px">이름 : </td>
	            			<td><input class="number_input" type="text" name="name" id="name" placeholder="이름을 입력하세요"></td>
	            			<td width="55px"></td>
	            			<td></td>
	            		</tr>
	            		<tr height="5px"></tr>
	            		<tr>
			            	<td width="110px">이메일 주소 : </td>
			           		<td><input class="number_input" type="email" name="email" id="email" placeholder="이메일을 입력하세요"></td>
			            	<td width="55px"></td>
			            	<td><button class="certify" onclick="return sendVerificationNumber();">인증번호 받기</button><td>
	            		</tr>
	            		<tr height="5px"></tr>
	            		<tr>
	            			<td width="110px"></td>
	            			<td><input class="number_input" type="text" name="verificationNumber" id="verificationNumber" placeholder="인증번호를 입력하세요"></td>
	            			<td width="55px"></td>
	            			<td></td>
	            		</tr>
	            	</table>
	            </div>
	         </div>
      	</c:if>
	         <!-- 인증번호를 받았을 때 시작 -->
	  		 <c:if test="${ !empty requestScope.verificationNumber && !empty requestScope.requestMember }">
	  		 	<div class="info_item1">
	            <div class="info_text1">
	               본인확인 이메일 주소와 입력한 이메일 주소가 같아야, <br>인증번호를 받을 수 있습니다.
	            </div>
	            <br><br>
	            <div class="special">
	            	<table>
	            		<tr>
	            			<td width="110px">이름 : </td>
	            			<td><input class="number_input" type="text" name="name" id="name" placeholder="이름을 입력하세요" value="${ requestScope.requestMember.name }"></td>
	            			<td width="55px"></td>
	            			<td></td>
	            		</tr>
	            		<tr height="5px"></tr>
	            		<tr>
			            	<td width="110px">이메일 주소 : </td>
			           		<td><input class="number_input" type="email" name="email" id="email" placeholder="이메일을 입력하세요" value="${ requestScope.requestMember.email }"></td>
			            	<td width="55px"></td>
			            	<td><button class="certify" onclick="return sendVerificationNumber();">인증번호 받기</button><td>
	            		</tr>
	            		<tr height="5px"></tr>
	            		<tr>
	            			<td width="110px"></td>
	            			<td><input class="number_input" type="text" name="verificationNumber" id="verificationNumber" placeholder="인증번호를 입력하세요"></td>
	            			<td width="55px"></td>
	            			<td></td>
	            		</tr>
	            	</table>
	            </div>
	         </div>
	  		 </c:if>
	  		 <!-- 인증번호를 받았을 때 끝  -->	
	         <br><br>
	         
	          <div class="submit_reset">
	         	<input type="button" value="다음" id="confirm" onclick="return movePath();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	         	<input type="button" value="취소" id="cancel">
	         </div>
	         
	      </form>
      
   </div>
</div>

<br><br><br><br><br>

<jsp:include page="../common/footer.jsp"/>

<script>
	function sendVerificationNumber() {
		
		const name = document.getElementById("name").value;
		const email = document.getElementById("email").value;
		const searchedEmail = document.getElementById("searchedEmail").value;
		const searchedName = document.getElementById("searchedName").value;
		
		const $myform = document.getElementById("myform");
		
		if(!name || name === "") {
			alert("이름을 입력해야 합니다");
			document.getElementById("name").focus();
			return false;
		}
		if(!email || email === "") {
			alert("이메일을 입력해야 합니다");
			document.getElementById("email").focus();
			return false;
		}
		if(!(name === searchedName)) {
			alert("입력한 이름과 가입정보가 다릅니다.");
			document.getElementById("name").focus();
			return false;
		}
		if(!(email === searchedEmail)) {
			alert("입력한 메일주소와 다릅니다.");
			document.getElementById("email").focus();
			return false;
		}
		
		$myform.action = "${ pageContext.servletContext.contextPath }/member/verfication";
		$myform.submit();
		
		alert("인증번호가 발송되었습니다. 메일을 확인해보세요.");
	}
</script>
<script>
	function movePath() {
		
		const name = document.getElementById("name").value;
		const email = document.getElementById("email").value;
		const requestEmail = document.getElementById("requestEmail").value;
		const requestName = document.getElementById("requestName").value;
		
		const $myform = document.getElementById("myform");
		const verificationNumber = document.getElementById("verificationNumber").value;
		
		if(!name || name === "") {
			alert("이름을 입력해야 합니다");
			document.getElementById("name").focus();
			return false;
		}
		if(!email || email === "") {
			alert("이메일을 입력해야 합니다");
			document.getElementById("email").focus();
			return false;
		}
		if(!(name === requestName)) {
			alert("입력한 이름과 가입정보가 다릅니다.");
			document.getElementById("name").focus();
			return false;
		}
		if(!(email === requestEmail)) {
			alert("입력한 메일주소와 다릅니다.");
			document.getElementById("email").focus();
			return false;
		}
		
		/* 인증번호 확인 */
		if(!verificationNumber || verificationNumber === "") {
			alert("인증번호를 입력해야 합니다.");
			document.getElementById("verificationNumber").focus();
			return false;
		}
		if(verificationNumber != "${ requestScope.verificationNumber }") {
			alert("인증번호가 다릅니다.");
			document.getElementById("verificationNumber").focus();
			return false;
		}
		
		$myform.action = "${ pageContext.servletContext.contextPath }/member/resetPassword";
		$myform.submit();
	}
</script>
<script>
/* 	(function(){
		if("${ !empty requestScope.verificationNumber }") {
			
			alert("인증번호가 발송되었습니다. 메일을 확인해보세요.");
		}
	})(); */
</script>
</body>
</html>