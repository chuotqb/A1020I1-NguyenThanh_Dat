
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<%@include file="/template/header.jsp" %>
<div class="container-fluid " style="height: 500px">
    <div class="row">
        <div class="col-2 mt-4 ">
            <div class="row ">
                <div class="col-12 d-flex justify-content-center">
                    <a class="btn btn-success " href="/service?action=create">Create New Service</a>
                </div>
            </div>
        </div>
        <div class="col-10 mt-3">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name Services</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max People</th>
                    <th>Rent Type</th>
                    <th>Service Type</th>
                    <th>Standard Room</th>
                    <th>Description Other Convenience</th>
                    <th>Area Pool</th>
                    <th>Number Of Floor</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="services" items="${listServices}">
                    <tr>
                        <td><c:out value="${services.id}"></c:out></td>
                        <td><c:out value="${services.name}"></c:out></td>
                        <td><c:out value="${services.area}"></c:out></td>
                        <td><c:out value="${services.cost}"></c:out></td>
                        <td><c:out value="${services.maxPeople}"></c:out></td>
                        <c:choose>
                            <c:when test="${services.getIdRentType() == 1}">
                                <td>Hours</td>
                            </c:when>
                            <c:when test="${services.getIdRentType() == 2}">
                                <td>Day</td>
                            </c:when>
                            <c:when test="${services.getIdRentType() == 3}">
                                <td>Month</td>
                            </c:when>
                            <c:when test="${services.getIdRentType() == 4}">
                                <td>Year</td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${services.getIdTypeService() == 1}">
                                <td>Villa</td>
                            </c:when>
                            <c:when test="${services.getIdTypeService() == 2}">
                                <td>House</td>
                            </c:when>
                            <c:when test="${services.getIdTypeService() == 3}">
                                <td>Room</td>
                            </c:when>
                        </c:choose>
                        <td><c:out value="${services.standarRoom}"></c:out></td>
                        <td><c:out value="${services.descriptionOther}"></c:out></td>

                        <td><c:out value="${services.poolArea}"></c:out></td>
                        <td><c:out value="${services.numOfFloor}"></c:out></td>
                        <td>
                            <a href="/service?action=edit&id=${services.id}">Edit</a>
                        </td>
                        <td>
                            <a href="/service?action=delete&id=${services.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/template/footer.jsp" %>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 7
        } );
    } );
</script>
</body>
</html>
