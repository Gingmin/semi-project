window.onload = function() {
	
	if(document.getElementById("loginPage")) {
		const $loginPage = document.getElementById("loginPage");
		$loginPage.onclick = function() {
			location.href = "/semi/member/login";
		}
	}
	
	if(document.getElementById("cancel")) {
		const $cancel = document.getElementById("cancel");
		$cancel.onclick = function() {
			location.href = "/semi/";
		}
	}
	
	if(document.getElementById("regist")) {
		const $regist = document.getElementById("regist");
		$regist.onclick = function() {
			location.href = "/semi/member/regist";
		}
	}
	
	if(document.getElementById("logout")) {
		const $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/semi/member/logout";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}