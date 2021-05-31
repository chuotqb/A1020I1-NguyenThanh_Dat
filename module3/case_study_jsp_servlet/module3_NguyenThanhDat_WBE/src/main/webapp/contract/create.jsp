<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Contact Detail</title>
</head>
<body>
<center>
    <h2>
        <a href="?type=contact">List All Contact Detail</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h1>Add New Contract</h1>
            </caption>
            <tr>
                <th>Id:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Start Day:</th>
                <td>
                    <input type="date" name="startDate" id="startDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>End Day:</th>
                <td>
                    <input type="date" name="endDate" id="endDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Total Money:</th>
                <td>
                    <input type="date" name="totalMoney" id="totalMoney" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Deposit:</th>
                <td>
                    <input type="date" name="deposit" id="deposit" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Id Customer:</th>
                <td>
                    <select name="typeCustomer">
                        <c:forEach var="typeCustomer" items="${typeCustomerList}">
                            <option value="${typeCustomer.idTypeCustomer}">
                                <c:out value="${typeCustomer.nameTypeCustomer}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="dayOfBirth" id="dayOfBirth" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender">
                        <option value="1">Male</option>
                        <option value="0">Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Adress:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Creat"/>
                </td>
            </tr>
        </table>
    </form>
    <div class="notice">
        <c:if test='${requestScope["message"]!=null}'>
            <p class="message">${requestScope["message"]}</p>
        </c:if>
    </div>
</div>
</body>
</html>

