package com.greedy.semi.admin.model.service;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.admin.model.dao.AdminDAO;
import com.greedy.semi.admin.model.dto.AmountDTO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

public class AdminService {
	
	private final AdminDAO adminDAO;
	
	public AdminService() {
		
		adminDAO = new AdminDAO();
	}

	public int selectTotalCount() {

		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> selectMemberList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> memberList = adminDAO.selectMemberList(con, pageInfo);

		close(con);
		
		return memberList;
	}

	public int searchMemberCount(MemberDTO searchMember, int ptAmount) {
		
		Connection con = getConnection();
		
		String name = searchMember.getName();
		int no = searchMember.getNo();
		String phone = searchMember.getPhone();
		
		System.out.println("searchMemberCount name : " + name);
		System.out.println("searchMemberCount no : " + no);
		System.out.println("searchMemberCount phone : " + phone);
		
		int totalCount = adminDAO.searchMemberCount(con, name, no, phone, ptAmount);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchMemberList(MemberDTO searchMember, int ptAmount, PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		String name = searchMember.getName();
		int no = searchMember.getNo();
		String phone = searchMember.getPhone();
		
		System.out.println("searchMemberList name : " + name);
		System.out.println("searchMemberList no : " + no);
		System.out.println("searchMemberList phone : " + phone);
		
		List<MemberDTO> memberList = adminDAO.searchMemberList(con, name, no, phone, ptAmount, pageInfo);
		
		close(con);
		
		return memberList;
	}

	public MemberDTO selectMemberDetail(int no) {

		Connection con = getConnection();
		
		/* 결제한 적 있는 회원인지부터 조회 */
		AmountDTO purchaseYN = adminDAO.selectPuchaseYN(con, no);
		int amount = purchaseYN.getAmount();
		java.sql.Date expDate = purchaseYN.getExpDate();
		
		System.out.println("amount : " + amount);
		System.out.println("expDate : " + expDate);
		
		MemberDTO memberDetail = null;
		int totalPrice = 0;
		
		/* 결제내역이 있을 때 전체 조회 */
		if(amount > 0 && expDate != null) {
			memberDetail = adminDAO.selectMemberDetail(con, no);
			/* 총 구매 금액 검색(SUM) */
			totalPrice = adminDAO.selectTotalPrice(con, no);
		} else {
			/* 결제 정보가 없으면 회원가입 내역만 조회 */
			memberDetail = adminDAO.selectMemberNoPurchase(con, no);
		}
		/* 구매했으면 구매 총액 OR 없으면 0*/
		memberDetail.getPurchaseProductDTO().setPrice(totalPrice);
		
		close(con);
		
		return memberDetail;
	}

	public List<MemberDTO> selectTrainerList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> trainerList = adminDAO.selectTrainerList(con, pageInfo);

		close(con);
		
		return trainerList;
	}

	public int selectTotalTrainerCount() {

		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalTrainerCount(con);
		
		close(con);
		
		return totalCount;
	}

	public int updateTrainerApproval(int updateTrainer) {

		Connection con = getConnection();
		
		int result = adminDAO.updateTrainerApproval(con, updateTrainer);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int selectTotalBlackCount() {

		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalBlackCount(con);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> selectBlackList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> blackList = adminDAO.selectBlackList(con, pageInfo);

		close(con);
		
		return blackList;
		
	}

	public List<MemberDTO> selectPurchaseMemberList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<MemberDTO> memberList = adminDAO.selectPurchaseMemberList(con, pageInfo);

		close(con);
		
		return memberList;
	}

}
