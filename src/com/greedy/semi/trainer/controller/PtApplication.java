package com.greedy.semi.trainer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.trainer.dto.TrainerPtPermitDTO;
import com.greedy.semi.trainer.service.ClassService;

@WebServlet("/pt/application")
public class PtApplication extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TrainerPtPermitDTO pt = new TrainerPtPermitDTO(0, null, 0, null, "memberNo", null);
		
		int result = new ClassService().insertPtApplication(pt);
		
		String path = "";
		if(result > 0 ) {
			path = "/WEB-INF/views/trainer-page/trainer_profile.jsp";
			request.setAttribute("insertPtApplication", "insertPtApplication");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "1:1수업 신청이 실패되었습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
