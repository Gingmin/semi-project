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

@WebServlet("/member/findEmail")
public class MemberFindEmailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/regist/selectFindEmailForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String phone = request.getParameter("phone").replace("-", "");
		
		System.out.println("name : " + name);
		System.out.println("phone : " + phone);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setName(name);
		requestMember.setPhone(phone);
		
		MemberDTO responseMember = new MemberService().selectFindEmail(requestMember);
		
		String path = "";
		if(responseMember != null) {
		    path = "/WEB-INF/views/regist/resultFindEmail.jsp";
		    request.setAttribute("responseMember", responseMember);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "이메일 찾기 실패!");
		}
		System.out.println("검색후 email : " + responseMember.getEmail());
		System.out.println("검색후 date : " + responseMember.getEnrollDate());
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
