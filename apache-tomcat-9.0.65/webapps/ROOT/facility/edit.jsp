<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/2/2022
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <title>Update Customer</title>
    <style>
        body {
            background-color: #B5C8FF;
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
<div class="mx-5 px-5 pt-3">
    <h2 class="text-center fw-bold">Update FACILITY</h2>

    <p class="text-center mt-3"><a href="/index.jsp"><i class="fa-solid fa-house-chimney h5 mx-1"></i> Back to HOME</a></p>

    <p class="text-center">
        <a href="/facility"><i class="fa-solid fa-backward"></i> Back to Customer list</a>
    </p>

    <c:if test="${mess!=null}">
        <c:if test="${check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-success alert-dismissible fade show w-50">
                    <strong>Congratulations!</strong> ${mess}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </c:if>

        <c:if test="${!check}">
            <div class="justify-content-center d-flex">
                <div class="alert alert-danger alert-dismissible fade show w-50">
                    <strong></strong> ${mess}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>
        </c:if>
    </c:if>


    <div class="d-flex justify-content-center">

        <form class="w-50 border border-2 border-success p-3 bg-warning rounded" method="post">
            <div class="form-group" hidden>
                <label class="h6">Customer:</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="id" value="${facilityList.facilityId}" readonly>
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>

            <div class="form-group">
                <label for="name" class="h6">Name:</label>
                <div class="input-group">
                    <input type="text" id="name" class="form-control" name="name" value="${facilityList.facilityName}">
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>
            area
            <div class="mt-3 form-group">
                <label for="area" class="h6">AREA:</label>
                <div class="input-group">
                    <input type="text" id="area" class="form-control" name="area"
                           value="${facilityList.facilityArea}">
                    <span class="input-group-text"><i class="fa-solid fa-id-card"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="cost" class="h6">Cost:</label>
                <div class="input-group">
                    <input type="text" id="cost" class="form-control" name="cost" value="${facilityList.facilityCost}">
                    <span class="input-group-text"><i class="fa-solid fa-square-phone"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="maxPeople" class="h6">maxPeople:</label>
                <div class="input-group">
                    <input type="text" id="maxPeople" class="form-control" name="maxPeople" value="${facilityList.facilityMaxPeople}">
                    <span class="input-group-text"><i class="fa-solid fa-envelope-circle-check"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="standardRoom" class="h6">standardRoom:</label>
                <div class="input-group">
                    <input type="text" id="standardRoom" class="form-control" name="standardRoom"
                           value="${facilityList.facilityStandardRoom}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="descriptionOC" class="h6">DescriptionOtherConvenience:</label>
                <div class="input-group">
                    <input type="text" id="descriptionOC" class="form-control" name="descriptionOC"
                           value="${facilityList.facilityDescriptionOtherConvenience}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="poolArea" class="h6">poolArea:</label>
                <div class="input-group">
                    <input type="text" id="poolArea" class="form-control" name="poolArea"
                           value="${facilityList.facilityPoolArea}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>


            <div class="mt-3 form-group">
                <label for="numberOfFloors" class="h6">numberOfFloors:</label>
                <div class="input-group">
                    <input type="text" id="numberOfFloors" class="form-control" name="numberOfFloors"
                           value="${facilityList.facilityNumberOfFloors}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label for="facilityFree" class="h6">facilityFree:</label>
                <div class="input-group">
                    <input type="text" id="facilityFree" class="form-control" name="facilityFree"
                           value="${facilityList.facilityFree}">
                    <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="rentTypeId">Rent Type:</label>
                <div class="input-group">
                    <select id="rentTypeId" class="form-control" name="rentTypeId">
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-text"><i class="fa-solid fa-ranking-star"></i></span>
                </div>
            </div>

            <div class="mt-3 form-group">
                <label class="h6" for="facilityTypeId">facility Type:</label>
                <div class="input-group">
                    <select id="facilityTypeId" class="form-control" name="facilityTypeId">
                        <c:forEach var="facilityType" items="${facilityTypeList}">
                            <option value="${facilityType.facilityTypeId}">${facilityType.facilityTypeName}</option>
                        </c:forEach>
                    </select>
                    <span class="input-group-text"><i class="fa-solid fa-ranking-star"></i></span>
                </div>
            </div>

            <div class="mt-3 text-center">
                <button class="btn btn-info btn-sm border border-2 border-success">
                    -- Save <i class="fa-solid fa-floppy-disk"></i> --
                </button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
