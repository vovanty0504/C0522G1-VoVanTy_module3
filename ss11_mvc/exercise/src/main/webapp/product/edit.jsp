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
<h1>Sửa</h1>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="mess">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/Product">Trở Về</a>
</p>
<form method="post">
    <fieldset>
        <legend>Sản PHẩm</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="number" name="id" id="id" value="${product.getId()}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
            </tr>
            <tr>
                <td>Giá</td>
                <td><input type="text" name="price" id="price" value="${product.getPrice()}">></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" name="productDescription" id="productDescription"
                           value="${product.getProductDescription()}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" name="producer" id="producer" value="${product.getProducer()}">
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Thêm mới"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
