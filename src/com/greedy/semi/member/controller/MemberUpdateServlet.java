package com.greedy.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/member-page/updateMemberForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("password").replace("-", "");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
	
		MemberDTO changeInfo = new MemberDTO();
		changeInfo.setEmail(email);
		changeInfo.setPwd(pwd);
		changeInfo.setName(name);
		changeInfo.setPhone(phone);
		
		MemberDTO changedMember = new MemberService().updateMember(changeInfo);
		
		String path = "";
		if(changedMember != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateMember");
			request.getSession().setAttribute("loginMember", changedMember);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
