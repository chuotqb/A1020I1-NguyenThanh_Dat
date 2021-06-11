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
  <h1>Caculator</h1>
  <form action="/calculation" id="form">
    <input type="text" name="numberA">
    <input type="text" name="numberB">
    <div>
      <input type="submit" name="operator" value="Addition(+)" >
      <input type="submit" name="operator" value="Subtraction(-)" >
      <input type="submit" name="operator" value="Multiplication(X)" >
      <input type="submit" name="operator" value="Division(/)">
    </div>
  </form>
  <h1>Result: ${result}</h1>
<%--  <script>--%>
<%--    function submitForm(str) {--%>
<%--      document.getElementById("calculation").value=str;--%>
<%--      document.getElementById("form").submit();--%>
<%--    }--%>
<%--  </script>--%>
  </body>
</html>
