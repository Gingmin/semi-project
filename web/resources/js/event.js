window.onload = function() {
	
	/* 로그인 */
	if(document.getElementById("loginPage")) {
		const $loginPage = document.getElementById("loginPage");
		$loginPage.onclick = function() {
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
	
	/* 회원탈퇴 */
	if(document.getElementById("memberDelete")) {
		const $memberDelete = document.getElementById("memberDelete");
		$memberDelete.onclick = function() {
			location.href = "/semi/member/delete";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}