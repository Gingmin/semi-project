package com.greedy.semi.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.shop.model.service.PriceService;

@WebServlet("/member/buy")
public class MembershipBuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productValue = request.getParameter("productValue");
		
		System.out.println("productValue : " + productValue);
		
		PriceService priceService = new PriceService();
		int productPrice = priceService.selectProductPrice(productValue);
		
		System.out.println("productPrice : " + productPrice);
		
		request.setAttribute("productPrice", productPrice);
		String path = "/WEB-INF/views/payment/membership.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String success = request.getParameter("imp_uid");
	System.out.println("success : " + success);
			
		
	}

}
