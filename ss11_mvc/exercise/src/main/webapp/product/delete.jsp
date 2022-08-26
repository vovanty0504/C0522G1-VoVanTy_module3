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
</head>
<body>
<h1>xóa sản phẩm</h1>
<p>
    <a href="/Product">Trở về</a>
</p>
<form method="post">
    <h3>Bạn có muốn xóa không?</h3>
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>id</td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Tên sản phẩm</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Giá</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td>${requestScope["product"].getProductDescription()}</td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Xóa Sản phẩm"></td>
                <td>
                    <a href="/Product">Trở về</a>
                </td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
