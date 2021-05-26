
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Type Customer</th>
                    <th>Name</th>
                    <th>Day Of Birth</th>
                    <th>Gender</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${listCustomer}">
                    <tr>
                        <td><c:out value="${customer.id}"></c:out></td>
                        <c:choose>
                            <c:when test="${customer.getIdTypeCustomer() == 1}">
                                <td>Diamond</td>
                            </c:when>
                            <c:when test="${customer.getIdTypeCustomer() == 2}">
                                <td>Platinium</td>
                            </c:when>
                            <c:when test="${customer.getIdTypeCustomer() == 3}">
                                <td>Gold</td>
                            </c:when>
                            <c:when test="${customer.getIdTypeCustomer() == 4}">
                                <td>Silver</td>
                            </c:when>
                            <c:otherwise>
                                <td>Member</td>
                            </c:otherwise>
                        </c:choose>
                        <td><c:out value="${customer.name}"></c:out></td>
                        <td><c:out value="${customer.dayOfBirth}"></c:out></td>
                        <c:if test = "${customer.getGender() == 1}">
                            <td>Male</td>
                        </c:if>
                        <c:if test = "${customer.getGender() == 0}">
                            <td>Female</td>
                        </c:if>
                        <td><c:out value="${customer.idCard}"></c:out></td>
                        <td><c:out value="${customer.phone}"></c:out></td>
                        <td><c:out value="${customer.email}"></c:out></td>
                        <td><c:out value="${customer.address}"></c:out></td>
                        <td>
                            <a href="/customer?action=edit&id=${customer.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
</html>
