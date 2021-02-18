package com.greedy.semi.member.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greedy.semi.member.model.dao.MemberDAO;
import com.greedy.semi.member.model.dto.MemberDTO;

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

}
