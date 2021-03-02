const express = require('express');
//const http = require('http');
const https = require('https'); 
const app = express();
const server = https.createServer(app);
const fs = require('fs');
const io = require('socket.io')(server);

app.use(express.static('com'));

app.get('/', function(req, res){
	fs.readFile('../com/greedy/semi/admin/webRTC/index.html', (err, data) => {
		if(err) throw err;
		
		res.writeHead(200, {
			'Content-type' : 'text/html'
		})
		.write(data)
		.end();
	});
});

io.sockets.on('connection', function(socket){
	socket.on('newUserConnect', function(name){
		socket.name = name;
		
		var message = name + '님이 접속했습니다';
		
		io.sockets.emit('updateMessage', {
			name : 'SERVER',
			message : message
		});
	});
	
	socket.on('disconnect', function(){
		var message = socket.name + '님이 퇴장했습니다.';
		socket.broadcast.emit('updateMessage', {
			name : 'SERVER',
			message : message
		});
	});
	
	socket.on('sendMessage', function(data){
		data.name = socket.name;
	    io.sockets.emit('updateMessage', data);
	});
});

server.listen(3000, function(){
	console.log('서버 실행중....');
});