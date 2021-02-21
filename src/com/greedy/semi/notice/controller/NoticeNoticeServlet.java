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

@WebServlet("/notice/notice")
public class NoticeNoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals("currentPage")) {
			
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("커런트페이지" + currentPage);
		System.out.println("페이지넘버 : " + pageNo);
		
		NoticeService noticeService = new NoticeService();
		int totalCount = noticeService.selectTotalCount();
		
		System.out.println("토탈카운트" + totalCount);
		
		int limit = 10;
		
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pinfo : " + pageInfo);
		
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList(pageInfo);
		
		System.out.println("노티스서비스 :" +noticeList);
		
		String path ="";
		if(noticeList != null) {
			path = "/WEB-INF/views/notice/notice_borad.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "WEB-INF/views/common/failed.jsp";
			request.setAttribute("message","조회 실패");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	

}
