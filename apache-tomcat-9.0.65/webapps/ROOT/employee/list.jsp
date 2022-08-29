<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/29/2022
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <title>Home</title>
    <style>
        table {
            border: solid 3px;
        }

        a {
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="p-3">
    <h2 class="text-center fw-bold">CUSTOMER LIST</h2>

    <a href="/customer?action=create">
        <button class="btn btn-success btn-sm my-2">
            <span class="fa-solid fa-person-circle-plus text-light h5 my-auto me-1"></span> Add new Customer</button>
    </a>

    <table class="table table-striped table-bordered">
        <tr class="text-center bg-info">
            <th>Number</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Id card</th>
            <th>Salary</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>

        <c:forEach varStatus="status" var="employees" items="${employeesList}">
            <tr>
                <td class="text-center">${status.count}</td>
                <td>${employees.employeeName}</td>
                <td class="text-center">${employees.employeeDateOfBirth}</td>
                <td class="text-center">${employees.employeeIdCard}</td>
                <td class="text-center">${employees.employeeSalary}</td>
                <td>${employees.employeePhoneNumber}</td>
                <td>${employees.employeeEmail}</td>
                <td>${employees.employeeAddress}</td>
                <c:forEach var="position" items="${positionList}">
                    <c:if test="${position.positionId == employees.positionId}">
                        <td class="text-center">${position.positionName}</td>
                    </c:if>
                </c:forEach>

                <c:forEach var="educationDegrees" items="${educationDegreesList}">
                    <c:if test="${educationDegrees.educationDegreeId == employees.educationDegreeId}">
                        <td class="text-center">${educationDegrees.educationDegreeName}</td>
                    </c:if>
                </c:forEach>

                <c:forEach var="division" items="${divisionList}">
                    <c:if test="${division.divisionId == employees.divisionId}">
                        <td class="text-center">${division.divisionName}</td>
                    </c:if>
                </c:forEach>
                <td class="text-center"><a href="/customer?action=edit&id=${user.getId()}">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                </a></td>
                <td class="text-center"><a href="/customer?action=delete&id=${user.getId()}">
                    <span class="fa-solid fa-person-circle-minus text-danger h4 m-auto"></span>
                </a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="/"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>

</body>
</html>
