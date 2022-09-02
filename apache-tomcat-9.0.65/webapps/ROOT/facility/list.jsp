<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/2/2022
  Time: 11:06 AM
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
    <title>Title</title>
</head>
<body>
<div class="p-3">
    <h2 class="text-center fw-bold">FACILITY LIST</h2>

    <nav class="navbar navbar-expand-lg pb-0 mb-0">
        <div class="container-fluid">
            <a href="/facility?action=create">
                <button class="btn btn-success btn-outline-secondary btn-sm">
                    <span class="fa-solid fa-person-circle-plus text-light h5 my-auto me-1"></span>
                    <span class="text-light"> Add new Customer</span>
                </button>
            </a>

            <form class="d-flex my-2" role="search" action="/facility">
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
            <th>Area</th>
            <th>Cost</th>
            <th>Max People</th>
            <th>Standard Room</th>
            <th>Description Other Convenience</th>
            <th>Pool Area</th>
            <th>number Of Floors</th>
            <th>Facility Free</th>
            <th>Rent Type Name</th>
            <th>Facility Type Name</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="status" var="facility" items="${facilityList}">
            <tr>
                <td class="text-center">${status.count}</td>
                <td class="text-center">${facility.facilityName}</td>
                <td class="text-center">${facility.facilityArea}</td>
                <td class="text-center">${facility.facilityCost}</td>
                <td class="text-center">${facility.facilityMaxPeople}</td>
                <td class="text-center">${facility.facilityStandardRoom}</td>
                <td class="text-center">${facility.facilityDescriptionOtherConvenience}</td>
                <td class="text-center">${facility.facilityPoolArea}</td>
                <td class="text-center">${facility.facilityNumberOfFloors}</td>
                <td class="text-center">${facility.facilityFree}</td>
                <td class="text-center">
                <c:forEach var="rentType" items="${rentTypeList}">
                    <c:if test="${rentType.rentTypeId == facility.facilityId}">
                       ${rentType.rentTypeName}
                    </c:if>
                </c:forEach>
                </td>
                <td class="text-center">
                <c:forEach var="facilityType" items="${facilityTypeList}">
                    <c:if test="${facilityType.facilityTypeId == facility.facilityTypeId}">
                       ${facilityType.facilityTypeName}
                    </c:if>
                </c:forEach>
                </td>
                <td class="text-center"><a href="/facility?action=edit&id=${facility.facilityId}">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                </a></td>

                <td class="text-center">
                    <button onclick="deleteFacility('${facility.facilityId}','${facility.facilityName}')"
                            type="button"
                            class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal">
                        <i class="fa-solid fa-trash-can"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/facility">
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

    <script>
        function deleteFacility(id, name) {
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

    <a href="/index.jsp"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
