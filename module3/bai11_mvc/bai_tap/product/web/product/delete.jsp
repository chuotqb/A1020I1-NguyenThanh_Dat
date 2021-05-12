<%--
  Created by IntelliJ IDEA.
  User: HADES
  Date: 5/10/2021
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>
                Id:
            </td>
            <td>
                <c:out value="${product.getId()}"></c:out>
            </td>
        </tr>
        <tr>
            <td>
                Name:
            </td>
            <td>
                <c:out value="${product.getName()}"></c:out>
            </td>
        </tr>
        <tr>
            <td>
                Price:
            </td>
            <td>
                <c:out value="${product.getCost()}"></c:out>
            </td>
        </tr>
        <tr>
            <td>
                Description:
            </td>
            <td>
                <c:out value="${product.getDescription()}"></c:out>
            </td>
        </tr>
        <tr>
            <td>
                Suppler:
            </td>
            <td>
                <c:out value="${product.getSponsor()}"></c:out>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete product"></td>
        </tr>
    </table>

</form>
<div>
    <p>
        <a href="/product">Back to product list</a>
    </p>
</div>
</body>
</html>
