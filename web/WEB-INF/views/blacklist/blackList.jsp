<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="/semi/resources/css/blackList.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 헤더 끝 -->
	<div class="container">
      <div class="blackList_intro_area">
         <div class="row">
            <div class="blackList_intro_card">
               <div class="black_text1">
                	  트레이너 블랙리스트
               </div>
               <div class="black_text2">
                  <p>1. 무단으로 방송을 안할 경우</p>
                  <p>2. 공지시간을 지키지 않을 경우</p>
                  <p>3. 운동 방송중 음란행위, 비속어 등을 했을 경우</p>
                  <p>4. 사행성 및 금전 관련하여 신고가 확인 될 경우</p>
               </div>
               <div class="black_text3">
              	    이외의 신고 접수 건 및 명확한 위법 사항이 판단 될 경우 HelloPT에서 확인후 판단하여 블랙리스트에 등록될수 있음을 알립니다.
               </div>
               <div class="black_text4">
            	      이와 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
               </div>
            </div>
            <div class="blackList_intro_card">
               <div class="black_text1">
          		     회원 블랙리스트
               </div>
               <div class="black_text2">
                  <p>1. 운동 방송중 음란행위, 비속어 등을 했을 경우</p>
                  <p>2. 사행성 및 금전 관련하여 신고가 확인 될 경우</p>
                  <p>3. 운동 방송중 음란행위, 비속어 등을 했을 경우</p>
                  <p>4. 사행성 및 금전 관련하여 신고가 확인 될 경우</p>
               </div>
               <div class="black_text3">
        	          이외의 신고 접수 건 및 명확한 위법 사항이 판단 될 경우 HelloPT에서 확인후 판단하여 블랙리스트에 등록될수 있음을 알립니다.
               </div>
               <div class="black_text4">
        	          이와 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
               </div>
            </div>
         </div>
      </div>
      <div class="blackList_intro_area">
         <div class="row">
            <div class="blackList_intro_card">
               <div class="black_text1">
        	          트레이너 블랙리스트 대응
               </div>
               <div class="black_text2">
                  <p>1. 위와 같은 위법 행위 확인시 트레이너 관리팀에서 사실여부 확인</p>
                  <p>2. 사실여부가 확인된다면 경고 안내</p>
                  <p>3. 1~2회 경고시 이름에 빨간색 또는 오렌지레드로 표기됨</p>
                  <p>4. 3회 경고시 검은색으로 처리되며 해당 플렛폼 트레이너 자격 박탈됨 고지</p>
                  <p>5. 박탈 전까지의 매출이 있다면 정산</p>
               </div>               
               <div class="black_text4">
          	        이와 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
               </div>
            </div>
            <div class="blackList_intro_card">
               <div class="black_text1">
         	         회원 블랙리스트
               </div>
               <div class="black_text2">
                  <p>1. 고객 컴플레인시 친절하게 응대</p>
                  <p>2. 3회 이상 폭언및 욕설시 녹취도고있음 고지, 이후에도 계속 한다면 법적으로 고지후 끊어도 상관없음</p>
                  <p>3. 잦은 불만 및 욕설시 고객센터에서 알수있게 빨간색으로 주의고객 표기</p>
                  <p>4. 산정 기준에 명확한 위법 사항이 판단될 경우 블랙리스트로 지정되었음 고지</p>
                  <p>5. 블랙리스트로 지정되었을경우 헬로피티 이용불가 및 환불 규졍에따라 3개월이 지나지 안았을경우 부분환불, 3개월이지났을경우 환불 불가 고지</p>
               </div>
               
               <div class="black_text4">
              	    이와 관련하여 문의 사항이 있으시면 언제든지 헬로피티로 문의해 주시기 바랍니다.
               </div>
            </div>
         </div>
      </div>

      <div class="report_area">
         <table class="table_detail" border="1px">
            <tr>
               <th colspan="2" class="report_title">제목 : <input class="reportinput_detail" type="text" name=""></th>
            </tr>
            <tr>
               <td class="td_detail1">내용</td>
               <td><textarea class="textarea_detail"></textarea></td>
            </tr>
            <tr>
               <td class="td_detail2" colspan="2">
                 <label for="inputFile"> 파일 첨부 : </label><input type="file" id="inputFile" name="" >
               </td>
            </tr>
         </table>
      </div>
   </div>
	
	
	
	<!-- footer -->
	<jsp:include page="../common/footer.jsp"/>
	<!-- footer -->
</body>
</html>