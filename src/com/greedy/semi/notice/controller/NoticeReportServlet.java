package com.greedy.semi.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.common.paging.Pagenation;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;
import com.greedy.semi.notice.model.service.NoticeService;


@WebServlet("/notice/report")
public class NoticeReportServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals("currentPage")) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		NoticeService noticeService = new NoticeService();
		int totalCount = noticeService.selectReportCount();
				
		int limit = 10;
		
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
				
		List<NoticeDTO> reportList = new NoticeService().selectReportList(pageInfo);
		
				
		String path = "";
		if(reportList != null) {
			path = "/WEB-INF/views/notice/notice_report.jsp";
			request.setAttribute("reportList", reportList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "신고내역 조회실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
