<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/29/2022
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h3>Xóa người dùng</h3>
<h4>Bạn có muốn xóa người dùng này?</h4>
<form method="post">
    <pre>Id:                <span>${user.getId()}</span></pre>
    <pre>Tên người dùng:    <span>${user.getName()}</span></pre>
    <pre>Email:             <span>${user.getEmail()}</span></pre>
    <pre>Mô tả:             <span>${user.getCountry()}</span></pre>
    <pre>                   <button style="background-color: #f14040">Xóa người dùng</button></pre>
</form>

<a href="/user">< Quay lại trang Danh sách người dùng</a>
</body>
</html>
