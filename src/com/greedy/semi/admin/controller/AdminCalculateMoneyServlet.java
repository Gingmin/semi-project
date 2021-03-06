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

@WebServlet("/admin/calculatorMoney")
public class AdminCalculateMoneyServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String currentPage = request.getParameter("currentPage");

		int pageNo = 0;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}

		AdminService adminService = new AdminService();
		int totalCount = adminService.selectTotalCalCount();
		System.out.println("totalCount : " + totalCount);

		int limit = 10;
		int buttonAmount = 5;
		System.out.println("pageNo : " + pageNo);
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		List<ReceiptDTO> payList = adminService.selectCalList(pageInfo);

		for (ReceiptDTO pay : payList) {
			System.out.println(pay);
		}

		String path = "";
		if (payList != null) {
			path = "/WEB-INF/views/admin/calculator.jsp";
			request.setAttribute("payList", payList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 정보 조회 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
