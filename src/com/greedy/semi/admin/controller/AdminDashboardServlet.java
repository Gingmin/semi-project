package com.greedy.semi.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.movecontroll.ControlMethod;
import com.greedy.semi.member.model.dto.MemberDTO;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int members = new AdminService().selectMembers();
		int trainers = new AdminService().selectTrainers();
		int blackLists = new AdminService().selectBlackLists();
		int groupPT = new AdminService().selectGroupPT();
		int oneToOnePT = new AdminService().selectoneToOnePT();
		int membershipGroup = new AdminService().selectMembershipGroup();
		int membershipOneToOne = new AdminService().selectmembershiponeToOne();
		
		
		System.out.println("멤버스" + members);
		System.out.println("트레이너" + trainers);
		System.out.println("블랙리스트" + blackLists);
		System.out.println("그룹피티 " + groupPT);
		System.out.println("월이용권 " + membershipGroup);
		System.out.println("1:1피티 " + membershipOneToOne);
		
		
		String path = "admin/dashboard.jsp";
		request.setAttribute("members", members);
		request.setAttribute("trainers", trainers);
		request.setAttribute("blackLists", blackLists);
		request.setAttribute("groupPT", groupPT);
		request.setAttribute("oneToOnePT", oneToOnePT);
		request.setAttribute("membershipGroup", membershipGroup);
		request.setAttribute("membershipOneToOne", membershipOneToOne);
		ControlMethod.moveForward(path, request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
