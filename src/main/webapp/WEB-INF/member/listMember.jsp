<%--
  Created by IntelliJ IDEA.
  User: hwije
  Date: 2024-03-08
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원리스트</title>
    <style>
        .buttonDiv {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            border-collapse: collapse;

            margin: auto; /* 가운데 정렬을 위해 margin을 auto로 설정합니다. */
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>회원 등록 가입</h1>

<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dtoList}" var="dto">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.pw}</td>
            <td>${dto.name}</td>
            <td>${dto.email}</td>
            <td>${dto.date}</td>
            <td><a href="/modMember.do?id=${dto.id}" class="button">수정</a></td>
            <td><a href="/delMember.do?id=${dto.id}" class="button">삭제</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="buttonDiv">
    <form action="/mem.do" method="post">
        <button type="submit" class="button">회원가입하기</button>
    </form>
</div>

</body>
</html>
