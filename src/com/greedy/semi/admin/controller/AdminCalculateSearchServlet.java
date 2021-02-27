package com.greedy.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.dto.ReceiptDTO;
import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.paging.Pagenation;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

@WebServlet("/admin/calculatorMoney/search")
public class AdminCalculateSearchServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String memberNo = request.getParameter("memberNo");
	      String name = request.getParameter("name");
	      String searchDate1 = request.getParameter("searchDate1");
	      String searchDate2 = request.getParameter("searchDate2");
	      
	      if(memberNo == null || name == null || searchDate1 == null || searchDate2 == null) {
	    	  System.out.println("모든 값 입력해야함");
	    	  request.getRequestDispatcher("/WEB-INF/views/admin/calculator.jsp").forward(request, response);
	      }
	      
	      System.out.println("memberNo : " + memberNo);
	      System.out.println("name : " + name);
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
	      int totalCount = adminService.searchCalculateSearchCount(memberNo, name, searchDate1, searchDate2);
	      
	      System.out.println("tatalCount : " + totalCount);
	   
	      int limit = 10;
	      int buttonAmount = 5;
	      
	      PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	      System.out.println(pageInfo);
	      
	      List<ReceiptDTO> payList = adminService.searchCalculateSearchList(memberNo, name, pageInfo, searchDate1, searchDate2);
	      
	      for(ReceiptDTO receipt : payList) {
	    	  System.out.println(receipt);
	      }
	      
	      String searchValue = "되거라";
	      
	      String path = "";
	      if(payList != null) {
	    	  path = "/WEB-INF/views/admin/calculator.jsp";
	    	  request.setAttribute("searchValue", searchValue);
	    	  request.setAttribute("payList", payList);
	    	  request.setAttribute("pageInfo", pageInfo);
	    	  request.setAttribute("memberNo", memberNo);
	    	  request.setAttribute("name", name);
	    	  request.setAttribute("searchDate1", searchDate1);
	    	  request.setAttribute("searchDate2", searchDate2);
	      } else {
	    	  path = "/WEB-INF/views/common/failed.jsp";
	    	  request.setAttribute("message", "정산 내역 검색 실패");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
