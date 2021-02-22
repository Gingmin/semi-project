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

@WebServlet("/trainer/page")
public class TrainerPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String path = "/WEB-INF/views/trainer-page/mypage_trainer.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		
		ClassService classService = new ClassService();
		
		List<ClassDTO> thumbnailList = classService.selectThumbnailList();
		
		System.out.println(thumbnailList);
		
		for(ClassDTO class1 : thumbnailList) {
			System.out.println(class1);
		}
		
		String path = "";
		if(thumbnailList != null) {
			path = "/WEB-INF/views/exercise/mypagetrainer.jsp";
			request.setAttribute("thumbnailList", thumbnailList);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 등록 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
















