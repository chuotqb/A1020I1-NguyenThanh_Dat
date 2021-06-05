
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<div class="container-fluid " style="height: 500px">
    <div class="row">
        <div class="col-2 mt-4 ">
            <div class="row ">
                <div class="col-12 d-flex justify-content-center">
                    <a class="btn btn-success " href="/rent?action=create">Create New Rent</a>
                </div>
            </div>
        </div>
        <div class="col-10 mt-3">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Id Rent</th>
                    <th>Area</th>
                    <th>Status</th>
                    <th>Number Of Floor</th>
                    <th>Type Rent</th>
                    <th>Cost</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rent" items="${listRent}">
                    <tr>
                        <td><c:out value="${rent.idRent}"></c:out></td>
                        <td><c:out value="${rent.area}"></c:out></td>
                        <c:choose>
                            <c:when test="${rent.idStatus == 1}">
                                <td>Trống</td>
                            </c:when>
                            <c:when test="${rent.idStatus == 2}">
                                <td>Hạ Tầng</td>
                            </c:when>
                            <c:when test="${rent.idStatus == 3}">
                                <td>Đầy Đủ</td>
                            </c:when>
                        </c:choose>
                        <td><c:out value="${rent.numOfFloor}"></c:out></td>
                        <c:choose>
                            <c:when test="${rent.idType == 1}">
                                <td>Chia Sẻ</td>
                            </c:when>
                            <c:when test="${rent.idType == 2}">
                                <td>Trọn Gói</td>
                            </c:when>
                        </c:choose>
                        <td><c:out value="${rent.cost}"></c:out></td>
                        <td><c:out value="${rent.startDate}"></c:out></td>
                        <td><c:out value="${rent.endDate}"></c:out></td>

                        <td><a class="btn btn-danger" href="#" onclick="customerSetId('${rent.idRent}','${customer.name}')"
                               data-toggle="modal" data-target="#deleteModal">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

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
<form action="/rent" method="post" id="deleteRent">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="idRent" id="id">
</form>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function customerSetId(id, name) {
        document.getElementById("idRent").value = idRent;
        document.getElementById("modelId").value = "Do you want delete rent ";
    }
    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteRent").submit();
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
