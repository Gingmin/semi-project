package com.greedy.semi.admin.model.service;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.admin.model.dao.AdminDAO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

public class AdminService {
	
	private final AdminDAO adminDAO;
	
	public AdminService() {
		
		adminDAO = new AdminDAO();
	}

	public int selectTotalCount() {

		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> selectMemberList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> memberList = adminDAO.selectMemberList(con, pageInfo);

		close(con);
		
		return memberList;
	}

	public int searchMemberCount(MemberDTO searchMember, int ptAmount) {
		
		Connection con = getConnection();
		
		String name = searchMember.getName();
		int no = searchMember.getNo();
		String phone = searchMember.getPhone();
		
		System.out.println("searchMemberCount name : " + name);
		System.out.println("searchMemberCount no : " + no);
		System.out.println("searchMemberCount phone : " + phone);
		
		int totalCount = adminDAO.searchMemberCount(con, name, no, phone, ptAmount);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchMemberList(MemberDTO searchMember, int ptAmount, PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		String name = searchMember.getName();
		int no = searchMember.getNo();
		String phone = searchMember.getPhone();
		
		System.out.println("searchMemberList name : " + name);
		System.out.println("searchMemberList no : " + no);
		System.out.println("searchMemberList phone : " + phone);
		
		List<MemberDTO> memberList = adminDAO.searchMemberList(con, name, no, phone, ptAmount, pageInfo);
		
		close(con);
		
		return memberList;
	}

	public MemberDTO selectMemberDetail(int no) {

		Connection con = getConnection();
		
		MemberDTO memberDetail = adminDAO.selectMemberDetail(con, no);
		
		close(con);
		
		return memberDetail;
	}

}
