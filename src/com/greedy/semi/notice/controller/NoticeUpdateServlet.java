package com.greedy.semi.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;

@WebServlet("/notice/update")
public class NoticeUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDTO noticeDetail = new NoticeService().selectNoticeDetail(no);
		
		System.out.println("서비스 :" + noticeDetail);
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/notice/notice_update.jsp";
			request.setAttribute("notice", noticeDetail);
		} else {
			path = "/WEB-INF/views/notice/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("수정 타이틀  :" + title);
		System.out.println("수정 바디  :" + body);
		System.out.println("번호 : " + no);
		
		NoticeDTO changeContent = new NoticeDTO();
		changeContent.setTitle(title);
		changeContent.setBody(body);
		changeContent.setNo(no);
		
		int changeNotice = new NoticeService().updateNotice(changeContent);
		
		System.out.println("서블릿" + changeNotice);
		
		String path = "";
		if(changeNotice > 0) {
			System.out.println("dsfsdfsdfdsdf...");
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateNotice");
			request.setAttribute("no", no);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
