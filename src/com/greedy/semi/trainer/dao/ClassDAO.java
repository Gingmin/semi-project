package com.greedy.semi.trainer.dao;

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
import com.greedy.semi.trainer.dto.AttachmentDTO;
import com.greedy.semi.trainer.dto.ClassDTO;

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

	public int insertThumbnailContent(Connection con, ClassDTO thumbnail) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertThumbnailContent");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, thumbnail.getName());
			pstmt.setString(2, thumbnail.getType());
			pstmt.setString(3, thumbnail.getCategory());
			pstmt.setString(4, thumbnail.getIntro());
			pstmt.setString(5, thumbnail.getIntroduce());
			pstmt.setString(6, thumbnail.getCreatedDate());
			pstmt.setInt(7, thumbnail.getTrainerNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectClassSequence(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastClassNo = 0;
		
		String query = prop.getProperty("selectClassSequence");
		
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
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
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

	public List<ClassDTO> selectThumbnailList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<ClassDTO> thumbnailList = null;
		
		String query = prop.getProperty("selectThumbnailList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			thumbnailList = new ArrayList<>();
			
			while(rset.next()) {
				ClassDTO thumbnailClass = new ClassDTO();
				List<AttachmentDTO> attachmentList = new ArrayList<>();
				AttachmentDTO thumbnailAttachment = new AttachmentDTO();
				
				thumbnailClass.setName(rset.getString("CLASS_NAME"));
				thumbnailClass.setCreatedDate(rset.getString("CREATED_DATE"));
				thumbnailAttachment.setNo(rset.getInt("ATTACHMENT_NO"));
				thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
				thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME"));
				thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attachmentList.add(thumbnailAttachment);
				
				thumbnailClass.setAttachmentList(attachmentList);
				
				thumbnailList.add(thumbnailClass);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return thumbnailList;
	}

}













