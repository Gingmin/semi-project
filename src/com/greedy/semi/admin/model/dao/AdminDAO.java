package com.greedy.semi.admin.model.dao;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.semi.admin.model.dto.AmountDTO;
import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

public class AdminDAO {

	private Properties prop;
	
	public AdminDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "admin/admin-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectTotalCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;

		int totalCount = 0;

		String query = prop.getProperty("selectTotalCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			while(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return totalCount;
	}

	public List<MemberDTO> selectMemberList(Connection con, PageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectMemberList");

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, pageInfo.getStartRow());
				pstmt.setInt(2, pageInfo.getEndRow());
				
				rset = pstmt.executeQuery();

				memberList = new ArrayList<>();

				System.out.println("dasd");
				
				while(rset.next()) {
					MemberDTO member = new MemberDTO();
					member.setAmountDTO(new AmountDTO());
					
					System.out.println("아아아아앙아아~");
					
					member.setNo(rset.getInt("MEMBER_NO"));
					member.setEmail(rset.getString("EMAIL"));
					member.setName(rset.getString("MEMBER_NAME"));
					member.setPhone(rset.getString("PHONE"));
					member.setEnrollDate(rset.getDate("ENROLL_DATE"));
					member.setModifiedDate(rset.getDate("MODIFIED_DATE"));
					member.setBlackStatus(rset.getString("BLACK_STATUS"));
					member.setRole(rset.getString("MEMBER_ROLE"));
					member.setStatus(rset.getString("MEMBER_STATUS"));
					member.getAmountDTO().setAmount(rset.getInt("PT_AMOUNT"));
					member.getAmountDTO().setExpDate(rset.getDate("MEMBERSHIP_EXP_DATE"));
					
					System.out.println("dao의 member : " + member);
					
					memberList.add(member);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		System.out.println("dao의 memberList : " + memberList);
		return memberList;
	}
	
	
	
}
