package com.greedy.semi.admin.model.service;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.admin.model.dao.AdminDAO;
import com.greedy.semi.admin.model.dto.AmountDTO;
import com.greedy.semi.admin.model.dto.ReceiptDTO;
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

		int amount = 0;
		java.sql.Date expDate = null;
		if(purchaseYN != null) {
			
			amount = purchaseYN.getAmount();
			expDate = purchaseYN.getExpDate();
		}
		
		
		System.out.println("amount : " + amount);
		System.out.println("expDate : " + expDate);
		
		MemberDTO memberDetail = null;
		int totalPrice = 0;
		
		/* 결제내역이 있을 때 전체 조회 */
		if(amount > 0 || expDate != null) {
			memberDetail = adminDAO.selectMemberDetail(con, no);
			/* 총 구매 금액 검색(SUM) */
			totalPrice = adminDAO.selectTotalPrice(con, no);
			System.out.println("memberDetail : " + memberDetail);
			System.out.println("totalPrice : " + totalPrice);
			System.out.println("결제내역조회 성공");
		} else {
			/* 결제 정보가 없으면 회원가입 내역만 조회 */
			memberDetail = adminDAO.selectMemberNoPurchase(con, no);
			System.out.println("회원가입 내역 조회 성공");
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

	public int searchTrainerCount(String searchCondition, String searchValue, String searchDate1, String searchDate2) {
		
		Connection con = getConnection();
		
		int totalCount = adminDAO.searchTrainerCount(con, searchCondition, searchValue, searchDate1, searchDate2);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchTrainerList(String searchCondition, String searchValue, PageInfoDTO pageInfo, String searchDate1, String searchDate2) {
		
		Connection con = getConnection();
		
		List<MemberDTO> trainerList = adminDAO.searchTrainerList(con, searchCondition, searchValue, pageInfo, searchDate1, searchDate2);
		
		close(con);
		
		return trainerList;
	}

	public MemberDTO selectTrainerDetail(int no) {
		
		Connection con = getConnection();
		
		/* 트레이너 상세는 경력, 자격증, 자격증코드, 썸네일 사진, 지금까지 정산받은 금액을 다 입력해야 하므로 정산 완료 후 작성 */
		
		MemberDTO trainerDetail = null;
		
		close(con);
		
		return trainerDetail;
	}

	public int searchBlackCount(String searchCondition, String searchValue, String searchDate1, String searchDate2) {
		
		Connection con = getConnection();
		
		int totalCount = adminDAO.searchBlackCount(con, searchCondition, searchValue, searchDate1, searchDate2);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchBlackList(String searchCondition, String searchValue, PageInfoDTO pageInfo,
			String searchDate1, String searchDate2) {
		
		Connection con = getConnection();
		
		List<MemberDTO> blackList = adminDAO.searchBlackList(con, searchCondition, searchValue, pageInfo, searchDate1, searchDate2);
		
		close(con);
		
		return blackList;
	}

	public MemberDTO selectBlackDetail(int no) {

		/* 관리자페이지에서는 신고한 회원이랑 같이 조회가 되야 하므로 다음에 작성 */
		return null;
	}

	public int selectTotalPurchaseCount() {
		
		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalPurchaseCount(con);
		
		close(con);
		
		return totalCount;
	}

	public int searchPurchaseTotalCount(String searchCondition, String searchValue, String searchDate1,
			String searchDate2) {

		Connection con = getConnection();
		
		int totalCount = adminDAO.searchPurchaseTotalCount(con, searchCondition, searchValue, searchDate1, searchDate2);
		
		close(con);
		
		return totalCount;
	}

	public List<MemberDTO> searchPurchaseMemberList(String searchCondition, String searchValue, PageInfoDTO pageInfo,
			String searchDate1, String searchDate2) {

		Connection con = getConnection();
		
		List<MemberDTO> memberList = adminDAO.searchPurchaseMemberList(con, searchCondition, searchValue, pageInfo, searchDate1, searchDate2);
		
		close(con);
		
		return memberList;
	}

	public int selectTotalCalCount() {
		
		Connection con = getConnection();
		
		int totalCount = adminDAO.selectTotalCalCount(con);
		
		close(con);
		
		return totalCount;
	
	}

	public List<ReceiptDTO> selectCalList(PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<ReceiptDTO> payList = adminDAO.selectCalList(con, pageInfo);

		
		
		close(con);
		
		return payList;
	}

	public int searchCalculateSearchCount(String memberNo, String name, String searchDate1, String searchDate2) {
	
		Connection con = getConnection();
		
		int totalCount = adminDAO.searchCalculateSearchCount(con, memberNo, name, searchDate1, searchDate2);
		
		close(con);
		
		return totalCount;
	}

	public List<ReceiptDTO> searchCalculateSearchList(String memberNo, String name, PageInfoDTO pageInfo,
			String searchDate1, String searchDate2) {

		Connection con = getConnection();
		
		List<ReceiptDTO> receiptList = adminDAO.searchCalculateSearchList(con, memberNo, name, pageInfo, searchDate1, searchDate2);
		
		close(con);
		
		return receiptList;
	}


	public int selectMembers() {
		
		Connection con = getConnection();
		
		int members = adminDAO.selectMembers(con);
		
		close(con);
		
		return members;
	}

	public int selectTrainers() {
		
		Connection con = getConnection();
		
		int trainers = adminDAO.selectTrainers(con);
		
		close(con);
		
		return trainers;
	}

	public int selectBlackLists() {

		Connection con = getConnection();
		
		int blackLists = adminDAO.selectBlackLists(con);
		
		close(con);
		
		return blackLists;
	}

	public int selectGroupPT() {

		Connection con = getConnection();
		
		int groupPT = adminDAO.selectGroupPT(con);
		
		close(con);
		
		return groupPT;
	}

	public int selectoneToOnePT() {

		Connection con = getConnection();
		
		int oneToOnePT = adminDAO.selectoneToOnePT(con);
		
		close(con);
		
		return oneToOnePT;
	}

	public int selectMembershipGroup() {

		Connection con = getConnection();
		
		int result = adminDAO.selectMembershipGroup(con);
		
		close(con);
		
		return result;
	}

	public int selectmembershiponeToOne() {

		Connection con = getConnection();
		
		int result = adminDAO.selectmembershiponeToOne(con);
		
		close(con);
		
		return result;
	}

	public List<ReceiptDTO> searchExcelList(String memberNo, String name, String searchDate1, String searchDate2) {

		Connection con = getConnection();
		
		List<ReceiptDTO> payList2 = adminDAO.searchExcelList(con, memberNo, name, searchDate1, searchDate2);
		
		close(con);
		
		return payList2;
		

	}

}
