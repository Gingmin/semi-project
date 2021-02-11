package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/regist/registMemberForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post>");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password").replace("-", "");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
	
		MemberDTO requestMember = new MemberDTO();
		requestMember.setEmail(email);
		requestMember.setPwd(pwd);
		requestMember.setName(name);
		requestMember.setPhone(phone);
		
		int result = new MemberService().registMember(requestMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertMember");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원가입 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
