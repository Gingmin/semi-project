package com.greedy.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;


@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"))


		System.out.println("서블릿 들리나?");

		String title = request.getParameter("title");
		String body = request.getParameter("body");

		NoticeDTO requestNotice = new NoticeDTO();
		requestNotice.setNo(no);
		requestNotice.setTitle(title);
		requestNotice.setBody(body);

		int result = new NoticeService().deleteNotice(requestNotice);
		
		System.out.println(result);

		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteNotice");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 삭제 실패");
		}
		System.out.println("서블릿 아래 ~~~ ");
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
