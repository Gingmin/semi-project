package com.greedy.semi.trainer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.trainer.dto.ClassDTO;
import com.greedy.semi.trainer.service.ClassService;


@WebServlet("/trainer/detail")
public class TrainerDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String path = "/WEB-INF/views/trainer-page/trainer_profile.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		
		int no = Integer.parseInt(request.getParameter("no"));


		ClassDTO trainer = new ClassService().selectTrainerInfo(no);

		System.out.println("trainer Info : " + trainer);

		String path = "";
		if(trainer != null) {
			path = "/WEB-INF/views/trainer-page/trainer_profile.jsp";
			request.setAttribute("trainer", trainer);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "트레이너 정보 상세 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
