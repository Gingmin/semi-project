package com.greedy.semi.trainer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/trainer/class")
public class TrainerClassInertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/exercise/ClassRegist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ptclass = request.getParameter("ptclass");
		String gruopclass = request.getParameter("gruopclass");
		String classname = request.getParameter("classname");
		String health = request.getParameter("health");
		String force = request.getParameter("force");
		String posture = request.getParameter("posture");
		String endurance = request.getParameter("endurance");
		String textarea = request.getParameter("textarea");
		String time = request.getParameter("time");
		
		System.out.println(ptclass);
		System.out.println(gruopclass);
		System.out.println(classname);
		System.out.println(health);
		System.out.println(force);
		System.out.println(posture);
		System.out.println(endurance);
		System.out.println(textarea);
		System.out.println(time);
		
	}

}
