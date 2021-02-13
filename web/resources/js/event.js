window.onload = function() {
	
	/* 메인으로 이동 */
	if(document.getElementById("moveMain")) {
		const $moveMain = document.getElementById("moveMain");
		$moveMain.onclick = function() {
			location.href = "/semi/";
		}
	}
	
	/* 로그인 */
	if(document.getElementById("loginPage")) {
		const $loginPage = document.getElementById("loginPage");
		$loginPage.onclick = function() {
			location.href = "/semi/member/login";
		}
	}
	if(document.getElementById("login")) {
		const $login = document.getElementById("login");
		$login.onclick = function() {
			location.href = "/semi/member/login";
		}
	}
	
	/* 취소(메인으로) */
	if(document.getElementById("cancel")) {
		const $cancel = document.getElementById("cancel");
		$cancel.onclick = function() {
			location.href = "/semi/";
		}
	}
	
	/* 회원가입 */
	if(document.getElementById("regist")) {
		const $regist = document.getElementById("regist");
		$regist.onclick = function() {
			location.href = "/semi/member/regist";
		}
	}
	
	/* 로그아웃 */
	if(document.getElementById("logout")) {
		const $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/semi/member/logout";
		}
	}
  
  	/* 회원정보페이지 */
	if(document.getElementById("memberInfo")) {
		const $memberInfo = document.getElementById("memberInfo");
		$memberInfo.onclick = function() {
			location.href = "/semi/member/update";
		}
	}
	
	/* 비밀번호 변경 */
	if(document.getElementById("passwordChange")) {
		const $passwordChange = document.getElementById("passwordChange");
		$passwordChange.onclick = function() {
			location.href = "/semi/member/passwordChange";
		}
	}
	
	/* 계정 찾기 */
	if(document.getElementById("FindEmail")) {
		const $FindEmail = document.getElementById("FindEmail");
		$FindEmail.onclick = function() {
			location.href = "/semi/member/findEmail";
		}
	}
	
	/* 비밀번호 찾기 */
	if(document.getElementById("resetPassword")) {
		const $resetPassword = document.getElementById("resetPassword");
		$resetPassword.onclick = function() {
			location.href = "/semi/member/resetPassword";
		}
	}
	
  

	/* 트레이너 마이 페이지*/
	if(document.getElementById("trainer")) {
		const $logout = document.getElementById("trainer");
		$logout.onclick = function() {
			location.href = "/semi/trainer/page";
		}
	}
	/* 클래스 개설하기 */
	if(document.getElementById("insert_class")) {
		const $logout = document.getElementById("insert_class");
		$logout.onclick = function() {
			location.href = "/semi/trainer/class";
		}
	}
	/* 매출 내역 */
	if(document.getElementById("sales-details")) {
		const $logout = document.getElementById("sales-details");
		$logout.onclick = function() {
			location.href = "/semi/trainer/sales_details";
		}
	}
	
	/* 회원 마이페이지 */
	if(document.getElementById("mypage")) {
		const $logout = document.getElementById("mypage");
		$logout.onclick = function() {
			location.href = "/semi/member/mypage";
		}
	}
  
	/* 무제한 클래스 참여하기*/
	if(document.getElementById("participation")) {
		const $logout = document.getElementById("participation");
		$logout.onclick = function() {
			location.href = "/semi/class/list";
		}
	}

	
	//완규 영역	
	
	/*이용 약관*/
	if(document.getElementById("terms")){
		const $termspage = document.getElementById("terms");
		$termspage.onclick = function() {
			location.href = "/semi/terms/service";
			console.log($termspage);
		}
	}
	
	/*개인정보 처리방침*/
	if(document.getElementById("privacy")){
		const $privacypage = document.getElementById("privacy");
		$privacypage.onclick = function() {
			location.href = "/semi/privacy/policy";
			console.log($termspage);
		}
	}
	
	/*메인 헤더 게시판 클릭시 (첫화면은 공지사항)*/
	if(document.getElementById("noticePage")){
		const $noticePage = document.getElementById("noticePage");
		$noticePage.onclick = function() {
			location.href = "/semi/notice/notice";
			console.log($termspage);
		}
	}
	/*게시판 공지사항 버튼 클릭시*/
	if(document.getElementById("noticeNotice")){
		const $noticeNotice = document.getElementById("noticeNotice");
		$noticeNotice.onclick = function() {
			location.href = "/semi/notice/notice";
			console.log($termspage);
		}
	}
	/*게시판 리뷰 버튼 클릭시*/
	if(document.getElementById("noticeReview")){
		const $noticeReview = document.getElementById("noticeReview");
		$noticeReview.onclick = function() {
			location.href = "/semi/notice/review";
			console.log($noticeReview);
		}
	}
	/*게시판 신고내역 버튼 클릭시*/
	if(document.getElementById("noticeReport")){
		const $noticeReport = document.getElementById("noticeReport");
		$noticeReport.onclick = function() {
			location.href = "/semi/notice/report";
			console.log($noticeReport);
		}
	}
	/*게시판 자주묻는 질문 클릭시*/
	if(document.getElementById("noticeQuestion")){
		const $noticeQuestion = document.getElementById("noticeQuestion");
		$noticeQuestion.onclick = function() {
			location.href = "/semi/notice/question";
			console.log($noticeQuestion);
		}
	}
	
	/* 메인상단 멤버십 버튼 클릭시 */
	if(document.getElementById("membership")){
		const $membership = document.getElementById("membership");
		$membership.onclick = function() {
			location.href = "/semi/member/buy";
			console.log($membership);
		}
	}
	
	/*멤버십 구매버튼 클릭시*/
	if(document.getElementsByClassName("ticket_btn_detail")){
		const $ticket = document.getElementsByClassName("ticket_btn_detail");
		$ticket.onclick = function() {
			location.href = "/semi/card/info";
			console.log($ticket);
		}
	}
	
	
	
	//완규 영역 끝
	
	
	
	
	
	
	
	
	
	
}