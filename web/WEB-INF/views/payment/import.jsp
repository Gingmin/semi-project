<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
   <script>
   
      /* $(".ticket_btn_detail").click(function()  */
         if("${ requestScope.productPrice }")   {
         var IMP = window.IMP; // 생략가능0
         IMP.init('imp69531077');
          let movePath = "";
         // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
         // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
         
         IMP.request_pay({
            pg : 'inicis', // version 1.1.0부터 지원.
            /*
            'kakao':카카오페이,
            html5_inicis':이니시스(웹표준결제)
            'nice':나이스페이
            'jtnet':제이티넷
            'uplus':LG유플러스
            'danal':다날
            'payco':페이코
            'syrup':시럽페이
            'paypal':페이팔
             */
            pay_method : 'card',
            /*
            'samsung':삼성페이,
            'card':신용카드,
            'trans':실시간계좌이체,
            'vbank':가상계좌,
            'phone':휴대폰소액결제
             */
            merchant_uid : 'merchant_' + new Date().getTime(),
            /*
            merchant_uid에 경우
            https://docs.iamport.kr/implementation/payment
            위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
            참고하세요.
            나중에 포스팅 해볼게요.
             */
            name : '주문명:HELLOPT결제',
            //결제창에서 보여질 이름
            amount : 15000,
            //가격
            buyer_email : "${ sessionScope.loginMember.email }",
            buyer_name : "${ sessionScope.loginMember.name }",
            buyer_phone : "${ sessionScope.loginMember.phone }",
         
            
         /*
         모바일 결제시,
         결제가 끝나고 랜딩되는 URL을 지정
         (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
          */
         }, function(rsp) {
            
            if(rsp.success) {
               
               $.ajax({
                  url : "${pageContext.servletContext.contextPath}/member/buy",
                  method : 'POST',
                  data : {
                     purchaseCode: rsp.imp_uid,
                     purchasePrice:  rsp.paid_amount,
                     purchasePermitNo: rsp.apply_num
                  },
                  
                  success : function(data, textStatus, xhr){
                     
                  var msg = '결제가 완료되었습니다.';
                  msg += ' 결제코드 : ' + rsp.imp_uid;
                  msg += ' 결제금액 : ' + rsp.paid_amount;
                  msg += ' 결제승인번호 : ' + rsp.apply_num;
                  alert(msg);
       			  location.href = "${pageContext.servletContext.contextPath}/member/list"; 
               
                  },
                  
                  error : function(xhr, status, error){}
                  
                  });
              
          } else {
              
              var msg = '결제에 실패하였습니다.';
              msg += '에러내용 : ' + rsp.error_msg;
              alert(msg);
              location.href = "${pageContext.servletContext.contextPath}/member/list"; 
          }
          
          
      });
         };
          </script>
</body>
</html>