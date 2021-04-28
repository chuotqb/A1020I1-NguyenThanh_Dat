<%--
  Created by IntelliJ IDEA.
  User: HADES
  Date: 4/28/2021
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    form input {
      margin:12px 0px;
    }
  </style>
  <body>
  <h2> Product Discount Calculator</h2>
  <form method="post" action="/costproduct">
    <label>Product Description: </label><br/>
    <input type="text" name="product_desc" placeholder="Description"/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="Price"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="discount" placeholder="Discount"/><br/>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>
  </form>
  <h2>Lượng chiết khấu: <%=request.getAttribute("amount")%><span> VNĐ</span></h2>
  <h2>Giá sau khi đã được chiết khấu: <%=request.getAttribute("result")%><span> VNĐ</span></h2>
  </body>
</html>
