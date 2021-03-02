<?xml version="1.0" encoding="UTF-8"?>
<%@page import="com.greedy.semi.trainer.dao.CommentDAO"%>
<%@page import="com.greedy.semi.trainer.dto.CommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}

	request.setCharacterEncoding("UTF-8");
	
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	CommentDTO comment = new CommentDTO();
	comment.setWriter(writer);
	comment.setContent(content);
	
	int rows = CommentDAO.getDAO().insertComment(comment);
%>
<result>
	<% if (rows > 0) { %>
		<code>success</code>
		<% } else { %>
			<code>fail</code>
		<% } %>	
</result>