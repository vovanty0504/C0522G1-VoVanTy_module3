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
<h1>Thêm mới</h1>
p>
<c:if test='${requestScope["mess"] != null}'>
    <span class="mess">${requestScope["mess"]}</span>
</c:if>
</p>
<p>
    <a href="/user">Trở về sản phẩm</a>
</p>
<form method="post">
    <fieldset>
        <legend>User</legend>
        <table>

            <tr>
                <td>Tên</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Quốc gia</td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Thêm mới"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
