package com.greedy.semi.member.model.dao;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.member.model.dto.CareerDTO;
import com.greedy.semi.member.model.dto.LcAttachmentDTO;
import com.greedy.semi.member.model.dto.LicenseDTO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.dto.TrainerInfoDTO;

public class MemberDAO {

	private final Properties prop;
	
	public MemberDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "member/member-mapper.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(Connection con, MemberDTO requestMember) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			pstmt.setString(2, requestMember.getPwd());
			pstmt.setString(3, requestMember.getName());
			pstmt.setString(4, requestMember.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectEncryptPwd(Connection con, MemberDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String encPwd = "";
		
		String query = prop.getProperty("selectEncryptPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				encPwd = rset.getString("MEMBER_PWD");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return encPwd;
	}

	public MemberDTO selectLoginMember(Connection con, MemberDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO loginMember = null;
		
		String query = prop.getProperty("selectLoginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				loginMember = new MemberDTO();
				loginMember.setNo(rset.getInt("MEMBER_NO"));
				loginMember.setEmail(rset.getString("EMAIL"));
				loginMember.setPwd(rset.getString("MEMBER_PWD"));
				loginMember.setName(rset.getString("MEMBER_NAME"));
				loginMember.setPhone(rset.getString("PHONE"));
				loginMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginMember.setModifiedDate(rset.getDate("MODIFIED_DATE"));
				loginMember.setBlackStatus(rset.getString("BLACK_STATUS"));
				loginMember.setRole(rset.getString("MEMBER_ROLE"));
				loginMember.setStatus(rset.getString("MEMBER_STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("로그인 정보 조회 성공");
		return loginMember;
	}

	public int updateMember(Connection con, MemberDTO changeInfo) {
		
		PreparedStatement pstmt = null; 
		
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, changeInfo.getPhone());
			pstmt.setString(2, changeInfo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection con, MemberDTO requestMember) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deletMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestMember.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePassword(Connection con, MemberDTO requestMember, String newPwd) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePassword");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setInt(2, requestMember.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<MemberDTO> selectMemberByName(Connection con, MemberDTO requestMember) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MemberDTO> memberListByName = null;
		
		String query = prop.getProperty("selectMemberByName");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getName());
			
			rset = pstmt.executeQuery();
			
			memberListByName = new ArrayList<>();
			
			while(rset.next()) {
				MemberDTO member = new MemberDTO();
				member.setEmail(rset.getString("EMAIL"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				memberListByName.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberListByName;
	}

	public List<MemberDTO> selectMemberByPhone(Connection con, MemberDTO requestMember) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MemberDTO> memberListByPhone = null;
		
		String query = prop.getProperty("selectMemberByPhone");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getPhone());
			
			rset = pstmt.executeQuery();
			
			memberListByPhone = new ArrayList<>();
			
			while(rset.next()) {
				MemberDTO member = new MemberDTO();
				member.setEmail(rset.getString("EMAIL"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				memberListByPhone.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberListByPhone;
	}

	public MemberDTO selectEmail(Connection con, String email) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO searchedEmail = null;
		
		String query = prop.getProperty("selectEmail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				searchedEmail = new MemberDTO();
				searchedEmail.setEmail(rset.getString("EMAIL"));
				searchedEmail.setName(rset.getString("MEMBER_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return searchedEmail;
	}

	public MemberDTO selectResetMember(Connection con, MemberDTO requestMember) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO resetMember = null;
		
		String query = prop.getProperty("selectResetMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getName());
			pstmt.setString(2, requestMember.getEmail());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				resetMember = new MemberDTO();
				resetMember.setNo(rset.getInt("MEMBER_NO"));
				resetMember.setPwd(rset.getString("MEMBER_PWD"));
				resetMember.setName(rset.getString("MEMBER_NAME"));
				resetMember.setEmail(rset.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return resetMember;
	}

	public int updateResetPassword(Connection con, MemberDTO updateResetMember) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateResetPassword");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, updateResetMember.getPwd());
			pstmt.setString(2, updateResetMember.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public String selectEmailList(Connection con, String email) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String selectEmail = "";
		
		String query = prop.getProperty("selectEmailList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectEmail = rset.getString("EMAIL");
			}
			System.out.println("dao selectEmail : " + selectEmail);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectEmail;
	}

	/* 여기부터 트레이너 */
	public int insertTrainer(Connection con, MemberDTO memberDTO) {
		
		PreparedStatement pstmt = null;
		
		int memberResult = 0;
		
		String query = prop.getProperty("insertTrainer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberDTO.getEmail());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getPhone());
			
			memberResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return memberResult;
	}

	public int selectTrainer(Connection con, MemberDTO memberDTO) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int selectedTrainerNo = 0;
		
		String query = prop.getProperty("selectTrainer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberDTO.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				selectedTrainerNo = rset.getInt("MEMBER_NO");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedTrainerNo;
	}

	public int insertInfoTrainer(Connection con, int selectedTrainerNo, TrainerInfoDTO trainerInfoDTO) {
		
		PreparedStatement pstmt = null;
		int trainerInfoResult = 0;
		
		String query = prop.getProperty("insertInfoTrainer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, selectedTrainerNo);
			pstmt.setString(2, trainerInfoDTO.getAccountNumber());
			pstmt.setString(3, trainerInfoDTO.getBankName());
			pstmt.setString(4, trainerInfoDTO.getAccountHolder());
			
			trainerInfoResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return trainerInfoResult;
	}

	public int insertCareer(Connection con, int selectedTrainerNo, CareerDTO careerDTO) {
		
		PreparedStatement pstmt = null;
		int careerResult = 0;
		
		String query = prop.getProperty("insertCareer");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, selectedTrainerNo);
			pstmt.setString(2, careerDTO.getPlaceWork());
			pstmt.setDate(3, careerDTO.getStartDate());
			pstmt.setDate(4, careerDTO.getEndDate());
			pstmt.setString(5, careerDTO.getEmpStatus());
			
			careerResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return careerResult;
	}

	public int insertLicense(Connection con, LicenseDTO licenseDTO) {
		
		PreparedStatement pstmt = null;
		int licenseResult = 0;
		
		String query = prop.getProperty("insertLicense");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, licenseDTO.getCode());
			pstmt.setString(2, licenseDTO.getName());
			pstmt.setString(3, licenseDTO.getInstitution());
			pstmt.setString(4, licenseDTO.getGrade());
			pstmt.setDate(5, licenseDTO.getIssueDate());
			pstmt.setDate(6, licenseDTO.getExpDate());
			
			licenseResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return licenseResult;
	}

	public int insertAttachment(Connection con, LcAttachmentDTO file) {
		
		PreparedStatement pstmt = null;
		int attachmentResult = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, file.getCode());
			pstmt.setString(2, file.getOriginalName());
			pstmt.setString(3, file.getFileName());
			pstmt.setString(4, file.getFilePath());
			pstmt.setString(5, file.getThumbnailPath());
			
			attachmentResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return attachmentResult;
	}

	public int insertTrainerLicense(Connection con, int selectedTrainerNo, String selectedLicense) {
		
		PreparedStatement pstmt = null;
		int trainerLicenseResult = 0;
		
		String query = prop.getProperty("insertTrainerLicense");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, selectedTrainerNo);
			pstmt.setString(2, selectedLicense);
			
			trainerLicenseResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return trainerLicenseResult;
	}
	/* 트레이너 끝 */

	public TrainerInfoDTO selectTrainerInfo(Connection con, int no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		TrainerInfoDTO trainer = null;
		
		String query = prop.getProperty("selectTrainerInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				trainer = new TrainerInfoDTO();
				trainer.setAccountNumber(rset.getString("ACCOUNT_NUMBER"));
				trainer.setBankName(rset.getString("BANK_NAME"));
				trainer.setAccountHolder(rset.getString("ACCOUNT_HOLDER"));
				trainer.setApprovalStatus(rset.getString("APPROVAL_STATUS"));
				trainer.setAverageScore(rset.getInt("AVERAGE_SCORE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return trainer;
	}

	public int updateTrainerInfo(Connection con, TrainerInfoDTO trainer) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateTrainerInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, trainer.getAccountNumber());
			pstmt.setString(2, trainer.getAccountHolder());
			pstmt.setString(3, trainer.getBankName());
			pstmt.setInt(4, trainer.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
