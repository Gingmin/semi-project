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

	public int searchMemberCount(String name, int no, String phone, int ptAmount) {
		
		Connection con = getConnection();
		
		int totalCount = adminDAO.searchMemberCount(con, name, no, phone, ptAmount);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchMemberList(String name, int no, String phone, int ptAmount, PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> boardList = adminDAO.searchMemberList(con, no, phone, ptAmount, pageInfo);
		
		close(con);
		
		return boardList;
	}

}
