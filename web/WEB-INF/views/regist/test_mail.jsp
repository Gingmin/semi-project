<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.greedy.semi.member.mail.MailAuth" 
    import="com.greedy.semi.member.mail.MailSend" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page contentType="text/html; charset=UTF-8" %>

<%-- <%@ include file="/common/ssi.jsp" %>

<%@ include file="/common/resource.jsp" %>

<%@ page import="web.mail.*"  %> --%>

<%

MailSend ms = new MailSend();

ms.mailSend();

out.println("COMPLETE");

%>

</body>
</html>