package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 로그인 페이지로 이동 */
		String path = "/WEB-INF/views/login/loginMember.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* 일반 회원 로그인 */
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setEmail(email);
		requestMember.setPwd(pwd);
		
		MemberService ms = new MemberService();
		MemberDTO loginMember = ms.memberCheck(requestMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "가입하지 않은 이메일이거나, 잘못된 비밀번호입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
