package com.greedy.semi.trainer.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.trainer.dto.AttachmentDTO;
import com.greedy.semi.trainer.dto.ClassDTO;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

public class ClassDAO {
	
	private final Properties prop;
	
	public ClassDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "class/class-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertThumbnailContent(Connection con, ClassDTO classInsert) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertThumbnailContent");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, classInsert.getName());
			pstmt.setString(2, classInsert.getType());
			pstmt.setString(3, classInsert.getCategory());
			pstmt.setString(4, classInsert.getIntro());
			pstmt.setString(5, classInsert.getIntroduce());
			pstmt.setString(6, classInsert.getCreatedDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectThumbnailSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastClassNo = 0;
		
		String query = prop.getProperty("selectThumbnailSequence");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastClassNo = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastClassNo;
	}

	public int insertAttachment(Connection con, AttachmentDTO file) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String qeury = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setInt(1, file.getRefClassNo());
			pstmt.setString(2, file.getOriginalName());
			pstmt.setString(3, file.getSavedName());
			pstmt.setString(4, file.getSavePath());
			pstmt.setString(5, file.getFileType());
			pstmt.setString(6, file.getThumbnailPath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
