package com.greedy.semi.notice.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.notice.model.dao.NoticeDAO;
import com.greedy.semi.notice.model.dto.NoticeDTO;



public class NoticeService {

	private final NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	public List<NoticeDTO> selectAllNoticeList() {

		Connection con = getConnection();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(con);

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

	public int deleteNotice(NoticeDTO requestNotice) {

		Connection con = getConnection();
		
		int result = noticeDAO.deleteNotice(con, requestNotice);
		
		System.out.println("서비스는 ~~~ ");
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}


