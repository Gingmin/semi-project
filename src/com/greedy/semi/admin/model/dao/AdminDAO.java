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
import com.greedy.semi.admin.model.dto.PurchaseProductDTO;
import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.dto.TrainerInfoDTO;
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

		/* 경우의 수 */
		String query = null;
		if(name.length() > 0 && !(no < 0 && phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNameCount");
		} else if(no > 0 && !(name.length() < 0 && phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNoCount");
		} else if(phone.length() > 0 && !(no < 0 && name.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchPhoneCount");
		} else if(ptAmount > 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchPtCount");
		} else if(ptAmount == 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchNotPtCount");
		} else if(ptAmount == -1 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchAllPtCount");
		} else if(name.length() > 0 && no > 0 && !(phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNameNoCount");
		} else if(name.length() > 0 && phone.length() > 0 && !(no < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNamePhoneCount");
		} else if(no > 0 && phone.length() > 0 && !(name.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNoPhoneCount");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == -1) {
			query = prop.getProperty("searchNameNoPhoneCount");
		} 

		else if(name.length() > 0 && ptAmount > 0 && !(phone.length() < 0 && no < 0)) {										//두번쨰
			query = prop.getProperty("searchNamePtCount");
		} else if(no > 0 && ptAmount > 0 && !(phone.length() < 0 && name.length() < 0)) {
			query = prop.getProperty("searchNoPtCount");
		} else if(phone.length() > 0 && ptAmount > 0 && !(name.length() < 0 && no < 0)) {
			query = prop.getProperty("searchPhonePtCount");
		}  else if(name.length() > 0 && no > 0 && ptAmount > 0 && !(phone.length() < 0)) {
			query = prop.getProperty("searchNameNoPtCount");
		} else if(name.length() > 0 && phone.length() > 0 && ptAmount > 0 && !(no < 0)) {
			query = prop.getProperty("searchNamePhonePtCount");
		} else if(no > 0 && phone.length() > 0 && ptAmount > 0 && !(name.length() < 0)) {
			query = prop.getProperty("searchNoPhonePtCount");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount > 0) {
			query = prop.getProperty("searchNameNoPhonePtCount");
		} 

		else if(name.length() > 0 && ptAmount == 0 && !(no < 0 && phone.length() < 0)) {										//세 번째
			query = prop.getProperty("searchNameNotPtCount");
		} else if(no > 0 && ptAmount == 0 && !(name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchNoNotPtCount");
		} else if(phone.length() > 0 && ptAmount == 0 && !(name.length() < 0 && no < 0)) {
			query = prop.getProperty("searchPhoneNotPtCount");
		} else if(name.length() > 0 && no > 0 && ptAmount == 0 && !(phone.length() < 0)) {
			query = prop.getProperty("searchNameNoNotPtCount");
		} else if(name.length() > 0 && phone.length() > 0 && ptAmount == 0 && !(no < 0)) {
			query = prop.getProperty("searchNamePhoneNotPtCount");
		} else if(no > 0 && phone.length() > 0 && ptAmount == 0 && !(name.length() < 0)) {
			query = prop.getProperty("searchNoPhoneNotPtCount");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == 0) {
			query = prop.getProperty("searchNameNoPhoneNotPtCount");
		}

		try {
			pstmt = con.prepareStatement(query);

			/* 경우의 수에 따른 쿼리 결과 */
			if(name.length() > 0 && !(no < 0 && phone.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && !(name.length() < 0 && phone.length() < 0) && ptAmount == -1) {
				pstmt.setInt(1, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(phone.length() > 0 && !(no < 0 && name.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(ptAmount > 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(ptAmount == 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(ptAmount == -1 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && !(phone.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && phone.length() > 0 && !(no < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && phone.length() > 0 && !(name.length() < 0) && ptAmount == -1) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
				/* 두번째 */
			} else if(name.length() > 0 && ptAmount > 0 && !(phone.length() < 0 && no < 0)	) {
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && ptAmount > 0 && !(phone.length() < 0 && name.length() < 0)) {
				pstmt.setInt(1, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(phone.length() > 0 && ptAmount > 0 && !(name.length() < 0 && no < 0)) {
				pstmt.setString(1, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && ptAmount > 0 && !(phone.length() < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && phone.length() > 0 && ptAmount > 0 && !(no < 0)) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && phone.length() > 0 && ptAmount > 0 && !(name.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount > 0) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			}
			/*세번째*/
			else if(name.length() > 0 && ptAmount == 0 && !(no < 0 && phone.length() < 0)) {
				pstmt.setString(1, name);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && ptAmount == 0 && !(name.length() < 0 && phone.length() < 0)) {
				pstmt.setInt(1, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(phone.length() > 0 && ptAmount == 0 && !(name.length() < 0 && no < 0)) {
				pstmt.setString(1, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && ptAmount == 0 && !(phone.length() < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && phone.length() > 0 && ptAmount == 0 && !(no < 0)) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(no > 0 && phone.length() > 0 && ptAmount == 0 && !(name.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					totalCount = rset.getInt("COUNT(*)");
				}
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == 0) {
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

	public List<MemberDTO> searchMemberList(Connection con, String name, int no, String phone, int ptAmount, PageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<MemberDTO> memberList = null;

		String query = null;
		if(name.length() > 0 && !(no < 0 && phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchName");
			System.out.println("searchName");
		} else if(no > 0 && !(name.length() < 0 && phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNo");
			System.out.println("searchNo");
		} else if(phone.length() > 0 && !(no < 0 && name.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchPhone");
			System.out.println("searchPhone");
		} else if(ptAmount > 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchPt");
			System.out.println("searchPt");
		} else if(ptAmount == 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchNotPt");
			System.out.println("searchNotPt");
		} else if(ptAmount == -1 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchAllpt");
			System.out.println("searchAllpt");  
		} else if(name.length() > 0 && no > 0 && !(phone.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNameNo");
			System.out.println("searchNameNo");
		} else if(name.length() > 0 && phone.length() > 0 && !(no < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNamePhone");
			System.out.println("searchNamePhone");
		} else if(no > 0 && phone.length() > 0 && !(name.length() < 0) && ptAmount == -1) {
			query = prop.getProperty("searchNoPhone");
			System.out.println("searchNoPhone");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == -1) {
			query = prop.getProperty("searchNameNoPhone");
			System.out.println("searchNameNoPhone");
		} 

		else if(name.length() > 0 && ptAmount > 0 && !(phone.length() < 0 && no < 0)) {										//두번쨰
			query = prop.getProperty("searchNamePt");
			System.out.println("sarchNamePt");
		} else if(no > 0 && ptAmount > 0 && !(phone.length() < 0 && name.length() < 0)) {
			query = prop.getProperty("searchNoPt");
			System.out.println("searchNoPt");
		} else if(phone.length() > 0 && ptAmount > 0 && !(name.length() < 0 && no < 0)) {
			query = prop.getProperty("searchPhonePt");
			System.out.println("searchPhonePt");
		}  else if(name.length() > 0 && no > 0 && ptAmount > 0 && !(phone.length() < 0)) {
			query = prop.getProperty("searchNameNoPt");
			System.out.println("searchNameNoPt");
		} else if(name.length() > 0 && phone.length() > 0 && ptAmount > 0 && !(no < 0)) {
			query = prop.getProperty("searchNamePhonePt");
			System.out.println("searchNamePhonePt");
		} else if(no > 0 && phone.length() > 0 && ptAmount > 0 && !(name.length() < 0)) {
			query = prop.getProperty("searchNoPhonePt");
			System.out.println("searchNoPhonePt");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount > 0) {
			query = prop.getProperty("searchNameNoPhonePt");
			System.out.println("searchNameNoPhonePt");
		} 

		else if(name.length() > 0 && ptAmount == 0 && !(no < 0 && phone.length() < 0)) {										//세 번째
			query = prop.getProperty("searchNameNotPt");
			System.out.println("searchNameNoPt");
		} else if(no > 0 && ptAmount == 0 && !(name.length() < 0 && phone.length() < 0)) {
			query = prop.getProperty("searchNoNotPt");
			System.out.println("searchNoNotPt");
		} else if(phone.length() > 0 && ptAmount == 0 && !(name.length() < 0 && no < 0)) {
			query = prop.getProperty("searchPhoneNotPt");
			System.out.println("searchPhoneNotPt");
		} else if(name.length() > 0 && no > 0 && ptAmount == 0 && !(phone.length() < 0)) {
			query = prop.getProperty("searchNameNoNotPt");
			System.out.println("searchNameNoNotPt");
		} else if(name.length() > 0 && phone.length() > 0 && ptAmount == 0 && !(no < 0)) {
			query = prop.getProperty("searchNamePhoneNotPt");
			System.out.println("searchNanePhoneNotPt");
		} else if(no > 0 && phone.length() > 0 && ptAmount == 0 && !(name.length() < 0)) {
			query = prop.getProperty("searchNoPhoneNotPt");
			System.out.println("searchNoPhoneNotPt");
		} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == 0) {
			query = prop.getProperty("searchNameNoPhoneNotPt");
			System.out.println("searchNaneNoPhoneNotPt");
		}

		try {
			pstmt = con.prepareStatement(query);
			
			/* 경우의 수에 따른 쿼리 결과 */
			if(name.length() > 0 && !(no < 0 && phone.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(no > 0 && !(name.length() < 0 && phone.length() < 0) && ptAmount == -1) {
				pstmt.setInt(1, no);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(phone.length() > 0 && !(no < 0 && name.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, phone);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(ptAmount > 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
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
			} else if(ptAmount == 0 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
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
			} else if(ptAmount == -1 && !(no < 0 && name.length() < 0 && phone.length() < 0)) {
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
			} else if(name.length() > 0 && no > 0 && !(phone.length() < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && phone.length() > 0 && !(no < 0) && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(no > 0 && phone.length() > 0 && !(name.length() < 0) && ptAmount == -1) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == -1) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				pstmt.setInt(4, pageInfo.getStartRow());
				pstmt.setInt(5, pageInfo.getEndRow());

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
				/* 두번째 */
			} else if(name.length() > 0 && ptAmount > 0 && !(phone.length() < 0 && no < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(no > 0 && ptAmount > 0 && !(phone.length() < 0 && name.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(phone.length() > 0 && ptAmount > 0 && !(name.length() < 0 && no < 0)) {
				pstmt.setString(1, phone);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && no > 0 && ptAmount > 0 && !(phone.length() < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && phone.length() > 0 && ptAmount > 0 && !(no < 0)) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(no > 0 && phone.length() > 0 && ptAmount > 0 && !(name.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount > 0) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				pstmt.setInt(4, pageInfo.getStartRow());
				pstmt.setInt(5, pageInfo.getEndRow());

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
			}
			/*세번째*/
			else if(name.length() > 0 && ptAmount == 0 && !(no < 0 && phone.length() < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(no > 0 && ptAmount == 0 && !(name.length() < 0 && phone.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(phone.length() > 0 && ptAmount == 0 && !(name.length() < 0 && no < 0)) {
				pstmt.setString(1, phone);
				pstmt.setInt(2, pageInfo.getStartRow());
				pstmt.setInt(3, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && no > 0 && ptAmount == 0 && !(phone.length() < 0)) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && phone.length() > 0 && ptAmount == 0 && !(no < 0)) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(no > 0 && phone.length() > 0 && ptAmount == 0 && !(name.length() < 0)) {
				pstmt.setInt(1, no);
				pstmt.setString(2, phone);
				pstmt.setInt(3, pageInfo.getStartRow());
				pstmt.setInt(4, pageInfo.getEndRow());

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
			} else if(name.length() > 0 && no > 0 && phone.length() > 0 && ptAmount == 0) {
				pstmt.setString(1, name);
				pstmt.setInt(2, no);
				pstmt.setString(3, phone);
				pstmt.setInt(4, pageInfo.getStartRow());
				pstmt.setInt(5, pageInfo.getEndRow());

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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return memberList;

	}

	public MemberDTO selectMemberDetail(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberDetail");
				
		MemberDTO memberDetail = null;
		System.out.println("dao");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberDetail = new MemberDTO();
				memberDetail.setAmountDTO(new AmountDTO());
				memberDetail.setPurchaseProductDTO(new PurchaseProductDTO());
				
				memberDetail.setNo(rset.getInt("MEMBER_NO"));
				memberDetail.setEmail(rset.getString("EMAIL"));
				memberDetail.setName(rset.getString("MEMBER_NAME"));
				memberDetail.setPhone(rset.getString("PHONE"));
				memberDetail.setEnrollDate(rset.getDate("ENROLL_DATE"));
				memberDetail.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				memberDetail.setBlackStatus(rset.getString("BLACK_STATUS"));
				memberDetail.setRole(rset.getString("MEMBER_ROLE"));
				memberDetail.setStatus(rset.getString("MEMBER_STATUS"));
				memberDetail.getAmountDTO().setAmount(rset.getInt("PT_AMOUNT"));
				memberDetail.getAmountDTO().setExpDate(rset.getDate("MEMBERSHIP_EXP_DATE"));
				memberDetail.getPurchaseProductDTO().setPurCode(rset.getString("PURCHASE_CODE"));
				memberDetail.getPurchaseProductDTO().setProCode(rset.getString("PRODUCT_CODE"));
				memberDetail.getPurchaseProductDTO().setPurDate(rset.getDate("PURCHASE_DATE"));
				memberDetail.getPurchaseProductDTO().setPermitNo(rset.getInt("PURCHASE_PERMIT_NO"));
				memberDetail.getPurchaseProductDTO().setPurStatus(rset.getString("PURCHASE_STATUS"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao의 memberDetail : " + memberDetail);
		return memberDetail;
	}

	public int selectTotalPrice(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTotalPrice");
				
		int totalPrice = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalPrice = rset.getInt("SUM(I.PURCHASE_PRICE)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return totalPrice;
	}

	public AmountDTO selectPuchaseYN(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectPuchaseYN");
				
		AmountDTO amountDTO = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				amountDTO = new AmountDTO();
				amountDTO.setAmount(rset.getInt("PT_AMOUNT"));
				amountDTO.setExpDate(rset.getDate("MEMBERSHIP_EXP_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return amountDTO;
	}

	public MemberDTO selectMemberNoPurchase(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectMemberNoPurchase");
				
		MemberDTO memberDetail = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberDetail = new MemberDTO();
				memberDetail.setAmountDTO(new AmountDTO());
				memberDetail.setPurchaseProductDTO(new PurchaseProductDTO());
				
				memberDetail.setNo(rset.getInt("MEMBER_NO"));
				memberDetail.setEmail(rset.getString("EMAIL"));
				memberDetail.setName(rset.getString("MEMBER_NAME"));
				memberDetail.setPhone(rset.getString("PHONE"));
				memberDetail.setEnrollDate(rset.getDate("ENROLL_DATE"));
				memberDetail.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				memberDetail.setBlackStatus(rset.getString("BLACK_STATUS"));
				memberDetail.setRole(rset.getString("MEMBER_ROLE"));
				memberDetail.setStatus(rset.getString("MEMBER_STATUS"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return memberDetail;
		
	}

	public List<MemberDTO> selectTrainerList(Connection con, PageInfoDTO pageInfo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<MemberDTO> trainerList = null;

		String query = prop.getProperty("selectTrainerList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());

			rset = pstmt.executeQuery();

			trainerList = new ArrayList<>();

			while(rset.next()) {
				MemberDTO trainer = new MemberDTO();
				trainer.setTrainerInfoDTO(new TrainerInfoDTO());
				
				trainer.setNo(rset.getInt("MEMBER_NO"));
				trainer.setEmail(rset.getString("EMAIL"));
				trainer.setName(rset.getString("MEMBER_NAME"));
				trainer.setPhone(rset.getString("PHONE"));
				trainer.setEnrollDate(rset.getDate("ENROLL_DATE"));
				trainer.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				trainer.setBlackStatus(rset.getString("BLACK_STATUS"));
				trainer.setRole(rset.getString("MEMBER_ROLE"));
				trainer.setStatus(rset.getString("MEMBER_STATUS"));
				trainer.getTrainerInfoDTO().setApprovalStatus(rset.getString("APPROVAL_STATUS"));

				trainerList.add(trainer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return trainerList;
	}

	public int selectTotalTrainerCount(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;

		int totalCount = 0;

		String query = prop.getProperty("selectTotalTrainerCount");

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

	public int updateTrainerApproval(Connection con, int updateTrainer) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateTrainerApproval");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, updateTrainer);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	

}
