package com.greedy.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.common.movecontroll.ControlMethod;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.dto.TrainerInfoDTO;
import com.greedy.semi.member.model.service.MemberService;

@WebServlet("/member/trainerInfo")
public class TrainerUpdateServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		
		MemberService memberService = new MemberService();
		
		TrainerInfoDTO trainerInfo = memberService.selectTrainerInfo(no);
		
		String path = "";
		if(trainerInfo != null) {
			path = "/WEB-INF/views/member-page/updateTrainerForm.jsp";
			request.setAttribute("trainerInfo", trainerInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "트레이너 정보 조회에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		
		String account = request.getParameter("account");
		String bankName = request.getParameter("bankname");
		String holder = request.getParameter("holder");
		
		TrainerInfoDTO trainer = new TrainerInfoDTO();
		trainer.setNo(no);
		trainer.setAccountNumber(account);
		trainer.setBankName(bankName);
		trainer.setAccountHolder(holder);
		
		int result = new MemberService().updateTrainerInfo(trainer);
		
		if(result > 0) {
			ControlMethod.successForward("updateTrainer", request, response);
		} else {
			ControlMethod.failedForward("트레이너 추가 정보 수정 실패", request, response);
		}
		
	}

}
