
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<for:form modelAttribute="sandwich" action="/create" method="post">
    <form:checkboxes path="condiment" items="${condimentArray}"></form:checkboxes>
    <button type="submit">Save</button>
</for:form>
</body>
</html>
