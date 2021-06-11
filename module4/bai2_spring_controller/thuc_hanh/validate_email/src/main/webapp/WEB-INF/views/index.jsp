<%--
  Created by IntelliJ IDEA.
  User: HTC
  Date: 6/8/2021
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Email Validation</title>
  </head>
  <body>
  <h1>Email Validate</h1>
  <h3 style="color:red">${message}</h3>

  <form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
  </form>

  </body>
</html>
