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
                <h1>Add New Customer</h1>
            </caption>
            <tr>
                <th>Id:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Type Customer:</th>
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
