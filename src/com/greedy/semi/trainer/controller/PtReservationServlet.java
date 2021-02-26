package com.greedy.semi.trainer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.trainer.dto.PtReservationDTO;
import com.greedy.semi.trainer.service.ClassService;

@WebServlet("/pt/reservation")
public class PtReservationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int trainerNo = Integer.parseInt(request.getParameter("trainerNo"));
		
		PtReservationDTO reservationMember = new PtReservationDTO();
		reservationMember.setMemberNo(memberNo);
		reservationMember.setTrainerNo(trainerNo);
		
		ClassService classService = new ClassService();
		int result = classService.reservationMember(reservationMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("reservationMember", "reservationMember");
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "1:1PT 예약에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
