package com.greedy.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.paging.Pagenation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

@WebServlet("/admin/black/search")
public class AdminBlackSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String searchCondition = request.getParameter("searchCondition");
	      String searchValue = request.getParameter("searchValue");
	      String searchDate1 = request.getParameter("searchDate1");
	      String searchDate2 = request.getParameter("searchDate2");
	      
	      System.out.println("searchCondition : " + searchCondition);
	      System.out.println("searchValue : " + searchValue);
	      System.out.println("searchDate1 : " + searchDate1);
	      System.out.println("searchDate2 : " + searchDate2);
	      
	      String currentPage = request.getParameter("currentPage");
	      int pageNo = 1;
	      
	      if(currentPage != null && !"".equals(currentPage)) {
	         pageNo = Integer.parseInt(currentPage);
	      }
	      
	      if(pageNo <= 0) {
	         pageNo = 1;
	      }
	      
	      AdminService adminService = new AdminService();
	      int totalCount = adminService.searchBlackCount(searchCondition, searchValue, searchDate1, searchDate2);
	      
	      System.out.println("tatalCount : " + totalCount);
	   
	      int limit = 10;
	      int buttonAmount = 5;
	      
	      PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	      System.out.println(pageInfo);
	      
	      List<MemberDTO> blackList = adminService.searchBlackList(searchCondition, searchValue, pageInfo, searchDate1, searchDate2);
	      
	      for(MemberDTO black : blackList) {
	    	  System.out.println(black);
	      }
	      
	      String path = "";
	      if(blackList != null) {
	    	  path = "/WEB-INF/views/admin/black.jsp";
	    	  request.setAttribute("blackList", blackList);
	    	  request.setAttribute("pageInfo", pageInfo);
	    	  request.setAttribute("searchCondition", searchCondition);
	    	  request.setAttribute("searchValue", searchValue);
	    	  request.setAttribute("searchDate1", searchDate1);
	    	  request.setAttribute("searchDate2", searchDate2);
	      } else {
	    	  path = "/WEB-INF/views/common/failed.jsp";
	    	  request.setAttribute("message", "블랙리스트 검색 실패");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
