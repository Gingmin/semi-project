<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body onload="getConnection();">
	<div>
		<table>
			<tr>
				<td><label id="sender">보낸 사람 : </label></td>
			</tr>
		</table>
	</div>
	<div id="history">
	
	</div>
	<div id="inputArea" align="center">
		<label>내용</label>
		<input type="text" name="send" id="send">
		<button id="sendBtn" onclick="send2();">보내기</button>
	</div>
	<script>
		$(function(){
			$("#send").select();
		});
	</script>
	<script>
		$(function() {
			getConnection2();
		});
		
		function getConnection() {
			ws = new WebSocket("ws://localhost:8001" + '<%= request.getContextPath() %>/severStart');
			ws.onopen = function(event) {
				
			}
			
			ws.onmessage = function(event) {
				onmMessage(event);
			}
			
			ws.onerror = function(event) {
				onError(event);
			}
			
			ws.onclose = function(event) {
				onClose(event);
			}
		}
		
		function send(msg) {
			ws.send(msg);
		}
		
		function onMessage(event) {
			var serverMessage = event.data;
			
			$sender = $("#sender");
			
			$sender.html(severMessage);
		}
		
		function onError(event) {
			alert(event.data);
		}
		
		function onClose(event) {
			alert(event);
		}
		
		function getConnection2() {
			ws2 = new WebSocket("ws://localhost:8001" + "<%= request.getContextPath() %>/chatStart");
			
			ws2.open2 = function(event) {
				
			}
			
			ws2.onmessage = function(event) {
				onMessage2(event);
			}
			
			ws.onerror = function(event) {
				onError2(event);
			}
			
			ws2.onclose = function(event) {
				onClose2(event);
			}
		}
		
		function send2(msg) {
			var sendMsg = $("#send").val();
			ws2.send(sendMsg);
		}
		
		function onMessage2(event) {
			var msg = event.data;
			$("#sender").html(msg);
			$("#history").append("<span>" + msg + "</span>")
		}
		
		function onError2(event) {
			alert(event.data);
		}
		
		function onClose2(event) {
			alert(event);
		}
	</script>
</body>
</html>