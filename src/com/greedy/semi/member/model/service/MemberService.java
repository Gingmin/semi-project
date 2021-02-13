package com.greedy.semi.member.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

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

}
