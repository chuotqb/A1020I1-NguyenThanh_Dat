
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employee">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="dayOfBirth" size="15"
                           value="<c:out value='${employee.dayOfBirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${employee.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="<c:out value='${employee.salary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${employee.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${employee.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <select  name="idPosition" id="idPosition" required>
                        <option value="1" id="leTan">Lễ Tân</option>
                        <option value="2" id="phucVuPosition">Phục Vụ</option>
                        <option value="3" id="chuyenVien">Chuyên Viên</option>
                        <option value="4" id="giamSat">Giám Sát</option>
                        <option value="5" id="quanLyPosition">Quản Lý</option>
                        <option value="6" id="giamDoc">Giám Đốc</option>
                    </select>
                </td>
            </tr>
            <tr>
            <th>Education:</th>
            <td>
                <select  name="idEducation" id="idEducation" required>
                    <option value="1" id="trungCap">Trung Cấp</option>
                    <option value="2" id="caoDang">Cao Đẳng</option>
                    <option value="3" id="daiHoc">Đại Học</option>
                    <option value="4" id="sauDaiHoc">Sau Đại Học</option>
                </select>
            </td>
            </tr>
            <tr>
                <th>Division:</th>
                <td>
                    <select  name="idDivision" id="idDivision" required>
                        <option value="1" id="saleMarketing">Sale - Marketing</option>
                        <option value="2" id="hanhChinh">Hành Chính</option>
                        <option value="3" id="phucVuDivision">Phục vụ</option>
                        <option value="4" id="quanLyDivision">Quản lý</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script>
    function editSelectPosition(){
        <c:if test="${employee.getIdPosition() != null}">
        let id = ${employee.getIdPosition()};
        let str = "";
        switch (id) {
            case 1:
                str = "leTan";
                break;
            case 2:
                str = "phucVuPosition";
                break;
            case 3:
                str = "chuyenVien";
                break;
            case 4:
                str = "giamSat";
                break;
            case 5:
                str = "quanLyPosition";
                break;
            case 6:
                str = "quanLyPosition";
                break;
        }
        document.getElementById(str).selected = true;
        </c:if>
    }
    function editSelectEducation(){
        <c:if test="${employee.getIdEducation() != null}">
        let id = ${employee.getIdEducation()};
        let str = "";
        switch (id) {
            case 1:
                str = "trungCap";
                break;
            case 2:
                str = "caoDang";
                break;
            case 3:
                str = "daiHoc";
                break;
            case 4:
                str = "sauDaiHoc";
                break;
        }
        document.getElementById(str).selected = true;
        </c:if>
    }
    function editSelectDivision(){
        <c:if test="${employee.getIdDivision() != null}">
        let id = ${employee.getIdDivision()};
        let str = "";
        switch (id) {
            case 1:
                str = "saleMarketing";
                break;
            case 2:
                str = "hanhChinh";
                break;
            case 3:
                str = "phucVuDivision";
                break;
            case 4:
                str = "quanLyDivision";
                break;
        }
        document.getElementById(str).selected = true;
        </c:if>
    }
    $(window).on('load', function() {
        editSelectPosition();
        editSelectEducation();
        editSelectDivision();
    });
</script>
</body>
</html>
