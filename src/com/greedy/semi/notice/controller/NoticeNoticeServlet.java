package com.greedy.semi.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;

@WebServlet("/notice/notice")
public class NoticeNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
		
		System.out.println(noticeList);
		
		String path ="";
		if(noticeList != null) {
			path = "/WEB-INF/views/notice/notice_borad.jsp";
			request.setAttribute("noticeList", noticeList);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message","조회 실패");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	

}
