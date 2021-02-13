package com.greedy.semi.trainer.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.greedy.semi.common.config.ConfigLocation;
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

	public int insertClass(Connection con, ClassDTO classInsert) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertClass");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, classInsert.getName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
