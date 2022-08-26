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
<table>
    <tr>
        <td>Name</td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${product.getPrice()}</td>
    </tr>
    <tr>
        <td>Status:</td>
        <td>${product.getProductDescription()}</td>
    </tr>
    <tr>
        <td>Producer:</td>
        <td>${product.getProducer()}</td>
    </tr>
</table>
</table>
</body>
</html>
