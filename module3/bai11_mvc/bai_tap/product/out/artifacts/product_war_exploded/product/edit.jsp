<%--
  Created by IntelliJ IDEA.
  User: HADES
  Date: 5/10/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>
                Id:
            </td>
            <td>
                <input type="text" id="id" value="${requestScope["product"].getId()}">
            </td>
        </tr>
        <tr>
            <td>
                Name:
            </td>
            <td>
                <input type="text" id="name" value="${requestScope["product"].getName()}">
            </td>
        </tr>
        <tr>
            <td>
                Price:
            </td>
            <td>
                <input type="text" id="price" value="${requestScope["product"].getCost()}">
            </td>
        </tr>
        <tr>
            <td>
                Description:
            </td>
            <td>
                <input type="text" id="description" value="${requestScope["product"].getDescription()}">
            </td>
        </tr>
        <tr>
            <td>
                Supplier:
            </td>
            <td>
                <input type="text" id="supplier" value="${requestScope["product"].getSponsor()}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update product"></td>
        </tr>
    </table>
    <div>
        <p>
            <a href="/product">Back to product list</a>
        </p>
    </div>
</form>
</body>
</html>
