<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 폰트어썸 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

.video_area{ width: 100%; height: 1000px;  padding: 20px;}
.video_area .row{margin: 0; }
.video_area .row .video_outgoing{background-color: gray; width:80%; height:900px; float: left; box-shadow: 0 0 20px gray;}
.video_area .row .video_outgoing .testimg{width: 100%; height: 100%;}
.video_area .row .video_outgoing .video_icon{height: 50px; box-shadow: 0 0 20px gray; padding:13px;}
.video_area .row .video_outgoing .video_icon .fa-volume-mute{ font-size: 25px; padding-right: 15px;}
.video_area .row .video_outgoing .video_icon .fa-volume-up{ font-size: 25px; padding-right: 15px; }
.video_area .row .video_outgoing .video_icon .fa-camera{ font-size: 25px; padding-right: 15px;}
.video_area .row .video_outgoing .video_icon .fa-ban{ font-size: 25px; padding-right: 15px; } 
.video_area .row .video_outgoing .video_icon .fa-cog{ font-size: 25px; float: right;}


.video_area .row .chatting_area{float: left; box-shadow: 0 0 20px gray; width: 20%; height: 794px;}
.video_area .row .chatting_area .chatting_view{width: 100%; height: 794px;  outline: none;  border: 0;}

.video_area .row .chatting_area .chatting_input{width: 100%; height:150px;  box-shadow: 0 0 20px gray; padding: 10px; position: relative;}
.video_area .row .chatting_area .chatting_input .input_detail{width: 70%; height: 130px; box-shadow: 0 0 10px 5px darkgrey;  border: 0; outline: none;}

.video_area .row .chatting_area .chatting_input .chatting_btndetail{background-color: black; color: white; width: 28%; height: 50px;} 
.video_area .row .chatting_area .chatting_input .fa-smile{ position: absolute;  top: 15%;  right: 15%;  font-size: 25px;}

</style>
</head>
<body>
	
 <div class="video_area">
      <div class="row">
         <div class="video_outgoing">
            <img class="testimg" src="./img/testimg.JPG"> 
            <div class="video_icon">
               <i class="fas fa-volume-mute"></i>
               <i class="fas fa-volume-up"></i>
               <i class="fas fa-camera"></i>
               <i class="fas fa-ban"></i>
               <i class="fas fa-cog"></i>
            </div>           
         </div>   
         <div class="chatting_area">
            <textarea class="chatting_view" readonly></textarea>
            <div class="chatting_input">
               <input type="text" name="inputtext" class="input_detail">
               <i class="far fa-smile"></i>
               <button class="chatting_btndetail">보내기</button>
            </div>
         </div>
      </div>     
   </div>
</body>
</html>