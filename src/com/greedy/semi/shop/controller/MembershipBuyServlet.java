package com.greedy.semi.shop.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.semi.member.model.service.MemberService;
import com.greedy.semi.shop.model.dto.PurchaseProductDTO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.shop.model.service.PriceService;
import com.greedy.semi.shop.model.service.PurchaseService;

@WebServlet("/member/buy")
public class MembershipBuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int No = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String email = ((MemberDTO) request.getSession().getAttribute("loginMember")).getEmail();
		String name = ((MemberDTO) request.getSession().getAttribute("loginMember")).getName();
		String phone = ((MemberDTO) request.getSession().getAttribute("loginMember")).getPhone();
		
		String productValue = request.getParameter("productValue");
		
		System.out.println("productValue : " + productValue);
		
		PriceService priceService = new PriceService();
		int productPrice = priceService.selectProductPrice(productValue);
		
		System.out.println("productPrice : " + productPrice);
		
		request.setAttribute("productPrice", productPrice);
		
		String path = "/WEB-INF/views/payment/import.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String purchaseCode = request.getParameter("purchaseCode");
		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String productCode = request.getParameter("productValue");
		int purchasePrice = Integer.parseInt(request.getParameter("purchasePrice"));
		int purchasePermitNo = Integer.parseInt(request.getParameter("purchasePermitNo"));
		String purchaseStatus = "완료";
		
			
		PurchaseProductDTO purchaseInfo = new PurchaseProductDTO();
		
		purchaseInfo.setPurchaseCode(purchaseCode);
		purchaseInfo.setProductCode(productCode);
		purchaseInfo.setPurchasePrice(purchasePrice);
		purchaseInfo.setPurchasePermitNo(purchasePermitNo);
		purchaseInfo.setPurchaseStatus(purchaseStatus);
		
		System.out.println("changeInfo : " + purchaseInfo);
		
		PurchaseService purchaseService = new PurchaseService();
		PurchaseProductDTO changedInfo = purchaseService.insertPurchaseInfo(purchaseInfo, no);
		
		String path = "";
		if(changedInfo != null) {
			path = "/WEB-INF/views/member-page/mypage_member.jsp";
			
		} else {
			path = "/WEB-INF/views/member-page/mypage_member.jsp";
		
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

}
 
