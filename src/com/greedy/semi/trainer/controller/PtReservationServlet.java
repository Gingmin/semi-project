package com.greedy.semi.trainer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pt/reservation")
public class PtReservationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberNo = request.getParameter("MemberNo");
		String trainerNo = request.getParameter("trainerNo");
		
		PrintWriter out = response.getWriter();
		out.print(memberNo);
		
		out.flush();
		out.close();
		
		System.out.println("memberNo : " + memberNo);
		System.out.println("trainerNo : " + trainerNo);
		
		
		
	}

}
