package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/resetPassword")
public class MemberRsetPasswordServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setName(name);
		requestMember.setEmail(email);
		
		MemberDTO resetMember = new MemberService().selectResetMember(requestMember);
		
		String path = "";
		if(resetMember != null) {
			path = "/WEB-INF/views/regist/resetPasswordForm.jsp";
			request.setAttribute("resetMember", resetMember);
			System.out.println("비번 재설정 창으로 이동");
		} else {
			path = "/WEB-INF/views/regist/sendVerificationNumber.jsp";
			request.setAttribute("resetMember", requestMember);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
