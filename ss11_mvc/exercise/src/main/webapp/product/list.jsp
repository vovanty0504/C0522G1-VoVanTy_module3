<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/25/2022
  Time: 9:32 AM
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
<a href="/Product?action=create">Thêm Mới</a>

<form class="d-flex justify-content-end">
    <input type="text" name="nameSearch" placeholder="Nhập tên">
    <input type="submit" name="action" value="search">
</form>
<table class="table table-striped">
    <tr>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả sản phầm</th>
        <th>Nhà sản xuất</th>
        <th>Sữa</th>
        <th>Xóa</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>
                <a href="/Product?action=view&id=${product.getId()}">${product.getName()}</a>
            </td>
            <td>${product.getPrice()}</td>
            <td>${product.getProductDescription()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/Product?action=edit&id=${product.getId()}">Sửa</a></td>
            <td><a href="/Product?action=delete&id=${product.getId()}">Xóa</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
