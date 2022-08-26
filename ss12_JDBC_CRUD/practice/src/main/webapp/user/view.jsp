<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/26/2022
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Thông tin người dùng</h3>

<pre>Id:                <span>${user.getId()}</span></pre>
<pre>Tên người dùng:    <span>${user.getName()}</span></pre>
<pre>Email:             <span>${user.getEmail()}</span></pre>
<pre>Quốc gia:          <span>${user.getCountry()}</span></pre>

<a href="/user">< Quay lại trang Danh sách người dùng</a>
</body>
</html>
