package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/passwordChange")
public class MemberPasswordChangeServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/views/member-page/updatePasswordForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String email = ((MemberDTO) request.getSession().getAttribute("loginMember")).getEmail();
		String pwd = request.getParameter("password");
		String newPwd = request.getParameter("newPassword");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setEmail(email);
		requestMember.setNo(no);
		requestMember.setPwd(pwd);
		
		int result = new MemberService().changePassword(requestMember, newPwd);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "changePassword");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "비밀번호 변경 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
