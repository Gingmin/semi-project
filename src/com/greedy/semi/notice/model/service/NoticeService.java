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
import com.greedy.semi.notice.model.dto.RPAttachmentDTO;



public class NoticeService {

	private final NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	public List<NoticeDTO> selectAllNoticeList(PageInfoDTO pageInfo) {

		Connection con = getConnection();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(con, pageInfo);
		
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
		
		int no = noticeDAO.selectNumber(con, reportBlack);
		
		System.out.println("노노노노노노" + no);
		if(result > 0) {
			int blackList = noticeDAO.insertBlack(con, reportBlack, no);
			
			int reNo = noticeDAO.insertReNo(con, reportBlack);
			
			System.out.println("reno" + reNo);
			
			List<RPAttachmentDTO> fileList = reportNotice.getAttachmentDTO();
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setReportNo(no);
			}
			
			int attachmetResult = 0;
			for(int i = 0; i < fileList.size(); i++) {
				attachmetResult += noticeDAO.insertAttachment(con, fileList.get(i) ,reNo);
			}
			
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

	public int selectReportCount() {
		
		Connection con = getConnection();
		
		int reportTotalCount = noticeDAO.selectReportCount(con);
		
		close(con);
		
				
		return reportTotalCount;
	}

	public int searchReportCount(String searchCondition, String searchValue) {

		Connection con = getConnection();
		
		int reportCount = noticeDAO.searchReportConunt(con, searchCondition, searchValue);
		
		close(con);
		
		return reportCount;
	}

	public NoticeDTO selectReportDetail(int no) {
	
		Connection con = getConnection();
		
		NoticeDTO reportDetail = null;
		
		int result = noticeDAO.incrementNoticeCount(con, no);
		
		System.out.println("서비스 디테일" + result);
		
		if(result > 0) {
			reportDetail = noticeDAO.selectReportDetail(con, no);
			System.out.println("리포트디텔" + reportDetail );
			if(reportDetail != null) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			close(con);
		}
		return reportDetail;
	}

}


