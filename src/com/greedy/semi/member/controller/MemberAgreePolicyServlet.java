package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.common.movecontroll.ControlMethod;

@WebServlet("/member/policy")
public class MemberAgreePolicyServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String movePath = "common/privacy_policy.jsp";
		ControlMethod.moveForward(movePath, request, response);
	
	}


}
