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


public class ClassService {
	
	private final ClassDAO classDAO;
	
	public ClassService() {
		classDAO = new ClassDAO();
	}

	public int insertClass(ClassDTO classInsert) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		int classResult = classDAO.insertThumbnailContent(con, classInsert);
		
		int classNo = classDAO.selectThumbnailSequence(con);
		
		List<AttachmentDTO> fileList = classInsert.getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefClassNo(classNo);
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

}
