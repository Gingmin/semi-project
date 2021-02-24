package com.greedy.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.movecontroll.ControlMethod;

@WebServlet("/admin/trainer/approval")
public class AdminTrainerApprovalServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("승인하러 왔니?");
		int updateTrainer = Integer.parseInt(request.getParameter("updateTrainer"));
		System.out.println("updateTrainer : " + updateTrainer);
		
		int result = new AdminService().updateTrainerApproval(updateTrainer);
		
		String path = "";
		if(result > 0) {
			String successMessage = "adminTraunerUpdateApproval";
			ControlMethod.successForward(successMessage, request, response);
		} else {
			String failedMessage = "트레이너 승인 실패";
			ControlMethod.failedForward(failedMessage, request, response);
		}
		
	}

}
