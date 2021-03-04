package com.greedy.semi.member.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.semi.common.wrapper.TrainerEncryptRequestWrapper;
import com.greedy.semi.member.model.dao.MemberDAO;
import com.greedy.semi.member.model.dto.CareerDTO;
import com.greedy.semi.member.model.dto.LcAttachmentDTO;
import com.greedy.semi.member.model.dto.LicenseDTO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.dto.TrainerInfoDTO;

public class MemberService {

	private final MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public int registMember(MemberDTO requestMember) {
		
		Connection con = getConnection();
		
		int result = memberDAO.insertMember(con, requestMember);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public MemberDTO memberCheck(MemberDTO requestMember) {
		
		Connection con = getConnection();
		MemberDTO loginMember = null;
		
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			loginMember = memberDAO.selectLoginMember(con, requestMember);
		}
		
		close(con);
		
		return loginMember;
	}

	public MemberDTO updateMember(MemberDTO changeInfo) {
		
		Connection con = getConnection();
		
		MemberDTO changedMember = null;
		
		String encPwd = memberDAO.selectEncryptPwd(con, changeInfo);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(changeInfo.getPwd(), encPwd)) {
			
			int result = memberDAO.updateMember(con, changeInfo);
			
			changedMember = memberDAO.selectLoginMember(con, changeInfo);
			
			if(changedMember != null && result > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		
		close(con);
		
		return changedMember;
	}

	public int deleteMember(MemberDTO requestMember) {

		Connection con = getConnection();
		
		int result = 0;
		
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			result = memberDAO.deleteMember(con, requestMember);
		}
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int changePassword(MemberDTO requestMember, String newPwd) {

		Connection con = getConnection();
		
		int result = 0;
		
		String encPwd = memberDAO.selectEncryptPwd(con, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			
			result = memberDAO.updatePassword(con, requestMember, newPwd);
		}
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public MemberDTO selectFindEmail(MemberDTO requestMember) {
		
		Connection con = getConnection();
		
		MemberDTO responseMember  = memberDAO.selectMemberByName(con, requestMember);
		
		close(con);
				
		return responseMember;
		
		/*List<MemberDTO> memberListByPhone = new ArrayList<>();*/
		
		/* label :
		for(int i = 0; i < memberListByName.size(); i++) {
			for(int j = 0; j < memberListByPhone.size(); j++) {
				if(memberListByName.get(i).getEmail().equals(memberListByPhone.get(j).getEmail())) {
					System.out.println("조회 결과가 맞는다");
					System.out.println("i : " + i);
					System.out.println("j : " + j);
					System.out.println("memberListByName.get(i) : " + memberListByName.get(i));
					System.out.println("memberListByName.get(i).getEmail() : " + memberListByName.get(i).getEmail());
					System.out.println("memberListByName.get(i).getEnrollDate() : " + memberListByName.get(i).getEnrollDate());
					System.out.println("memberListByPhone.get(j) : " + memberListByPhone.get(j));
					System.out.println("memberListByPhone.get(j).getEmail() : " + memberListByPhone.get(j).getEmail());
					System.out.println("memberListByPhone.get(j).getEnrollDate() : " + memberListByPhone.get(j).getEnrollDate());
					responseMember.setEmail(memberListByName.get(i).getEmail());
					responseMember.setEnrollDate(memberListByName.get(i).getEnrollDate());
					break label;
				} else {
					System.out.println("null 값");
					responseMember = null;
				}
			
			}
		}
		
		System.out.println("service의 responseMember : " + responseMember);
		 */
	}

	public MemberDTO searchEmail(String email) {

		Connection con = getConnection();
		
		MemberDTO searchedEmail = memberDAO.selectEmail(con, email);
		
		close(con);
		
		return searchedEmail;
	}

	public MemberDTO selectResetMember(MemberDTO requestMember) {

		Connection con = getConnection();
		
		MemberDTO resetMember = memberDAO.selectResetMember(con, requestMember);
		
		close(con);
		
		return resetMember;
	}

	public MemberDTO updateResetPassword(MemberDTO updateResetMember) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		MemberDTO resetMember = new MemberDTO();
		
		result = memberDAO.updateResetPassword(con, updateResetMember);
		System.out.println("result : " + result);
		resetMember = memberDAO.selectLoginMember(con, updateResetMember);
		System.out.println("resetMember : " + resetMember);
		
		if(result > 0 && resetMember != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return resetMember;
		
	}

	public String selectEmailList(String email) {

		Connection con = getConnection();
		
		String result = "";
		
		String selectEmail = memberDAO.selectEmailList(con, email);
		System.out.println("selecteEmail : " + selectEmail);
		
		if(selectEmail != "") {
			result = "unable";
		} else {
			result = "able";
		}
		
		close(con);
		
		return result;
	}

	public int registTrainer(Map<String, Object> requestInfo) {

		Connection con = getConnection();
		
		int result = 0;
		
		/* 비밀번호 암호화 */
		String encPwd =  ((MemberDTO) requestInfo.get("requestMember")).getPwd();
		String traPwd = new TrainerEncryptRequestWrapper().getParameter(encPwd);
		((MemberDTO) requestInfo.get("requestMember")).setPwd(traPwd);
		
		System.out.println("((MemberDTO) requestInfo.get(\"requestMember\")) : " + ((MemberDTO) requestInfo.get("requestMember")));
		
		/* 1. 트레이너 정보 인서트 */
		int memberResult = memberDAO.insertTrainer(con, (MemberDTO) requestInfo.get("requestMember"));
		System.out.println("memberResult : " + memberResult);
		/* 2. 인서트 된 정보 조회 */
		int selectedTrainerNo = memberDAO.selectTrainer(con, (MemberDTO) requestInfo.get("requestMember"));
		System.out.println("selectedTrainerNo : " + selectedTrainerNo);
		/* 3. 회원번호로 트레이너 추가정보 인서트 */
		int trainerInfoResult = memberDAO.insertInfoTrainer(con, selectedTrainerNo, (TrainerInfoDTO) requestInfo.get("trainer"));
		System.out.println("trainerInfoResult : " + trainerInfoResult);
		/* 4. 회원번호로 트레이너 경력 인서트 */
		int careerResult = memberDAO.insertCareer(con, selectedTrainerNo, (CareerDTO) requestInfo.get("career"));
		System.out.println("careerResult : " + careerResult);
		/* 5. 자격증 인서트 */
		int licenseResult = memberDAO.insertLicense(con, (LicenseDTO) requestInfo.get("license"));
		System.out.println("licenseResult : " + licenseResult);
		/* 6. 첨부파일 인서트 */
		/* 첨부파일 리스트 가져오고 자격증 코드 통일 */
		String licenseCode = ((LicenseDTO) requestInfo.get("license")).getCode();
		System.out.println("licenseCode : " + licenseCode);
		List<LcAttachmentDTO> fileList = ((LicenseDTO) requestInfo.get("license")).getAttachmentList();
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setCode(licenseCode);
		}
		
		/* 인서트 */
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += memberDAO.insertAttachment(con, fileList.get(i));
		}
		System.out.println("attachmentResult : " +attachmentResult);
		
		/* 7. 자격증 코드와 트레이너 번호로 트레이너별자격증 테이블 인서트  */
		int trainerLicenseResult = memberDAO.insertTrainerLicense(con, selectedTrainerNo, licenseCode);
		System.out.println("trainerLicenseResult : " + trainerLicenseResult);
		
		if(memberResult > 0 && trainerInfoResult > 0 && careerResult > 0 && attachmentResult == fileList.size() && licenseResult > 0 && trainerLicenseResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		/* 다 성공하면 반환 */
		return result;
	}

	public TrainerInfoDTO selectTrainerInfo(int no) {
		
		Connection con = getConnection();
		
		TrainerInfoDTO trainerInfo = memberDAO.selectTrainerInfo(con, no);
		
		close(con);
		
		return trainerInfo;
	}

	public int updateTrainerInfo(TrainerInfoDTO trainer) {
		
		Connection con = getConnection();
		
		int result = memberDAO.updateTrainerInfo(con, trainer);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
