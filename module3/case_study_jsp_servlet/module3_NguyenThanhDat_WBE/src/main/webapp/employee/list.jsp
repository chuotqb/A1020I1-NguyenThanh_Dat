
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
                    <a class="btn btn-success " href="/employee?action=create">Create New Employee</a>
                </div>
            </div>
        </div>
        <div class="col-10 mt-3">
            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Day Of Birth</th>
                    <th>Id Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Education Degree</th>
                    <th>Division</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${listEmployee}">
                    <tr>
                        <td><c:out value="${employee.id}"></c:out></td>
                        <td><c:out value="${employee.name}"></c:out></td>
                        <td><c:out value="${employee.dayOfBirth}"></c:out></td>
                        <td><c:out value="${employee.idCard}"></c:out></td>
                        <td><c:out value="${employee.salary}"></c:out></td>
                        <td><c:out value="${employee.phone}"></c:out></td>
                        <td><c:out value="${employee.email}"></c:out></td>
                        <td><c:out value="${employee.address}"></c:out></td>
                        <c:choose>
                            <c:when test="${employee.idPosition == 1}">
                                <td>Lễ Tân</td>
                            </c:when>
                            <c:when test="${employee.idPosition == 2}">
                                <td>Phục Vụ</td>
                            </c:when>
                            <c:when test="${employee.idPosition == 3}">
                                <td>Chuyên Viên</td>
                            </c:when>
                            <c:when test="${employee.idPosition== 4}">
                                <td>Giám Sát</td>
                            </c:when>
                            <c:when test="${employee.idPosition== 5}">
                                <td>Quản lý</td>
                            </c:when>
                            <c:otherwise>
                                <td>Giám Đốc</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.idEducation == 1}">
                                <td>Trung Cấp</td>
                            </c:when>
                            <c:when test="${employee.idEducation == 2}">
                                <td>Cao Đẳng</td>
                            </c:when>
                            <c:when test="${employee.idEducation == 3}">
                                <td>Đại Học</td>
                            </c:when>
                            <c:otherwise>
                                <td>Sau Đại Học</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.idDivision == 1}">
                                <td>Sale - Marketing</td>
                            </c:when>
                            <c:when test="${employee.idDivision == 2}">
                                <td>Hành Chính</td>
                            </c:when>
                            <c:when test="${employee.idDivision == 3}">
                                <td>Phục Vụ</td>
                            </c:when>
                            <c:otherwise>
                                <td>Quản lý</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a class="btn btn-danger" href="/employee?action=edit&id=${employee.id}">Edit</a>
                        </td>
                        <td><a class="btn btn-danger" href="#" onclick="employeeSetId('${employee.id}','${employee.name}')"
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
<form action="/employee" method="post" id="deleteEmployee">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    function employeeSetId(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Do you want delete employee name: " + name;
    }
    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteEmployee").submit();
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

