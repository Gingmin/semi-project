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
import com.greedy.semi.trainer.dto.PtReservationDTO;

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
			pstmt.setString(2, thumbnail.getKind());
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
			pstmt.setInt(7, file.getRefTrainerNo());
			
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
				
				thumbnailClass.setNo(rset.getInt("CLASS_NO"));
				thumbnailClass.setTrainerNo(rset.getInt("TRAINER_NO"));
				thumbnailClass.setName(rset.getString("CLASS_NAME"));
				thumbnailClass.setKind(rset.getString("CLASS_KIND"));
				thumbnailClass.setCategory(rset.getString("CLASS_CATEGORY"));
				thumbnailClass.setIntro(rset.getString("CLASS_INTRO"));
				thumbnailClass.setIntroduce(rset.getString("CLASS_INTRODUCE"));
				thumbnailClass.setCreatedDate(rset.getString("CREATED_DATE"));
				thumbnailClass.setCount(rset.getInt("CLASS_COUNT"));
				thumbnailAttachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
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

	public int incrementClassCount(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementClassCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ClassDTO selectOneThumbnailClass(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ClassDTO thumbnail = null;
		
		String qeury = prop.getProperty("selectOneThumbnailClass");
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			thumbnail = new ClassDTO();
			List<AttachmentDTO> attachmentList = new ArrayList<>();
			while(rset.next()) {
				
				AttachmentDTO attachment = new AttachmentDTO();
				
				thumbnail.setNo(rset.getInt("CLASS_NO"));
				thumbnail.setTrainerNo(rset.getInt("TRAINER_NO"));
				thumbnail.setName(rset.getString("CLASS_NAME"));
				thumbnail.setKind(rset.getString("CLASS_KIND"));
				thumbnail.setCategory(rset.getString("CLASS_CATEGORY"));
				thumbnail.setIntro(rset.getString("CLASS_INTRO"));
				thumbnail.setIntroduce(rset.getString("CLASS_INTRODUCE"));
				thumbnail.setCreatedDate(rset.getString("CREATED_DATE"));
				thumbnail.setCount(rset.getInt("CLASS_COUNT"));
				attachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
				attachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
				attachment.setSavedName(rset.getString("SAVED_NAME"));
				attachment.setSavePath(rset.getString("SAVE_PATH"));
				attachment.setFileType(rset.getString("FILE_TYPE"));
				attachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attachmentList.add(attachment);
			}
			
			thumbnail.setAttachmentList(attachmentList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return thumbnail;
	}

	public int selectClassNo(Connection con, ClassDTO thumbnail) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("selectClassNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, thumbnail.getTrainerNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateClass(Connection con, ClassDTO thumbnail) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateClass");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, thumbnail.getName());
			pstmt.setString(2, thumbnail.getKind());
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
	
	public int incrementTrainerCount(Connection con, int no) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("incrementTrainerCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ClassDTO selectTrainerInfo(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ClassDTO trainer = null;
		
		String query = prop.getProperty("selectTrainerInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				trainer = new ClassDTO();
				trainer.setMemberNo(new MemberDTO());
				List<AttachmentDTO> attachmentList = new ArrayList<>();
				AttachmentDTO thumbnailAttachment = new AttachmentDTO();
				
				trainer.setNo(rset.getInt("CLASS_NO"));
				trainer.setTrainerNo(rset.getInt("TRAINER_NO"));
				trainer.setName(rset.getString("CLASS_NAME"));
				trainer.setKind(rset.getString("CLASS_KIND"));
				trainer.setCategory(rset.getString("CLASS_CATEGORY"));
				trainer.setIntro(rset.getString("CLASS_INTRO"));
				trainer.setIntroduce(rset.getString("CLASS_INTRODUCE"));
				trainer.setCreatedDate(rset.getString("CREATED_DATE"));
				trainer.setCount(rset.getInt("CLASS_COUNT"));
				trainer.getMemberNo().setName(rset.getString("MEMBER_NAME"));
				thumbnailAttachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
				thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
				thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME"));
				thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attachmentList.add(thumbnailAttachment);
				
				trainer.setAttachmentList(attachmentList);
				
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return trainer;
	}

	public int reservationMember(Connection con, PtReservationDTO reservationMember) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("reservationMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reservationMember.getMemberNo());
			pstmt.setInt(2, reservationMember.getTrainerNo());
			pstmt.setInt(3, reservationMember.getClassNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<PtReservationDTO> selectReservationMember(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PtReservationDTO> reservationList = null;
		
		String query = prop.getProperty("selectReservationMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			reservationList = new ArrayList<>();
			if(rset.next()) {
				PtReservationDTO reservation = new PtReservationDTO();
				List<AttachmentDTO> attachmentList = new ArrayList<>();
				AttachmentDTO thumbnailAttachment = new AttachmentDTO();
				
				reservation.setPermitNo(rset.getInt("PERMIT_NO"));
				reservation.setTrainerNo(rset.getInt("TRAINER_NO"));
				reservation.setMemberNo(rset.getInt("MEMBER_NO"));
				reservation.setApplyDate(rset.getDate("APPLY_DATE"));
				reservation.setPermitYn(rset.getString("PERMIT_YN"));
				reservation.setClassNo(rset.getInt("CLASS_NO"));
				thumbnailAttachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
				thumbnailAttachment.setRefTrainerNo(rset.getInt("REF_CLASS_NO"));
				thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
				thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME"));
				thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attachmentList.add(thumbnailAttachment);
				reservation.setAttachmentList(attachmentList);
				
				reservationList.add(reservation);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationList;
	}

	public List<PtReservationDTO> selectReservationTrainerList(Connection con, int no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PtReservationDTO> reservationList = null;
		
		String query = prop.getProperty("selectReservationTrainerList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			reservationList = new ArrayList<>();
			if(rset.next()) {
				PtReservationDTO reservation = new PtReservationDTO();
				List<AttachmentDTO> attachmentList = new ArrayList<>();
				AttachmentDTO thumbnailAttachment = new AttachmentDTO();
				
				reservation.setPermitNo(rset.getInt("PERMIT_NO"));
				reservation.setTrainerNo(rset.getInt("TRAINER_NO"));
				reservation.setMemberNo(rset.getInt("MEMBER_NO"));
				reservation.setApplyDate(rset.getDate("APPLY_DATE"));
				reservation.setPermitYn(rset.getString("PERMIT_YN"));
				reservation.setClassNo(rset.getInt("CLASS_NO"));
				thumbnailAttachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
				thumbnailAttachment.setRefTrainerNo(rset.getInt("REF_CLASS_NO"));
				thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
				thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME"));
				thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
				
				attachmentList.add(thumbnailAttachment);
				reservation.setAttachmentList(attachmentList);
				
				reservationList.add(reservation);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationList;
	}
//	public List<PtReservationDTO> selectReservationMember(Connection con, PtReservationDTO reservationMember) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		List<PtReservationDTO> reservationList = null;
//		
//		String query = prop.getProperty("selectReservationMember");
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, reservationMember.getClassNo());
//			
//			rset = pstmt.executeQuery();
//			reservationList = new ArrayList<>();
//			System.out.println("다오 1" + reservationList);
//			if(rset.next()) {
//				PtReservationDTO reservation = new PtReservationDTO();
//				List<AttachmentDTO> attachmentList = new ArrayList<>();
//				AttachmentDTO thumbnailAttachment = new AttachmentDTO();
//				
//				reservation.setPermitNo(rset.getInt("PERMIT_NO"));
//				reservation.setTrainerNo(rset.getInt("TRAINER_NO"));
//				reservation.setMemberNo(rset.getInt("MEMBER_NO"));
//				reservation.setApplyDate(rset.getDate("APPLY_DATE"));
//				reservation.setPermitYn(rset.getString("PERMIT_YN"));
//				reservation.setClassNo(rset.getInt("CLASS_NO"));
//				thumbnailAttachment.setNo(rset.getInt("CLASS_ATTACHMENT_NO"));
//				thumbnailAttachment.setRefTrainerNo(rset.getInt("REF_CLASS_NO"));
//				thumbnailAttachment.setOriginalName(rset.getString("ORIGINAL_NAME"));
//				thumbnailAttachment.setSavedName(rset.getString("SAVED_NAME"));
//				thumbnailAttachment.setThumbnailPath(rset.getString("THUMBNAIL_PATH"));
//				
//				attachmentList.add(thumbnailAttachment);
//				reservation.setAttachmentList(attachmentList);
//				
//				reservationList.add(reservation);
//				System.out.println("다오 2" + reservationList);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return reservationList;
//	}

}













