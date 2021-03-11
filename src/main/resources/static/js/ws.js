var stompClient = null;

function connect() {
	var socket = new SockJS('/chat');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected: " + frame);
		stompClient.subscribe('/topic/messages',  function(messageOutput) {
        showMessageOutput(JSON.parse(messageOutput.body));
		});
	});
}

   function showMessageOutput(messageOutput) {
                var response = document.getElementById('response');
                var p = document.createElement('p');
                p.style.wordWrap = 'break-word';
                p.appendChild(document.createTextNode(messageOutput.text));
                response.appendChild(p);
            }

function disconnect(){
	stompClient.disconnect();
}

function sendMessage(){
	stompClient.send("/app/message", {}, JSON.stringify({'text': $("#message_input_value").val() }));
}