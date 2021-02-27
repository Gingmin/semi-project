<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="/semi/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/semi/resources/css/classRegist.css">
<link rel="stylesheet" href="/semi/resources/css/index.css">
<script src="/semi/resources/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<!-- 헤더끝 -->

	<form action="${ pageContext.servletContext.contextPath }/class/insert" method="post" encType="multipart/form-data">
		
		<div class="container">
			<h1 align="center">수업등록</h1>
			<label class="regist_text">수업 이름 <span class="text_detail">*</span></label>
			<input type="text" name="className" class="input_detail">
			
			<label class="regist_text">수업 종류 선택 <span class="text_detail">*</span></label>
			<div class="row">
			
	    		<input type="checkbox" class="btn-check" id="btn-check-2-outlined" checked autocomplete="off" name="classKind" value="PT클래스">
				<label class="btn btn-outline-secondary" for="btn-check-2-outlined">1:1 PT</label><br>
	    		<input type="checkbox" class="btn-check" id="btn-check-3-outlined" name="classKind" value="그룹클래스">
				<label class="btn btn-outline-secondary" for="btn-check-3-outlined">Group 수업</label><br>
	    		
			</div>	
			
			
			<label class="regist_text">수업 카테고리<span class="text_detail">*</span></label>
			<div class="row">
				<input type="checkbox" class="btn-check" id="btn-check-4-outlined" name="category" value="헬스">
				<label class="btn btn-outline-secondary" for="btn-check-4-outlined">헬스</label><br>
				<input type="checkbox" class="btn-check" id="btn-check-5-outlined" disabled>
				<label class="btn btn-outline-secondary" for="btn-check-5-outlined">요가</label><br>
				<input type="checkbox" class="btn-check" id="btn-check-6-outlined" disabled>
				<label class="btn btn-outline-secondary" for="btn-check-6-outlined">필라테스</label><br>
			</div>
			
			<div>
				<label class="regist_text">
					수업을 소개할 문구<span class="text_detail">*</span>
				</label><br>
			<input type="text" name="intro" style="width: 550px"></div>
			
			<div><label class="regist_text">개설할 수업 소개<span class="text_detail">*</span></label><br>
			<textarea rows="10" cols="10" class="textarea" name="introduce"></textarea></div>
			
			<div><label class="regist_text">수업 소개에 사용 될 본인의 이미지를 등록해 주세요!<span class="text_detail">*</span></label><br>
			<div class="thumbnail-insert-area">
				<table>
					
					<tr>
						<td>
							<div class="content-img-area1" id="titleImgArea">
								<img id="titleImg" width="180" height="120">&nbsp;&nbsp;&nbsp;
							</div>
						</td>
						<td>
							<div class="content-img-area2" id="contentImgArea1">
								<img id="contentImg1" width="180" height="120">&nbsp;&nbsp;&nbsp;
							</div>
						</td>
						<td>
							<div class="content-img-area3" id="contentImgArea2">
								<img id="contentImg2" width="180" height="120">
							</div>
						</td>
					</tr>
				</table>
				<div class="thumbnail-file-area">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1)">
					<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this, 2)">
					<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this, 3)">
				</div>
			</div>
			
			<label class="regist_text">수업 가능 시간을 선택해 주세요<span class="text_detail">*</span></label>
			<div><input type="datetime-local" name="classDate"></div>
			<br>
			
			<div class="btn_area">
				<button type="submit" class="btn btn-default" id="classinsert">등록하기</button><br>
			</div>

   		 </div>
	</div>
	</form>
	
	<script>
		const $contentImgArea1 = document.getElementById("titleImgArea");
		const $contentImgArea2 = document.getElementById("contentImgArea1");
		const $contentImgArea3 = document.getElementById("contentImgArea2");
		
		$contentImgArea1.onclick = function() {
			document.getElementById("thumbnailImg1").click();
		}
		
		$contentImgArea2.onclick = function() {
			document.getElementById("thumbnailImg2").click();
		}
		
		$contentImgArea3.onclick = function() {
			document.getElementById("thumbnailImg3").click();
		}
		
		function loadImg(value, num) {
			if(value.files && value.files[0]) {
				const reader = new FileReader();
				
				reader.onload = function(e) {
					switch(num) {
					case 1 : 
						document.getElementById("titleImg").src = e.target.result;
						break;
					case 2 : 
						document.getElementById("contentImg1").src = e.target.result;
						break;
					case 3 : 
						document.getElementById("contentImg2").src = e.target.result;
						break;
					}
				}
				
				reader.readAsDataURL(value.files[0]);
			}
		}
	</script>



	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
	<!-- 푸터끝 -->
</body>
</html>