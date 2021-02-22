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

@WebServlet("/admin/member")
public class AdminMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 0;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if(pageNo <= 0) {
			pageNo = 1;
		}

		AdminService adminService = new AdminService();
		int totalCount = adminService.selectTotalCount();
		System.out.println("totalCount : " + totalCount);

		int limit = 10;
		int buttonAmount = 5;
		System.out.println("pageNo : " + pageNo);
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		List<MemberDTO> memberList = adminService.selectMemberList(pageInfo);

		for(MemberDTO member : memberList) {
			System.out.println(member);
		}

		String path = "";
		if(memberList != null) {
			path = "/WEB-INF/views/admin/member.jsp";
			request.setAttribute("memberList", memberList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 정보 조회 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		int no = Integer.parseInt(request.getParameter("memberNo"));
		String phone = request.getParameter("phone");
		
		System.out.println("search name : " + name);
		System.out.println("search no : " + no);
		System.out.println("search phone : " + phone);
		
		/* 값을 따로 넘겨주려고 받은 파라미터 */
		String ptYn = request.getParameter("ptYn");
		System.out.println("search ptYn : " + ptYn);
		
		/* y이면 1 n이면 0 (pt 1보다 크면 y이므로) */
		int ptAmount = 0;
		switch(ptYn) {
			case "Y" : ptAmount = 1; break;
			case "N" : ptAmount = 0; break;
		}
		
		MemberDTO searchMember = new MemberDTO();
		searchMember.setNo(no);
		searchMember.setName(name);
		searchMember.setPhone(phone);

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		AdminService adminService = new AdminService();
	    int totalCount = adminService.searchMemberCount(name, no, phone, ptAmount);
	      
	    System.out.println("tatalCount : " + totalCount);
	      
	    int limit = 10;
	    int buttonAmount = 5;
	      
	    PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	    System.out.println(pageInfo);
		
	    List<MemberDTO> memberList = adminService.searchMemberList(name, no, phone, ptAmount, pageInfo);
	      
	      for(MemberDTO member : memberList) {
	    	  System.out.println(member);
        }
	    
	    String path = "";
	      if(memberList != null) {
	    	  path = "/WEB-INF/views/admin/member.jsp";
	    	  request.setAttribute("memberList", memberList);
	    	  request.setAttribute("pageInfo", pageInfo);
	    	  request.setAttribute("ptYn", ptYn);
	    	  request.setAttribute("searchMember", searchMember);
	      } else {
	    	  path = "/WEB-INF/views/common/failed.jsp";
	    	  request.setAttribute("message", "게시물 검색 실패");
	      }
	      
	      request.getRequestDispatcher(path).forward(request, response);
	}

}
