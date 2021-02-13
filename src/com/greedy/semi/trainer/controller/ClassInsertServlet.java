package com.greedy.semi.trainer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.trainer.dto.ClassDTO;
import com.greedy.semi.trainer.service.ClassService;

@WebServlet("/class/insert")
public class ClassInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/exercise/ClassRegist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String ptclass = request.getParameter("ptclass");
		String health = request.getParameter("health");
		String intro = request.getParameter("intro1")
					+"$" + request.getParameter("intro2")
					+ "$" + request.getParameter("intro3");
		String introduce = request.getParameter("introduce");
		String classDate = request.getParameter("time");
		
		ClassDTO classInsert = new ClassDTO();
		classInsert.setName(name);
		classInsert.setType(ptclass);
		classInsert.setType(health);
		classInsert.setIntro(intro);
		classInsert.setIntroduce(introduce);
		classInsert.setInsertDate(classDate);
		
		int result = new ClassService().insertClass(classInsert);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertClass");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "클래스 개설에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
