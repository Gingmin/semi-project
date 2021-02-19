package com.greedy.semi.notice.model.dao;

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

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

public class NoticeDAO {

	private final Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "notice/notice-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<NoticeDTO> selectAllNoticeList(Connection con, PageInfoDTO pageInfo){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> noticeList = null;
		
		String query = prop.getProperty("selectAllNoticeList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setWriter(new MemberDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_TITLE"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_COUNT"));
				notice.setCreatedDate(rset.getDate("CREATED_DATE"));
				notice.setStatus(rset.getString("NOTICE_STATUS"));
				
				
				noticeList.add(notice);
				System.out.println("여기는 오나 ??");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return noticeList;
		
	}

	public int insertNotice(Connection con, NoticeDTO newNotice) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newNotice.getTitle());
			pstmt.setString(2, newNotice.getBody());
			pstmt.setInt(3, newNotice.getWriterMemberNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public NoticeDTO selectAllNoticeDetail(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		NoticeDTO noticeDetail = null;
		
		String query = prop.getProperty("selectAllNoticeDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				noticeDetail = new NoticeDTO();
				noticeDetail.setWriter(new MemberDTO());
				
				noticeDetail.setNo(rset.getInt("NOTICE_NO"));
				noticeDetail.setTitle(rset.getString("NOTICE_TITLE"));
				noticeDetail.setBody(rset.getString("NOTICE_BODY"));
				noticeDetail.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				noticeDetail.getWriter().setName(rset.getString("MEMBER_NAME"));
				noticeDetail.setCount(rset.getInt("NOTICE_COUNT"));
				noticeDetail.setCreatedDate(rset.getDate("CREATED_DATE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return noticeDetail;
	}

	public int incrementNoticeCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementNoticeCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

	public int updateNotice(Connection con, NoticeDTO changeContent) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeContent.getTitle());
			pstmt.setString(2, changeContent.getBody());
			pstmt.setInt(3, changeContent.getNo());
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection con, NoticeDTO deleteNotice) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, deleteNotice.getNo());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		
		return result;
	}

	public int selectTotalCount(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = prop.getProperty("selectTotalCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
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

	public int searchNoticeCount(Connection con, String searchCondition, String searchValue) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = null;
		if("writer".equals(searchCondition)) {
			query = prop.getProperty("searchWriterCount");
		} else if("title".contentEquals(searchCondition)) {
			query = prop.getProperty("searchTitleCount");
		} else if("content".equals(searchCondition)) {
			query = prop.getProperty("searchContentCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return totalCount;
	}

	public List<NoticeDTO> searchNoticeList(Connection con, String searchCondition, String searchValue, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> noticeList = null;
		
		String query = null;
		
		if("writer".equals(searchCondition)) {
			query = prop.getProperty("searchWriterList");
		} else if("title".equals(searchCondition)) {
			query = prop.getProperty("searchTitleList");
		} else if("content".equals(searchCondition)) {
			query = prop.getProperty("searchContentList");
		}
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			noticeList = new ArrayList<>();
			
			while(rset.next()) {
				
				NoticeDTO notice = new NoticeDTO();
				notice.setWriter(new MemberDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_TITLE"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("NOTICE_WRITER_MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_COUNT"));
				notice.setCreatedDate(rset.getDate("CREATED_DATE"));
				notice.setStatus(rset.getString("NOTICE_STATUS"));
				
				noticeList.add(notice);
				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
				
		return noticeList;
	}
}
