package com.greedy.semi.blackList.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.BlackListDTO;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;


@WebServlet("/black/list")
public class BlackListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/blacklist/blackList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String writer = request.getParameter("writer");
		int writerMemberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String searchCode = request.getParameter("searchCode");
		
		
		System.out.println(writer);
		System.out.println(writerMemberNo);
		System.out.println(title);
		System.out.println(body);
		System.out.println(searchCode);
		
		NoticeDTO reportNotice = new NoticeDTO();
		BlackListDTO reportBlack = new BlackListDTO();
		
		
		reportBlack.setMemberNo(writerMemberNo);
		reportBlack.setReportCode(searchCode);
		reportNotice.setTitle(title);
		reportNotice.setBody(body);
		reportNotice.setWriterMemberNo(writerMemberNo);
		
		int result = new NoticeService().insertReport(reportNotice, reportBlack);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertReport");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "신고 내역 접수 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
