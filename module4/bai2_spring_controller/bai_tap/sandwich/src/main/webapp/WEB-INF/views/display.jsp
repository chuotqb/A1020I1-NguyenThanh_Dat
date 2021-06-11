<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HTC
  Date: 6/11/2021
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<h1>Condiment List Order</h1>
<ul>
    <c:forEach items="${condimentArray}" var="condiment">
        <li><c:out value="${condiment}"/></li>
    </c:forEach>
</ul>
</body>
</html>
