
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customer">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>Type Customer:</th>
                <td>
                    <select  name="typeCustomer" id="typeCustomer" required>
                        <option value="1" id="Diamond">Diamond</option>
                        <option value="2" id="Platinium">Platinium</option>
                        <option value="3" id="Gold">Gold</option>
                        <option value="4" id="Silver">Silver</option>
                        <option value="5" id="Member">Member</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="dayOfBirth" size="15"
                           value="<c:out value='${customer.dayOfBirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                    <td>
                         <select  name="gender" id="gender" required>
                             <option value="0" id="Female">Female</option>
                             <option value="1" id="Male">Male</option>
                         </select>
                    </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${customer.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${customer.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.address}' />"
                    />
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
    function editSelectIdType(){
        <c:if test="${customer.getIdTypeCustomer() != null}">
        let id = ${customer.getIdTypeCustomer()};
        let str = "";
        switch (id) {
            case 1:
                str = "Diamond";
                break;
            case 2:
                str = "Platinium";
                break;
            case 3:
                str = "Gold";
                break;
            case 4:
                str = "Silver";
                break;
            case 5:
                str = "Member";
                break;
        }
        document.getElementById(str).selected = true;
        </c:if>
    }
    function editSelectGender(){
        <c:if test="${customer.getGender() != null}">
        let id = ${customer.getGender()};
        let str = "";
        switch (id) {
            case 1:
                str = "Male";
                break;
            case 2:
                str = "Female";
                break;
        }
        document.getElementById(str).selected = true;
        </c:if>
    }
    $(window).on('load', function() {
        editSelectIdType();
        editSelectGender();
    });
</script>
</body>
</html>
