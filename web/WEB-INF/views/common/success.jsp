<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }"
			
			let movePath;
			let message;
			
			switch(successCode) {
				case "insertMember" :
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					message = "회원 가입 성공!";
					break;
				case "updateMember" :
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					message = "회원 정보 수정 성공!";
					break;
				case "deleteMember" :
					movePath = "${ pageContext.servletContext.contextPath }";
					message = "회원 탈퇴 성공!";
					break;
				case "changePassword" :
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					message = "비밀번호 변경 성공! 다시 로그인 해주세요!";
					break;
				case "insertNotice" :
					movePath = "${ pageContext.servletContext.contextPath }/notice/notice";
					message = "공지사항이 등록 되었습니다.";
         			 break;
				case "updateNotice" :
					movePath = "${ pageContext.servletContext.contextPath }/notice/update?no=" + "${requestScope.no}";
					message = "공지사항이 수정 되었습니다.";
         			 break;
				case "deleteNotice" :
					movePath = "${ pageContext.servletContext.contextPath }/notice/notice";
					message = "공지사항이 삭제 되었습니다.";
         			 break;
				case "updateResetPassword" :
					movePath = "${ pageContext.servletContext.contextPath }/member/login";
					message = "비밀번호 변경 성공! 로그인 해주세요!";
					break;
				case "insertClass" :
					movePath = "${ pageContext.servletContext.contextPath }/trainer/page";
					message = "수업등록에 성공했습니다!";
					break;
				case "updateClass" :
					movePath = "${ pageContext.servletContext.contextPath }/trainer/page";
					message = "수업수정에 성공했습니다!";
					break;
				case "updateTrainer" :
					movePath = "${ pageContext.servletContext.contextPath }/member/trainerInfo";
					message = "트레이너 추가 정보 수정에 성공했습니다!";
					break;
			}
			
			alert(message);
			location.href = movePath;
		})();
	</script>
</body>
</html>