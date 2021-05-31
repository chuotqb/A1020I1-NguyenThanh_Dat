
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
                    <a class="btn btn-success " href="/customer?action=create">Create New Customer</a>
                </div>
            </div>
        </div>
        <div class="col-10 mt-3">
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
                    <th>Delete</th>
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
                            <a class="btn btn-danger" href="/customer?action=edit&id=${customer.id}">Edit</a>
                        </td>
                        <td><a class="btn btn-danger" href="#" onclick="customerSetId('${customer.id}','${customer.name}')"
                               data-toggle="modal" data-target="#deleteModal">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/template/footer.jsp" %>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white; color: red">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>
<form action="/customer" method="post" id="deleteCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function customerSetId(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Do you want delete customer name: " + name;
    }
    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteCustomer").submit();
    }
</script>
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
