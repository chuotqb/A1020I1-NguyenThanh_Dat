<%--
  Created by IntelliJ IDEA.
  User: HADES
  Date: 5/13/2021
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table align="center">
        <tr>
            <td>Nhập vào đất nước muốn tìm kiếm</td>
            <td>
                <input name="nameCountry" type="text">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="tìm kiếm"></td>
        </tr>
    </table>
</form>
<div align="center">
    <h1>Thông tin khách hàng chi tiết</h1>
    <table>
        <tr>
            <td>
                Name:
            </td>
            <td>
                ${requestScope["user"].getName()}
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                ${requestScope["user"].getEmail()}
            </td>
        </tr>
        <tr>
            <td>
                Country:
            </td>
            <td>
                ${requestScope["user"].getCountry()}
            </td>
        </tr>
    </table>
    <div>
        <p>
            <a href="users?action=users">List All Users</a>
        </p>
    </div>
</div>
</body>
</html>
