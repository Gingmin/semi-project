package com.greedy.semi.trainer.service;

import java.sql.Connection;

import com.greedy.semi.trainer.dao.ClassDAO;
import com.greedy.semi.trainer.dto.ClassDTO;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

public class ClassService {
	
	private final ClassDAO classDAO;
	
	public ClassService() {
		classDAO = new ClassDAO();
	}

	public int insertClass(ClassDTO classInsert) {

		Connection con = getConnection();
		
		int result = classDAO.insertClass(con, classInsert);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
