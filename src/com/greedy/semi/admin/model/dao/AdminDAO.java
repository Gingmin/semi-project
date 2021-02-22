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
				
				while(rset.next()) {
					MemberDTO member = new MemberDTO();
					member.setAmountDTO(new AmountDTO());
					
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
					
					memberList.add(member);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return memberList;
	}

	public int searchMemberCount(Connection con, String name, int no, String phone, int ptAmount) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		/* 8가지 경우의 수 */
		String query = null;
		if(name.length() > 0) {
			query = prop.getProperty("searchNameCount");
		} else if(no > 0) {
			query = prop.getProperty("searchNoCount");
		} else if(phone.length() > 0) {
			query = prop.getProperty("searchPhoneCount");
		} else if(ptAmount > 0) {
			query = prop.getProperty("searchPtCount");
		} else if(name.length() > 0 && no > 0) {
			query = prop.getProperty("searchNameNoCount");
		} else if(name.length() > 0 && phone.length() > 0) {
			query = prop.getProperty("searchNamePhoneCount");
		} else if(no > 0 && phone.length() > 0) {
			query = prop.getProperty("searchNoPhoneCount");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0) {
			query = prop.getProperty("searchNameNoPhoneCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			
			/* 경우의 수에 따른 쿼리 결과 */
			if(name.length() > 0) {
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0) {
				pstmt.setInt(1, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(phone.length() > 0) {
				pstmt.setString(1, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(ptAmount > 0) {
				pstmt.setInt(1, ptAmount);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && phone.length() > 0) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && phone.length() > 0) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && phone.length() > 0) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return totalCount;
	}

	public List<MemberDTO> searchMemberList(Connection con, int no, String phone, int ptAmount, PageInfoDTO pageInfo) {

		
		return null;
	}
	
	
	
}
