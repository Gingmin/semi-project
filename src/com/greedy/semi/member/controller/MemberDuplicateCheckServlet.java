package com.greedy.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/infoCheck")
public class MemberDuplicateCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		
		String result = new MemberService().selectEmailList(email);
		
		System.out.println("조회후 result : " + result);
		
		String jsonString = "{\"result\":\"" + result + "\"}";
		
		System.out.println("json : " + jsonString);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.print(jsonString);
		
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
    }

}
