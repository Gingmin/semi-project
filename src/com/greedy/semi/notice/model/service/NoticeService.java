package com.greedy.semi.notice.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.notice.model.dao.NoticeDAO;
import com.greedy.semi.notice.model.dto.BlackListDTO;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;



public class NoticeService {

	private final NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	public List<NoticeDTO> selectAllNoticeList(PageInfoDTO pageInfo) {

		Connection con = getConnection();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(con, pageInfo);
		System.out.println("셀렉트올노티스리스트");
		close(con);

		return noticeList;
	}

	public int insertNotice(NoticeDTO newNotice) {

		Connection con = getConnection();
		
		int result = noticeDAO.insertNotice(con, newNotice);
		
		if(result > 0) {
			commit(con);
			
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public NoticeDTO selectNoticeDetail(int no) {

		Connection con = getConnection();
		
		NoticeDTO noticeDetail = null;
		
		int result = noticeDAO.incrementNoticeCount(con, no);
		System.out.println("서비스리졀트 : " + result);
		if(result > 0) {
			noticeDetail = noticeDAO.selectAllNoticeDetail(con, no);
			
			if(noticeDetail != null) {
				commit(con);
			} else {
				rollback(con);
			} 
		} else {
			close(con);
		}
		
		return noticeDetail;
	}

	public int updateNotice(NoticeDTO changeContent) {

		Connection con = getConnection();
		
		int changeNotice = noticeDAO.updateNotice(con, changeContent);
		
		System.out.println("서비스 들렸냥 " + changeNotice);
		
		if( changeNotice > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return changeNotice;
	}

	public int deleteNotice(NoticeDTO deleteNotice) {

		Connection con = getConnection();
		
		int result = noticeDAO.deleteNotice(con, deleteNotice);
		
		
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int selectTotalCount() {

		Connection con = getConnection();
		
		int totalCount = noticeDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public int searchNoticeCount(String searchCondition, String searchValue) {
		
		Connection con = getConnection();
		
		int totalCount = noticeDAO.searchNoticeCount(con, searchCondition, searchValue);
				
		close(con);		
		
		return totalCount;
	}

	public List<NoticeDTO> searchNoticeList(String searchCondition, String searchValue, PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<NoticeDTO> noticeList = noticeDAO.searchNoticeList(con, searchCondition, searchValue, pageInfo);
		
		close(con);
		
		return noticeList;
	}

	public int insertReport(NoticeDTO reportNotice, BlackListDTO reportBlack) {
		
		Connection con = getConnection();
		
		
		int result = noticeDAO.insertReport(con, reportNotice);
		
		if(result > 0) {
			int blackList = noticeDAO.insertBlack(con, reportBlack);
			
			if(blackList > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		} 	
		return result;
	}

	public List<NoticeDTO> selectReportList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<NoticeDTO> reportList = noticeDAO.selectReportList(con, pageInfo);
		
		close(con);
		
		return reportList;
	}

	public List<NoticeDTO> searchReportList(String searchCondition, String searchValue, PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<NoticeDTO> reportList = noticeDAO.searchReportList(con, searchCondition, searchValue, pageInfo);
		
		close(con);
		
		return reportList;
		
	}

}


