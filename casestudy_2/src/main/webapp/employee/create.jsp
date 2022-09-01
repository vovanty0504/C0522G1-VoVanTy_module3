<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/29/2022
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <title>Add new Customer</title>
    <style>
        a {
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="mx-5 px-5 pt-3">
    <h2 class="text-center fw-bold">Add new Employee</h2>

    <c:if test="${mess!=null}">
        <c:if test="${check==true}">
            <p class="text-center h5 mt-3"><span class="badge text-bg-success">${mess}</span></p>
        </c:if>

        <c:if test="${check==false}">
            <p class="text-center h5 mt-3"><span class="badge text-bg-danger">${mess}</span></p>
        </c:if>
    </c:if>

    <div class="d-flex justify-content-center">

        <form class="w-50 border border-info p-3" action="/employee?action=create" method="post">
            <div class="form-group">
                <label for="name" class="h6">Name:</label>
                <input type="text" id="name" class="form-control" placeholder="Input name" name="name">
            </div>

            <div class="mt-3 form-group">
                <label for="dateOfBirth" class="h6">Date of Birth:</label>
                <input type="date" id="dateOfBirth" class="form-control" name="dateOfBirth">
            </div>

            <div class="mt-3 form-group">
                <label for="idCard" class="h6">Id card:</label>
                <input type="number" id="idCard" class="form-control" placeholder="Input Id card" name="idCard">
            </div>

            <div class="mt-3 form-group">
                <label for="salary" class="h6">Salary:</label>
                <input type="text" id="salary" class="form-control" placeholder="Input Phone number" name="salary">
            </div>

            <div class="mt-3 form-group">
                <label for="phone" class="h6">Phone number:</label>
                <input type="text" id="phone" class="form-control" placeholder="Input Phone number" name="phone">
            </div>

            <div class="mt-3 form-group">
                <label for="email" class="h6">Email:</label>
                <input type="text" id="email" class="form-control" placeholder="Input Email" name="email">
            </div>

            <div class="mt-3 form-group">
                <label for="address" class="h6">Address:</label>
                <input type="text" id="address" class="form-control" placeholder="Input Address" name="address">
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="positionId">Position Name:</label>
                <div class="input-group">
                <select id="positionId" class="form-control" name="positionId">
                    <c:forEach var="position" items="${positionList}">
                        <option value="${position.positionId}">${position.positionName}</option>
                    </c:forEach>
                </select>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="educationDegreesId">Education Degrees Name:</label>
                <select id="educationDegreesId" class="form-control" name="educationDegreesId">
                    <c:forEach var="educationDegrees" items="${educationDegreeList}">
                        <option value="${educationDegrees.educationDegreeId}">${educationDegrees.educationDegreeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="divisionId">Division Name:</label>
                <select id="divisionId" class="form-control" name="divisionId">
                   <c:forEach var="division" items="${divisionList}">
                       <option value="${division.divisionId}">${division.divisionName}</option>
                   </c:forEach>
                </select>
            </div>

            <div class="mt-3 text-center">
                <button class="btn btn-info btn-sm">Save</button>
            </div>
        </form>
    </div>

    <p class="text-center">
        <a href="/employee"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to Employee list</a>
    </p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>