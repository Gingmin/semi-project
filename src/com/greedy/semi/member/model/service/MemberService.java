package com.greedy.semi.member.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.semi.common.dto.AttachmentDTO;
import com.greedy.semi.member.model.dao.MemberDAO;
import com.greedy.semi.member.model.dto.CareerDTO;
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
		
		List<MemberDTO> memberListByName = new ArrayList<>();
		List<MemberDTO> memberListByPhone = new ArrayList<>();
		
		memberListByName = memberDAO.selectMemberByName(con, requestMember);
		memberListByPhone = memberDAO.selectMemberByPhone(con, requestMember);
		
		MemberDTO responseMember = new MemberDTO();
		String email = "";
		java.sql.Date enrollDate = null;
		
		for(int i = 0; i < memberListByName.size(); i++) {
			for(int j = 0; j < memberListByPhone.size(); j++) {
				if(memberListByName.get(i).getEmail().equals(memberListByPhone.get(j).getEmail())) {
					email = memberListByName.get(i).getEmail();
					enrollDate = memberListByName.get(i).getEnrollDate();
				} else {
					responseMember = null;
				}
			}
		}
		
		responseMember.setEmail(email);
		responseMember.setEnrollDate(enrollDate);
		
		close(con);
				
		return responseMember;
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
		
		/* 1. 트레이너 정보 인서트 */
		int memberResult = memberDAO.insertTrainer(con, (MemberDTO) requestInfo.get("requestMember"));
		/* 2. 인서트 된 정보 조회 */
		int selectedTrainerNo = memberDAO.selectMember(con, (MemberDTO) requestInfo.get("requestMember"));
		/* 3. 회원번호로 트레이너 추가정보 인서트 */
		int trainerInfoResult = memberDAO.insertInfoTrainer(con, selectedTrainerNo, (TrainerInfoDTO) requestInfo.get("trainer"));
		/* 4. 회원번호로 트레이너 경력 인서트 */
		int careerResult = memberDAO.insertCareer(con, selectedTrainerNo, (CareerDTO) requestInfo.get("career"));
		
		/* 첨부파일 리스트 가져오기 */
		List<AttachmentDTO> fileList = ((LicenseDTO) requestInfo.get("license")).getAttachmentList();
		
		/* 5. 첨부파일 인서트 */
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += memberDAO.insertAttachment(con, (LicenseDTO) requestInfo.get("license"));
		}
		/* 6. 인서트한 첨부파일 번호 조회 
		 * 첨부파일 인서트 개수만큼 조회하기 j+1해서 첫번째 행, 두번째 행 이런식으로 가져온 행을
		 * integer 리스트에 담는다.
		 * */
		List<Integer> selectedAttachmentNo = new ArrayList<>();
		for(int j = 0; j < fileList.size(); j++) {
			selectedAttachmentNo.add(memberDAO.selectAttachmentNo(con, j + 1));
		}
		/* 7. 자격증코드  테이블 인서트 */
		int licenseResult = memberDAO.insertLicense(con);
		/* 8. 자격증코드 조회 */
		String licenseCode = memberDAO.selectLicenseCode(con);
		
		/* 9. 첨부파일번호와 자격증코드로 첨부파일트레이너 관계 테이블 인서트 */
		int attachLiceseResult;
		for(int t = 0; t < selectedAttachmentNo.size(); t++) {
			attachLiceseResult = memberDAO.insertAttachLicense(con, selectedAttachmentNo.get(t), licenseCode);
		}
		/* 10. 자격증 코드와 트레이너 번호로 트레이너별자격증 테이블 인서트  */
		int trainerLicenseResult = memberDAO.insertTrainerLicense(con, licenseCode);
		
		if(memberResult > 0 && trainerInfoResult > 0 && careerResult > 0 && attachmentResult == fileList.size() && licenseResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		/* 다 성공하면 반환 */
		return result;
	}

}
