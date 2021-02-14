package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/identify")
public class MemberIdentifyEmailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/regist/identifyEmail.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		
		MemberDTO searchedEmail = new MemberService().searchEmail(email);

		String path = "";
		if(searchedEmail != null) {
			path = "/WEB-INF/views/regist/sendVerificationNumber.jsp";
			request.setAttribute("searchedEmail", searchedEmail);
		} else {
			path = "/WEB-INF/views/common/failedAlert.jsp";
			request.setAttribute("failedCode", "seachedMember");
		}
		
		System.out.println("searchedEmail : " + searchedEmail);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
