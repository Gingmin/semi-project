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

@WebServlet("/admin/member/search")
public class AdminMemberSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = "";
		String phone = "";
		
		System.out.println("request.getParameter(\"memberNo\") : " + request.getParameter("memberNo"));
		
		if(!("".equals(request.getParameter("name")))) {
			name = request.getParameter("name");
		}
		if(!("".equals(request.getParameter("phone")))) {
			phone = request.getParameter("phone");
		}
		
		System.out.println("search name : " + name);
		System.out.println("search phone : " + phone);
		
		/* 값을 따로 넘겨주려고 받은 파라미터 */
		String ptYn = request.getParameter("ptYn");
		System.out.println("search ptYn : " + ptYn);
		
		/* y이면 1 n이면 0 (pt 1보다 크면 y이므로) */
		int ptAmount = 0;
		switch(ptYn) {
			case "Y" : ptAmount = 1; break;
			case "N" : ptAmount = 0; break;
			case "전체" : ptAmount = -1; break;
		}
		System.out.println("ptAmount : " + ptAmount);

		MemberDTO searchMember = new MemberDTO();
		
		if(request.getParameter("memberNo") == null && "".equals(request.getParameter("memberNo"))) {
			int no = 0;
			searchMember.setNo(no);
		} else if(request.getParameter("memberNo") != null && !"".equals(request.getParameter("memberNo"))) {
			int no = Integer.parseInt(request.getParameter("memberNo"));
			searchMember.setNo(no);
			System.out.println("search no : " + no);
		} 
		
		searchMember.setName(name);
		searchMember.setPhone(phone);
		
		System.out.println("searchMember : " + searchMember);

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		AdminService adminService = new AdminService();
	    int totalCount = adminService.searchMemberCount(searchMember, ptAmount);
	      
	    System.out.println("tatalCount : " + totalCount);
	      
	    int limit = 10;
	    int buttonAmount = 5;
	      
	    PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	    System.out.println(pageInfo);
		
	    List<MemberDTO> memberList = adminService.searchMemberList(searchMember, ptAmount, pageInfo);
	      
	      for(MemberDTO member : memberList) {
	    	  System.out.println(member);
        }
	    
	    /* 검색 flag */
	    String searchValue = "";
	      
	    String path = "";
	      if(memberList != null) {
	    	  path = "/WEB-INF/views/admin/member.jsp";
	    	  searchValue = "searhComplete";
	    	  request.setAttribute("memberList", memberList);
	    	  request.setAttribute("pageInfo", pageInfo);
	    	  request.setAttribute("ptYn", ptYn);
	    	  request.setAttribute("searchMember", searchMember);
	    	  request.setAttribute("searchValue", searchValue);
	      } else {
	    	  path = "/WEB-INF/views/common/failed.jsp";
	    	  request.setAttribute("message", "게시물 검색 실패");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	
	}

}
