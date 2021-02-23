package com.greedy.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.member.model.dto.MemberDTO;

@WebServlet("/admin/member/detail")
public class AdminMemberDetailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDTO memberDetail = new AdminService().selectMemberDetail(no);
		
		System.out.println("memberDetail : " + memberDetail);
		
		String path = "";
		if(memberDetail != null) {
			path = "/WEB-INF/views/admin/memberDetail.jsp";
			request.setAttribute("memberDetail", memberDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 상세 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
