package com.greedy.semi.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.member.model.dto.MemberDTO;

@WebServlet("/admin/trainer/detail")
public class AdminTrainerDetailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDTO trainerDetail = new AdminService().selectTrainerDetail(no);
		
		System.out.println("trainerDetail : " + trainerDetail);
		
		String path = "";
		if(trainerDetail != null) {
			path = "/WEB-INF/views/admin/trainerDetail.jsp";
			request.setAttribute("trainerDetail", trainerDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "트레이너 상세 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	
	}

}
