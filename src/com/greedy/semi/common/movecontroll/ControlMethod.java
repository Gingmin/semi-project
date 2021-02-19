package com.greedy.semi.common.movecontroll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlMethod extends HttpServlet {

	public static void successForward(String successMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/common/success.jsp";
		
		request.setAttribute("successCode", successMessage);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}	
	
	public static void failedForward(String failedMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/common/failed.jsp";
		
		request.setAttribute("message", failedMessage);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	public static void moveForward(String movePath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/" + movePath;
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
}
