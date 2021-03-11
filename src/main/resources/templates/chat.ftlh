<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.springframework.org/schema/mvc">
<head>
    <meta charset="UTF-8">
    <title>chat</title>
    <link rel="stylesheet" href="/static/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
</head>
<#include "parts/navbar.ftlh">
<div class="container mt-5">

<body onload="connect()">

<div><h4>Список сообщений</h4></div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Введите сообщение" />
        <input type="text" name="tag" placeholder="Тэг">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" >Добавить</button>
    </form>
</div>


<div id="conversationDiv">
    <input id="message_input_value" class="message_input" placeholder="Type your message here..." />
    <button onclick="sendMessage()" class="text">Send</button>

</div>

    </div>
</div>

</div>
<form method="get" action="/main/chat">
    <div class="mt-2">
    <input type="text" name="filter" value="${filter?ifExists}" placeholder="Поиск по тегу">
    <button type="submit" class="btn btn-primary">Найти</button>
    </div>
<#list messages?sortBy("id")?reverse as message>
<div>
    <p id="response"></p>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>
    <div>
        <#if message.filename??>
        <img src="/img/${message.filename}">
    </#if>

</div>

</div>
<#else>
No message
</#list>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
<script src="/js/ws.js"></script>
</html>