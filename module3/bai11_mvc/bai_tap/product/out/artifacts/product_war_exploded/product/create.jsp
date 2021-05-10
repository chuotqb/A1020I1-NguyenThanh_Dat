<%--
  Created by IntelliJ IDEA.
  User: HADES
  Date: 5/10/2021
  Time: 10:51 AM
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
<h2>Create new product</h2>
<form method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td>
                <input type="text" name="id">
            </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <input type="text" name="price">
            </td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>
                <input type="text" name="description">
            </td>
        </tr>
        <tr>
            <td>Supllier:</td>
            <td>
                <input type="text" name="supplier">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create product"></td>
        </tr>
    </table>
</form>
<div class="notice">
    <c:if test='${requestScope["message"]!=null}'>
        <p class="message">${requestScope["message"]}</p>
    </c:if>
</div>
<div>
    <p>
        <a href="/product">Back to product list</a>
    </p>
</div>

</body>
</html>
