package com.greedy.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;


@WebServlet("/notice/detail")
public class NoticeDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO noticeDetail = new NoticeService().selectNoticeDetail(no);
		
		System.out.println("서비스 :" + noticeDetail);
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/notice/notice_detail.jsp";
			request.setAttribute("notice", noticeDetail);
			
		} else {
			path = "/WEB-INF/views/notice/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	

}
