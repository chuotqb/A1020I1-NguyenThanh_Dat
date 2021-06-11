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
    <title>$Title$</title>
  </head>
  <body>
  <h1>English-Vietnamese Dictionary</h1>
  <form method="post" action="/result">
    <label>
      <input type="search" name="keyword">
    </label>
    <input type="submit" value="Search">
  </form>
  <h1>${key} Meaning:</h1>
  <h1>${word}</h1>
    <h1>${msg}</h1>
  </body>
</html>
