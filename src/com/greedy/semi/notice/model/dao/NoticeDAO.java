package com.greedy.semi.notice.model.dao;

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

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.BlackListDTO;
import com.greedy.semi.notice.model.dto.CategoryDTO;
import com.greedy.semi.notice.model.dto.NTAttachmentDTO;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;
import com.greedy.semi.notice.model.dto.ReportCategoryDTO;

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
				notice.setTitle(rset.getString("NOTICE_SUBJECT"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				notice.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
				notice.setStatus(rset.getString("NOTICE_STATUS"));
				
				
				noticeList.add(notice);
				System.out.println("셀렉트올노티스 리스트 DAO");
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
				noticeDetail.setCategory(new CategoryDTO());
				noticeDetail.setWriter(new MemberDTO());
				
				noticeDetail.setNo(rset.getInt("NOTICE_NO"));
				noticeDetail.setCategoryCode(rset.getString("NOTICE_CATEGORY_CODE"));
				noticeDetail.setTitle(rset.getString("NOTICE_SUBJECT"));
				noticeDetail.setBody(rset.getString("NOTICE_BODY"));
				noticeDetail.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				noticeDetail.getWriter().setName(rset.getString("MEMBER_NAME"));
				noticeDetail.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				noticeDetail.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
				
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
		} else if("content".contentEquals(searchCondition)) {
			query = prop.getProperty("searchContentCount");
		}
		System.out.println("수정여기는??" + query);
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
				notice.setTitle(rset.getString("NOTICE_SUBJECT"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				notice.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
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

	public int insertReport(Connection con, NoticeDTO reportNotice) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reportNotice.getTitle());
			pstmt.setString(2, reportNotice.getBody());
			pstmt.setInt(3, reportNotice.getWriterMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertBlack(Connection con, BlackListDTO reportBlack, int no) {
		
		PreparedStatement pstmt = null;
		int blackList = 0;
		
		String query = prop.getProperty("insertBlack");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, reportBlack.getMemberNo());
			pstmt.setString(3, reportBlack.getReportCode());
			
			
			blackList = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return blackList;
	}

	public List<NoticeDTO> selectReportList(Connection con, PageInfoDTO pageInfo) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> reportList = null;
		
		String query = prop.getProperty("selectReportList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pageInfo.getStartRow());
			pstmt.setInt(2, pageInfo.getEndRow());
			System.out.println(pstmt);
			rset = pstmt.executeQuery();
			
			reportList = new ArrayList<>();
			
			while(rset.next()) {
				NoticeDTO report = new NoticeDTO();
				report.setCategory(new CategoryDTO());
				report.setWriter(new MemberDTO());
				
				report.setNo(rset.getInt("NOTICE_NO"));
				report.setCategoryCode(rset.getString("NOTICE_CATEGORY_CODE"));
				report.setTitle(rset.getString("NOTICE_SUBJECT"));
				report.setBody(rset.getString("NOTICE_BODY"));
				report.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				report.getWriter().setName(rset.getString("MEMBER_NAME"));
				report.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				report.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
				
				reportList.add(report);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return reportList;
	}

	public List<NoticeDTO> searchReportList(Connection con, String searchCondition, String searchValue,	PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<NoticeDTO> reportList = null;
		
		String query = null;
		
		if("writer".equals(searchCondition)) {
			query = prop.getProperty("reportWriterList");
		} else if("title".equals(searchCondition)) {
			query = prop.getProperty("reportTitleList");
		} else if("content".equals(searchCondition)) {
			query = prop.getProperty("reportContentList");
		}
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, pageInfo.getStartRow());
			pstmt.setInt(3, pageInfo.getEndRow());
			
			rset = pstmt.executeQuery();
			
			reportList = new ArrayList<>();
			
			while(rset.next()) {
				
				NoticeDTO notice = new NoticeDTO();
				notice.setWriter(new MemberDTO());
				
				notice.setNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("NOTICE_SUBJECT"));
				notice.setBody(rset.getString("NOTICE_BODY"));
				notice.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				notice.getWriter().setName(rset.getString("MEMBER_NAME"));
				notice.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				notice.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
				notice.setStatus(rset.getString("NOTICE_STATUS"));
				
				reportList.add(notice);
				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
				
		return reportList;
	}

	public int selectReportCount(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int reportTotalCount = 0;
		
		String query = prop.getProperty("selectReportCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				reportTotalCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return reportTotalCount;
		
	}

	public int searchReportConunt(Connection con, String searchCondition, String searchValue) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int reportCount = 0;
		
		String query = null;
		
		if("writer".equals(searchCondition)) {
			query = prop.getProperty("reportWriterCount");
		} else if("title".contentEquals(searchCondition)) {
			query = prop.getProperty("reportTitleCount");
		} else if("content".equals(searchCondition)) {
			query = prop.getProperty("reportContentCount");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchValue);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reportCount = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return reportCount;
	}

	public NoticeDTO selectReportDetail(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		NoticeDTO reportDetail = null;
		
		String query = prop.getProperty("selectReportDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
					System.out.println("ㅇ재댜ㅓㄹㅈ대ㅑ러");
			if(rset.next()) {
				reportDetail = new NoticeDTO();				
				reportDetail.setWriter(new MemberDTO());
				reportDetail.setBlackListDTO(new BlackListDTO());
				reportDetail.setReportCategoryDTO(new ReportCategoryDTO());
				
				reportDetail.setNo(rset.getInt("NOTICE_NO"));
				reportDetail.setCategoryCode(rset.getString("NOTICE_CATEGORY_CODE"));
				reportDetail.setTitle(rset.getString("NOTICE_SUBJECT"));
				reportDetail.setBody(rset.getString("NOTICE_BODY"));
				reportDetail.setWriterMemberNo(rset.getInt("MEMBER_NO"));
				reportDetail.getWriter().setName(rset.getString("MEMBER_NAME"));
				reportDetail.setCount(rset.getInt("NOTICE_VIEW_COUNT"));
				reportDetail.getBlackListDTO().setReportNoticeNo(rset.getInt("REPORT_NOTICE_NO"));
				reportDetail.getReportCategoryDTO().setReportType(rset.getString("REPORT_TYPE"));
				reportDetail.setCreatedDate(rset.getDate("NOTICE_REGIST_DATE"));
				
				
				System.out.println("ㅁㄴㅇㄹㅈㄷㄹ" + reportDetail);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				
		
		return reportDetail;
	}

	public int selectNumber(Connection con, BlackListDTO reportBlack) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("selectNumber");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reportBlack.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("NOTICE_NO");
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return result;
	}

	public int insertAttachment(Connection con, NTAttachmentDTO ntAttachmentDTO) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ntAttachmentDTO.getNoticeNo());
			pstmt.setString(2, ntAttachmentDTO.getOriginalName());
			pstmt.setString(3, ntAttachmentDTO.getFileName());
			pstmt.setString(4, ntAttachmentDTO.getFilePath());
			pstmt.setString(5, ntAttachmentDTO.getThumbnailPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
}
