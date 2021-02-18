package com.greedy.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;


@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int no = Integer.parseInt(request.getParameter("no"));
		
		
		NoticeDTO deleteNotice = new NoticeDTO();
		deleteNotice.setNo(no);
		
		int result = new NoticeService().deleteNotice(deleteNotice);
		
		System.out.println("서블릿 : " + result);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteNotice");
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "삭제 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
