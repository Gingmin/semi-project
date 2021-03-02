<?xml version="1.0" encoding="UTF-8"?>
<%@page import="com.greedy.semi.trainer.utility.Utility"%>
<%@page import="com.greedy.semi.trainer.dao.CommentDAO"%>
<%@page import="com.greedy.semi.trainer.dto.CommentDTO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CommentDTO> commentList = CommentDAO.getDAO().selectCommentList();
%>
<result>
	<% if(!commentList.isEmpty()) { %>
		<code>success</code>
		<data><![CDATA[
			[
			<% for(int i = 0; i < commentList.size(); i++) { %>
				<% if(i > 0) { %>,<% } %>
				{"no":<%=commentList.get(i).getNo()%>
				,"writer":"<%=Utility.toJSON(commentList.get(i).getWriter())%>"
				,"content":"<%=Utility.toJSON(commentList.get(i).getContent())%>"
				,"writeDate":"<%=commentList.get(i).getWriteDate()%>"}
			<% } %>
			]
		]]></data>
	<% } else { %>
		<code>empty</code>
		<message><![CDATA[첫번째 댓글을 등록해 주세요!]]></message>
	<% } %>	
</result>
