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
		System.out.println("service");
		close(con);
		
		return memberList;
	}

}
