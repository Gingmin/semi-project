package com.greedy.semi.trainer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.trainer.dto.ClassDTO;
import com.greedy.semi.trainer.service.ClassService;

@WebServlet("/class/detail")
public class ClassDetailSerlvlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));


		ClassDTO thumbnail = new ClassService().selectOneThumbnailClass(no);

		System.out.println("thumbnail detail : " + thumbnail);

		String path = "";
		if(thumbnail != null) {
			path = "/WEB-INF/views/exercise/ClassDetail.jsp";
			request.setAttribute("thumbnail", thumbnail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 게시판 상세 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}

