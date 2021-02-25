package com.greedy.semi.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.semi.member.model.dto.MemberDTO;

@WebFilter(urlPatterns = {"/member/*", "/notice/*", "/trainer/*", "/admin/*"})
public class AuthenticationFilter implements Filter {

	private Map<String, List<String>> permitURIList;
	
    public AuthenticationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		
		if(loginMember != null) {
			
			boolean isAuthorized = false;
			
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitTrainer = permitURIList.get("trainerPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			if("ADMIN".equals(loginMember.getRole())) {
				
				if(isPermitAdmin || isPermitMember || isPermitAll) {
					isAuthorized = true;
				}
				
			} else if("MEMBER".equals(loginMember.getRole())) {
				
				if((isPermitAll || isPermitMember) && !isPermitAdmin) {
					isAuthorized = true;
				}
				
			} else if("TRAINER".equals(loginMember.getRole())) {
				
				if((isPermitAll || isPermitTrainer) && !isPermitAdmin) {
					isAuthorized = true;
				}
				
			}
			
			if(isAuthorized) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
			
		} else {
			
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스입니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> trainerPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		adminPermitList.add("/admin/dashboard");
		adminPermitList.add("/admin/member");
		adminPermitList.add("/admin/member/search");
		adminPermitList.add("/admin/member/detail");
		adminPermitList.add("/admin/trainer");
		adminPermitList.add("/admin/trainer/search");
		adminPermitList.add("/admin/trainer/detail");
		adminPermitList.add("/admin/trainer/approval");
		adminPermitList.add("/admin/purchaseMember");
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/update");
		adminPermitList.add("/notice/delete");
		adminPermitList.add("/admin/out");
		adminPermitList.add("/admin/black");
		adminPermitList.add("/trainer/page");
		adminPermitList.add("/trainer/detail");
		
		adminPermitList.add("/member/paymentResult");
		
		memberPermitList.add("/member/mypage");
		memberPermitList.add("/member/update");
		memberPermitList.add("/member/delete");
		memberPermitList.add("/member/passwordChange");
		memberPermitList.add("/member/list");
		memberPermitList.add("/member/buy");
		memberPermitList.add("/notice/notice");
		memberPermitList.add("/notice/review");
		memberPermitList.add("/notice/search");
	 	memberPermitList.add("/notice/report");
	 	memberPermitList.add("/notice/question");
	 	memberPermitList.add("/notice/detail");
	 	
		trainerPermitList.add("/member/mypage");
		trainerPermitList.add("/member/update");
		trainerPermitList.add("/member/delete");
		trainerPermitList.add("/member/passwordChange");
		trainerPermitList.add("/member/trainerInfo");
		trainerPermitList.add("/notice/notice");
		trainerPermitList.add("/notice/review");
		trainerPermitList.add("/notice/search");
		trainerPermitList.add("/notice/report");
		trainerPermitList.add("/notice/detail");
		trainerPermitList.add("/notice/question");
		trainerPermitList.add("/trainer/insert");
		trainerPermitList.add("/class/insert");
		trainerPermitList.add("/trainer/page");
		trainerPermitList.add("/class/detail");
		trainerPermitList.add("/trainer/sales_details");
		trainerPermitList.add("/trainer/detail");
		trainerPermitList.add("/trainer/profileEdit");
		
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		allPermitList.add("/member/findEmail");
		allPermitList.add("/member/resultFindEmail");
		allPermitList.add("/member/identify");
		allPermitList.add("/member/verfication");
		allPermitList.add("/member/registVerfication");
		allPermitList.add("/member/resetPassword");
		allPermitList.add("/member/finalResetPwd");
		allPermitList.add("/member/infoCheck");
		allPermitList.add("/member/policy");
		allPermitList.add("/member/terms");
		allPermitList.add("/trainer/regist");
		
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("trainerPermitList", trainerPermitList);
		permitURIList.put("allPermitList", allPermitList);
	}

}
