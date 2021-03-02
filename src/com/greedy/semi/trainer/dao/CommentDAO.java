package com.greedy.semi.trainer.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.common.jdbc.JDBCTemplate;
import com.greedy.semi.trainer.dto.CommentDTO;

public class CommentDAO extends JDBCTemplate {
	
	private static CommentDAO _dao;
	private final Properties prop;
	
	public CommentDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "class/class-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static {
		_dao = new CommentDAO();
	}
	
	public static CommentDAO getDAO() {
		return _dao;
	}
	
	public int insertComment(CommentDTO comment) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		String query = prop.getProperty("insertComment");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, comment.getWriter());
			pstmt.setString(2, comment.getContent());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		
		return rows;
		
	}
	
	public int updateComment(CommentDTO comment) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		String query = prop.getProperty("updateComment");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, comment.getWriter());
			pstmt.setString(2, comment.getContent());
			pstmt.setInt(3, comment.getNo());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		
		return rows;
	}
	
	public int deleteComment(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		
		String query = prop.getProperty("deleteComment");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		
		return rows;
	}
	
	public CommentDTO selectComment(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CommentDTO comment = null;
		
		String query = prop.getProperty("selectComment");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				comment = new CommentDTO();
				comment.setNo(rset.getInt("COMMENT_NO"));
				comment.setWriter(rset.getString("COMMENT_WRITER"));
				comment.setContent(rset.getString("COMMENT_CONTENT"));
				comment.setWriteDate(rset.getString("COMMENT_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(rset);
			close(pstmt);
		}
		
		return comment;
	}
	
	public List<CommentDTO> selectCommentList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		String query = prop.getProperty("selectCommentList");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setNo(rset.getInt("COMMENT_NO"));
				comment.setWriter(rset.getString("COMMENT_WRITER"));
				comment.setContent(rset.getString("COMMENT_CONTENT"));
				comment.setWriteDate(rset.getString("COMMENT_DATE"));
				
				commentList.add(comment);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(rset);
			close(pstmt);
		}
		
		return commentList;
		
	}
}















