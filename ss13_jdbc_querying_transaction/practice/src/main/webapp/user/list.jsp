<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/29/2022
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Trang danh sách sản phẩm</h1>
<a href="/user?action=create">Thêm Mới</a>
<form class="d-flex justify-content-end " action="/user">
    <input type="text" name="countrySearch" placeholder="Nhập quốc gia">
    <input type="submit" name="action" value="search">
</form>
<p class="my-2"><a href="/user?action=sort">
    <button class="btn btn-sm btn-warning btn-sm">Sắp xếp theo tên</button>
</a></p>
<table class="table table-striped">
    <tr>
        <th>Họ Tên</th>
        <th>email</th>
        <th>Quốc gia</th>
        <th>sửa</th>
        <th>Xóa</th>
        <th>Thông tin sử dụng</th>
    </tr>
    <c:forEach var="user" items="${user}">
    <tr>
        <td>${user.getName()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getCountry()}</td>
        <td><a href="/user?action=edit&id=${user.getId()}">Sửa</a></td>
        <td><a href="/user?action=delete&id=${user.getId()}">Xóa</a></td>
        <td><a href="/user?action=view&id=${user.getId()}">Thông tin</a></td>

    </tr>
    </c:forEach>
</body>
</html>
