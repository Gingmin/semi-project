package com.greedy.semi.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.member.model.dto.MemberDTO;

@WebServlet("/admin/black/detail")
public class AdminBlackDetailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDTO blackDetail = new AdminService().selectBlackDetail(no);
		
		System.out.println("blackDetail : " + blackDetail);
		
		String path = "";
		if(blackDetail != null) {
			path = "/WEB-INF/views/admin/blackDetail.jsp";
			request.setAttribute("blackDetail", blackDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "블랙리스트 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
