<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/semi/resources/css/classRegist.css">
	<link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<!-- 폰트어썸 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp" />
	<!-- 헤더끝 -->
	
	
	<!-- 수업등록 -->
	<br>
	<div class="container">
		<form action="" method="POST">
			<div class="class-regist">수업등록</div>
			<br>
			<div class="class-choice">
				<div class="class-select">클래스 종류 선택</div>
				<div class="class-name">클래스 이름</div>
			</div>
			<br>
			<input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off" name="ptclass">
			<label class="btn btn-outline-primary" for="btn-check-outlined">1:1 클래스</label>
			<input type="checkbox" class="btn-check" id="btn-check-outlined1" autocomplete="off" name="gruopclass">
			<label class="btn btn-outline-primary" for="btn-check-outlined1">그룹 클래스</label>
			<div class="mb-1">
				<input type="text" class="class-name-input" id="formGroupExampleInput" placeholder="클래스 이름을 입력해 주세요."
					name="classname">
			</div>
			<div class="category">카테고리</div>
			<br>
			<input type="checkbox" class="btn-check" id="btn-check-outlined2" autocomplete="off" name="health">
			<label class="btn btn-outline-primary" for="btn-check-outlined2">헬스</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">요가</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">명상</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">필라테스</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">댄스</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">줌바</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">체형교정</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">재활</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">러닝</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">복싱</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">GX</label>
			<input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
			<label class="btn btn-primary" for="btn-check-3">에어로빅</label>
			<div class="three">본인 수업을 소개할 문구 (3가지)</div>
			<div class="three-introduce">
				<input type="text" class="three-introduce" placeholder="ex)근력강화" name="force">
				<input type="text" class="three-introduce" placeholder="ex)자세교정" name="posture">
				<input type="text" class="three-introduce" placeholder="ex)근지구력" name="endurance">
			</div>
			<textarea id="form75" class="textarea-input" rows="10" placeholder="최대한 자세히" name="textarea"></textarea>


			<script>
				$(document).ready(function () {
					function readURL(input) {
						if (input.files && input.files[0]) {
							var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
							reader.onload = function (e) {
								//파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
								$('#blah').attr('src', e.target.result);
								//이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
								//(아래 코드에서 읽어들인 dataURL형식)
							}
							reader.readAsDataURL(input.files[0]);
							//File내용을 읽어 dataURL형식의 문자열로 저장
						}
					}//readURL()--

					//file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
					$("#imgInp").change(function () {

						readURL(this);
					});
				});
			</script>

			<div class="file-field">
				<div class="z-depth-1-half mb-4">
					<div id="image_container"></div>
				</div>
				<img class="small-image" id="blah"
					src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg" /><br />
				<input type='file' id="imgInp" multiple />
			</div>




			<div class="file-field">
				<div class="z-depth-1-half mb-4">
					<div id="image_container"></div>
				</div>
				<img class="small-image" id="blah"
					src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg" /><br />
				<input type='file' id="imgInp" multiple />
			</div>


			<div class="file-field">
				<div class="z-depth-1-half mb-4">
					<div id="image_container"></div>
				</div>
				<img class="small-image" id="blah"
					src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg" /><br />
				<input type='file' id="imgInp" multiple />
			</div>

			<div class="file-field">
				<div class="z-depth-1-half mb-4">
					<div id="image_container"></div>
				</div>
				<img class="small-image" id="blah"
					src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg" /><br />
				<input type='file' id="imgInp" multiple />
			</div>

			<div class="set">수업 시간 등록</div>
			<script>
				$(function () {
					$("#datepicker").datepicker();
				});
			</script>
			<div id="datepicker" ></div>
			<div class="md-form md-outline">
				<input type="time" id="time-picker" placeholder="Select time" name="time">
				<label for="time-picker">60분 단위로 설정</label>
			</div>
			<div class="regist-button1"><button type="submit" class="btn btn-dark" id="regist-button"
					data-toggle="modal" data-target="#myModal">개설하기</button>
			</div>
		</form>
		<!-- 팝업 부분 -->

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<i class="fas fa-dumbbell"></i>
					</div>
					<div class="modal-body">
						<div class="modal_text">결제가 완료 되었습니다.</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 팝업 끝 -->
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	
	
	<!-- 푸터 -->
	<jsp:include page="../common/footer.jsp" />
	<!-- 푸터끝 -->
</body>
</html>