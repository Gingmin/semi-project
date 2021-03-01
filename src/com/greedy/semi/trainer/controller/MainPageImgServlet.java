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

@WebServlet("/main/img")
public class MainPageImgServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassService classService = new ClassService();
		
		List<ClassDTO> thumbnailList = classService.selectThumbnailList();
		
		System.out.println(thumbnailList);
		
		for(ClassDTO class1 : thumbnailList) {
			System.out.println("값 잘들어오고 있나요? : " + class1);
		}
		
		String path = "";
		if(thumbnailList != null) {
			path = "/WEB-INF/views/main/main.jsp";
			request.setAttribute("thumbnailList", thumbnailList);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 등록 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
	