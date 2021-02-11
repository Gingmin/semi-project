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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}