package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/finalResetPwd")
public class MemberFinalResetPasswordServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String newPwd = request.getParameter("newPassword");
		
		MemberDTO updateResetMember = new MemberDTO();
		updateResetMember.setEmail(email);
		updateResetMember.setPwd(newPwd);
		
		MemberDTO resetMember = new MemberService().updateResetPassword(updateResetMember);
		
		String path = "";
		if(resetMember != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateResetPassword");
		} else {
			path = "/WEB-INF/views/regist/resetPasswordForm.jsp";
			request.setAttribute("resetMember", resetMember);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
