package com.greedy.semi.trainer.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;


import java.sql.Connection;
import java.util.List;

import com.greedy.semi.trainer.dao.ClassDAO;
import com.greedy.semi.trainer.dto.AttachmentDTO;
import com.greedy.semi.trainer.dto.ClassDTO;
import com.greedy.semi.trainer.dto.PtReservationDTO;



public class ClassService {
	
	private final ClassDAO classDAO;
	
	public ClassService() {
		classDAO = new ClassDAO();
	}

	public int insertClass(ClassDTO thumbnail) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		int classResult = classDAO.insertThumbnailContent(con, thumbnail);
		
		int classNo = classDAO.selectClassSequence(con);
		
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefClassNo(classNo);;
		}
		
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += classDAO.insertAttachment(con, fileList.get(i));
		}
		
		if(classResult > 0 && attachmentResult == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public List<ClassDTO> selectThumbnailList() {
		
		Connection con = getConnection();
		
		List<ClassDTO> thumbnailList = classDAO.selectThumbnailList(con);
		
		close(con);
		
		return thumbnailList;
	}

	public ClassDTO selectOneThumbnailClass(int no) {
		
		Connection con = getConnection();
		
		ClassDTO thumbnail = null;
		
		int result = classDAO.incrementClassCount(con, no);
		
		if(result > 0) {
			thumbnail = classDAO.selectOneThumbnailClass(con, no);
			
			if(thumbnail != null) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		
		return thumbnail;
	}

	public int updateClass(ClassDTO thumbnail) {
		
		Connection con = getConnection();
		
		int result = classDAO.updateClass(con, thumbnail);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ClassDTO selectTrainerInfo(int no) {
		
		Connection con = getConnection();
		
		ClassDTO trainer = null;
		
		int result = classDAO.incrementTrainerCount(con, no);
		
		if(result > 0) {
			trainer = classDAO.selectTrainerInfo(con, no);
			
			if(trainer != null) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {
			rollback(con);
		}
		
		close(con);
		
		return trainer;
	}

	public int reservationMember(PtReservationDTO reservationMember) {
		
		Connection con = getConnection();
		
		int result = classDAO.reservationMember(con, reservationMember);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public List<PtReservationDTO> selectReservationList(int no) {
		
		Connection con = getConnection();
		
		List<PtReservationDTO> reservationList = classDAO.selectReservationMember(con, no);
		
		close(con);
		
		return reservationList;
	}

	public List<PtReservationDTO> selectReservationTrainerList(int no) {
		Connection con = getConnection();
		
		List<PtReservationDTO> reservationList = classDAO.selectReservationTrainerList(con, no);
		
		close(con);
		
		return reservationList;
	}
	

//	public List<PtReservationDTO> selectReservationList(PtReservationDTO reservationMember) {
//		Connection con = getConnection();
//		
//
//		List<PtReservationDTO> reservationList = classDAO.selectReservationMember(con, reservationMember);
//	
//		close(con);
//		
//		return reservationList;
//	}


	

}
