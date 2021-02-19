<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">   
   
   <link rel="stylesheet" href="/semi/resources/css/index.css">
   <link rel="stylesheet" href="/semi/resources/css/notice_board.css">
   <link rel="stylesheet" href="/semi/resources/css/notice_question.css">

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


   <!-- Rock Salt font -->
   <link href="http://fonts.cdnfonts.com/css/rock-salt" rel="stylesheet">


   <title>HelloPT</title>



</head>
<body>
   <div id="wrap">
      <!-- 헤더 -->
      <jsp:include page="../common/header.jsp"/>
      <!-- 헤더 끝 -->
      <!-- 메인 배너 -->
      <div class="banner_area">
         <img class="banner_detail" src="/semi/resources/images/notice_banner.JPG">
      </div>
      <!-- 메인 배너 끝 -->
      <div class="container">
         <div class="notice_menu_area">
            <div class="row">
               <div class="menu_list col-sm-3">
                  <input type="button" class="list_detail " value="공지사항" id="noticeNotice">
               </div>
               <div class="menu_list col-sm-3">
                  <input type="button" class="list_detail" value="리뷰" id="noticeReview">
               </div>
               <div class="menu_list col-sm-3">
                  <input type="button" class="list_detail" value="신고 내역" id="noticeReport">
               </div>
               <div class="menu_list col-sm-3">
                  <input type="button" class="list_detail on" value="자주 묻는 질문" id="noticeQuestion">
               </div>
            </div>
         </div>
         <div class="notice_name">
            자주 묻는 질문
         </div>
         <div class="line"></div>

         <div class="qna_list_area">
            <div class="q_text">계정 및 청구</div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">비밀번호 변경 또는 재설정</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo">자세히 보기 >></button>
                  <div id="demo" class="collapse">
                        비밀번호가 기억 나지 않는 경우 :
                                                      로그인 페이지 하단에서 "비밀번호 찾기"를 선택하십시오. 
                           HELLOPT에서 사용하던 이메일을 입력하고 "다음"을 선택하십시오.
                                                      사용하던 이메일의 등록된 이름과 이메일을 입력 후 인증번호받기를 클릭합니다. 
                                                      입력 된 이메일에서 전송 된 인증번호를 확인하십시오. 
                                                      새 비밀번호와 새 비밀번호 확인을 입력하고 확인을 선택합니다. 
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">멤버십 일시 중지</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo1">자세히 보기 >></button>
                  <div id="demo1" class="collapse">
                     귀하의 계정이 활성화되어있는 한 귀하의 멤버십을 일시 중지할 수 있습니다. 
                     멤버십을 일시 중지하려면 별도의 양식을 작성하여 제출해 주십시오 . 
                     일시 중지 된 기간이 만료되면 멤버십이 자동으로 복원됩니다. 
                     멤버십을 일시 중지하면 HELLOPT 콘텐츠에 대한 액세스도 일시 중지됩니다.
                  </div>   
               </div>
            </div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">계정 이메일 업데이트</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo2">자세히 보기 >></button>
                  <div id="demo2" class="collapse">
                     
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">결제 정보 업데이트</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo3">자세히 보기 >></button>
                  <div id="demo3" class="collapse">
                     
                  </div>   
               </div>
            </div>                        
         </div>
         <div class="qna_list_area">
            <div class="q_text">멤버십</div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">HELLOPT 멤버십</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo4">자세히 보기 >></button>
                  <div id="demo4" class="collapse">
                  모든 HELLOPT 수업 및 개인 교육에 참여하려면 멤버십 구매가 필요합니다.
                  멤버십 비용은 한 달에 최소 30,000원이며 무제한 수업에 참여 할 수 있으므로 온 가족이 함께 땀을 흘릴 수 있습니다! 
                  매주 새로운 Live 수업과 연중 무휴로 참여할 수있는 원하는 수업 중에서 선택하세요. 
                  수업에는 여러 운동 목록이 포함됩니다.(전체 목록은 운동 페이지 참조). 
                  또한, 지속적으로 제공하는 수업 유형을 확장하고 있습니다!
                  HELLOPT 올 액세스 멤버십은 결제되는 시점부터 시작되는 1 달 약정과 함께 제공됩니다.
                  이 기간이 지나면 월간 멤버십을 취소하거나 전환 할 수 있습니다. 
                  더 개인화 된 경험을 원한다면 약1시간 당 추가 최소 15,000원을 지불하고 1:1 PERSONAL TRAINING(PT)을 예약 할 수 있습니다.
                  전문가 피드백, 양식 수정 및 동기 부여를 실시간으로받을 수 있습니다. 
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">멤버십 활성화</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo5">자세히 보기 >></button>
                  <div id="demo5" class="collapse">
                  HELLOPT의 참여와 동시에 구독이 시작됩니다! 
                  자세한 내용은 멤버십 구매 페이지를 확인 하십시오.   
                  </div>   
               </div>
            </div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">멤버십 1개월/3개월/6개월 약정</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo6">자세히 보기 >></button>
                  <div id="demo6" class="collapse">
                  HELLOPT 멤버십은 결제부터 시작되는 1개월/3개월/6개월 약정과 함께 제공됩니다. 
                  해당 기간이 지나면 월간 멤버십을 취소하거나 전환 할 수 있습니다. 
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">멤버십 약관</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo7">자세히 보기 >></button>
                  <div id="demo7" class="collapse">
                     멤버십 이용 약관은 홈페이지 하단 약관에서 확인하실 수 있습니다.
                  </div>   
               </div>
            </div>                        
         </div>
         <div class="qna_list_area">
            <div class="q_text">1:1 PERSONAL TRAINING(PT)</div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">개인 트레이닝 정보</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo8">자세히 보기 >></button>
                  <div id="demo8" class="collapse">
                      국내 최초 HELLOPT의 1:1 PT기술을 통해 집에서 국내 다수의 엘리트 트레이너를 만나 볼 수 있습니다. 
                      헬스장, 체육관에서의 개인 트레이너가 함께 하며 가르치는 것과 유사한 경험을 할 수 있습니다. 
                      그러나 비용은 훨씬 저렴하고 이용가능 합니다. 
                      헬스장, 체육관에서와 마찬가지로 본인만의 맞춤형 엘리트 피트니스 전문가는 실시간으로 전문가 피드백, 자세 수정 및 격려를 제공합니다. 
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">개인 트레이닝 예약</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo9">자세히 보기 >></button>
                  <div id="demo9" class="collapse">
                     HELLOPT 웹을 통해 개인 트레이닝 1:1PT를 예약 할 수 있습니다.
                     1 단계 : HELLOPT 웹창을 열고 클래스 탭으로 이동합니다.
                     2 단계 : 원하는 트레이너의 클래스를 선택합니다. 
                     3 단계 : 1:1수업의 날짜와 시간을 설정 후 예약신청 선택합니다.
                     4 단계 : 트레이너의 승인이 되면 원하시는 날짜와 시간에 1:1PT수업 예약이 완료됩니다.                     
                  </div>   
               </div>
            </div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">개인 트레이닝 비용</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo10">자세히 보기 >></button>
                  <div id="demo10" class="collapse">
                     HELLOPT 개인 트레이닝 비용은 월 회비와 별개로 약 1시간 당 15,000원입니다. 
                          이용권은 1회권/5회권/10회권 단위로 구매 가능합니다.
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">MIRROR 개인 트레이너</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo11">자세히 보기 >></button>
                  <div id="demo11" class="collapse">
                     HELLOPT 개인 트레이닝 1:1PT는 세계적 수준의 인증 된 강사 팀에 의해 진행됩니다. 
                     HELLOPT는 선호하는 운동 활동, 트레이너 동기 부여 스타일, PT시 필요운동시간 및 일정에 따라 회원과 완벽한 트레이너를 연결합니다. 
                     HELLOPT 트레이너는 각 회원의 목표, 선호도 및 기술 수준에 따라 지도합니다.
                  </div>   
               </div>
            </div>                        
         </div>
            <div class="qna_list_area">
            <div class="q_text">연락처, 마케팅 및 채용</div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">연락 정보</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo4">자세히 보기 >></button>
                  <div id="demo4" class="collapse">
                  질문, 제안 또는 불편 사항이 있습니까?
                  hellopthelp@gmail.com로 문의해주세요. 언제나 도와 드리겠습니다!
                  </div>   
               </div>
               <div class="question_list type">               
                  <div class="q_text1">마케팅 및 파트너십 문의</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo5">자세히 보기 >></button>
                  <div id="demo5" class="collapse">
                  HELLOPT에 관심을 가져 주셔서 감사합니다! 
                  파트너십 요청의 경우이 이메일로 귀하의 정보를 기입해주세요.
                  소셜 미디어, 인플루언서 요청의 경우 또한 귀하의 정보를 보내주세요.
                  귀하의 이메일을 관련 팀으로 전달하고 파트너십이 적합한 경우 직접 연락을 드릴 것입니다. 
                  그렇지 않은 경우 비즈니스가 성장함에 따라 미래를 위해 귀하의 정보를 원하시는 경우에 따라 파기/보관 할 것입니다.
                  </div>   
               </div>
            </div>
            <div class="row">
               <div class="question_list">               
                  <div class="q_text1">채용 문의</div>
                  <button type="button" class="btn_detail" data-toggle="collapse" data-target="#demo6">자세히 보기 >></button>
                  <div id="demo6" class="collapse">
                  HELLOPT에 관심을 가져 주셔서 감사합니다! 
                  채용 공고를 모두 보려면 관련 채용 공고 웹 사이트를 확인하십시오 . 
                  아직 신청하지 않았다면 온라인으로 지원할 것을 권장하며, 적합한 경우 채용 관리자가 연락을 드릴 것입니다.
                  </div>   
               </div>
            </div>                        
         </div>
         
         


         
   

      
   </div>
   <jsp:include page="../common/footer.jsp"/>
   
   </div>

      
</body>
</html>