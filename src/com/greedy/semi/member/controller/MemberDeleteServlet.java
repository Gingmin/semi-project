package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setNo(no);
		requestMember.setEmail(email);
		requestMember.setPwd(pwd);
		
		int result = new MemberService().deleteMember(requestMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteMember");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 정보 삭제 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
