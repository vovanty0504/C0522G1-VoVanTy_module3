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
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
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
    <h2 class="text-center fw-bold">Employee LIST</h2>

    <nav class="navbar navbar-expand-lg pb-0 mb-0">
        <div class="container-fluid">
            <a href="/employee?action=create">
                <button class="btn btn-success btn-outline-secondary btn-sm">
                    <span class="fa-solid fa-person-circle-plus text-light h5 my-auto me-1"></span>
                    <span class="text-light"> Add new Employee</span>
                </button>
            </a>

            <form class="d-flex my-2" role="search" action="/employee">
                <input class="form-control me-2" type="text" placeholder="Input search Name" aria-label="Search"
                       name="nameSearch">

                <input class="form-control me-2" type="text" placeholder="Input search address" aria-label="Search"
                       name="addressSearch">


                <input class="form-control me-2" type="text" placeholder="Input search phone" aria-label="Search"
                       name="phoneSearch">

                <button class="btn btn-outline-success" type="submit" name="action" value="search">
                    <i class="fa-solid fa-magnifying-glass"></i></button>
            </form>
        </div>
    </nav>

    <table class="table table-striped table-bordered" id="customerTable">
        <thead>
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
        </thead>
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
                <td class="text-center"><a href="/employee?action=edit&id=${employees.employeeId}">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                </a></td>

                <td class="text-center">
                    <button onclick="deleteEmployee('${employees.employeeId}','${employees.employeeName}')"
                            type="button"
                            class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal">
                        <i class="fa-solid fa-trash-can"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <tbody></tbody>
    </table>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/employee">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input hidden name="id" id="idDelete">
                        <input hidden name="action" value="delete">
                        <span>Ban co muon xoa : </span>
                        <span style="color:red" id="nameDelete"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">delete</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<script>
    function deleteEmployee(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;
    }
</script>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#customerTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</div>

<a href="/index.jsp"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</body>
</html>
