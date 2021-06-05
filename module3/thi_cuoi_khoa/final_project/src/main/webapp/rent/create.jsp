<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<center>
    <h2>
        <a href="?type=customer">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h1>Add New Rent</h1>
            </caption>
            <tr>
                <th>Id Rent:</th>
                <td>
                    <input type="text" name="idRent" id="idRent" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Rent Status:</th>
                <td>
                    <select name="idStatus">
                        <c:forEach var="idStatus" items="${listStatus}">
                            <option value="${idStatus.idStatus}">
                                <c:out value="${idStatus.nameStatus}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Number Of Floor:</th>
                <td>
                    <input type="text" name="numOfFloor" id="numOfFloor" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Type Rent:</th>
                <td>
                    <select name="idType">
                        <c:forEach var="idType" items="${listType}">
                            <option value="${idType.idType}">
                                <c:out value="${idType.nameType}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Start Date:</th>
                <td>
                    <input type="date" name="startDate" id="startDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>End Date:</th>
                <td>
                    <input type="date" name="endDate" id="endDate" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Creat"/>
                </td>
            </tr>
        </table>
    </form>
    <p>
        <c:if test='${messageidCard!= null}'>
            <span style="color: red" class="message">${messageidCard}</span>
        </c:if>
    </p>

    <p>
        <c:if test='${messagePhone!= null}'>
            <span style="color: red" class="message">${messagePhone}</span>
        </c:if>
    </p>
    <p>
        <c:if test='${messageEmail!= null}'>
            <span style="color: red" class="message">${messageEmail}</span>
        </c:if>
    </p>
</div>
</body>
</html>

