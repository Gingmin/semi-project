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

@WebServlet("/admin/trainer/search")
public class AdminTrainerSearchServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String searchCondition = request.getParameter("searchCondition");
	      String searchValue = request.getParameter("searchValue");
	      
	      System.out.println("searchCondition : " + searchCondition);
	      System.out.println("searchValue : " + searchValue);
	      
	      String currentPage = request.getParameter("currentPage");
	      int pageNo = 1;
	      
	      if(currentPage != null && !"".equals(currentPage)) {
	         pageNo = Integer.parseInt(currentPage);
	      }
	      
	      if(pageNo <= 0) {
	         pageNo = 1;
	      }
	      
	      AdminService adminService = new AdminService();
	      int totalCount = adminService.searchTrainerCount(searchCondition, searchValue);
	      
	      System.out.println("tatalCount : " + totalCount);
	   
	      int limit = 10;
	      int buttonAmount = 5;
	      
	      PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	      System.out.println(pageInfo);
	      
	      List<MemberDTO> trainerList = adminService.searchTrainerList(searchCondition, searchValue,pageInfo);
	      
	      for(MemberDTO trainer : trainerList) {
	    	  System.out.println(trainer);
	      }
	      
	      String path = "";
	      if(trainerList != null) {
	    	  path = "/WEB-INF/views/admin/trainer.jsp";
	    	  request.setAttribute("boardList", trainerList);
	    	  request.setAttribute("pageInfo", pageInfo);
	    	  request.setAttribute("searchCondition", searchCondition);
	    	  request.setAttribute("searchValue", searchValue);
	      } else {
	    	  path = "/WEB-INF/views/common/failed.jsp";
	    	  request.setAttribute("message", "트레이너 검색 실패");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
