<%--
  Created by IntelliJ IDEA.
  User: hwije
  Date: 2024-03-11
  Time: 오후 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: auto;
            padding-top: 50px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>수정 페이지</h1>

    <form action="/modMember.do" method="post">
        <label for="id">아이디:</label> ${id} <br>
        <input type="hidden" id="id" name="id" value="${id}"> <br>

        <label for="pw">비밀번호:</label><br>
        <input type="text" id="pw" name="pw"><br>

        <label for="name">이름:</label><br>
        <input type="text" id="name" name="name"><br>

        <label for="email">이메일:</label><br>
        <input type="text" id="email" name="email"><br>

        <button type="submit">수정하기</button>
    </form>
</div>
</body>
</html>
