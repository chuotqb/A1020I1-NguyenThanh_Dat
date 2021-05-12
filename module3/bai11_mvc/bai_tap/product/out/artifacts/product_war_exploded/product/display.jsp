<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 , table,p, .controller  {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<div class="controller">
    <table border="1" style="width: 100%">
        <tr style="background-color: cadetblue">
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
            <td>Decription</td>
            <td>Supplier</td>
            <td>View By Id</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td>
                        ${product.getId()}
                </td>
                <td>
                        ${product.getName()}
                </td>
                <td>
                        ${product.getCost()}
                </td>
                <td>
                        ${product.getDescription()}
                </td>
                <td>
                        ${product.getSponsor()}
                </td>
                <td>
                    <a href="/product?action=viewByID&id=${product.getId()}">view</a>
                </td>
                <td>
                    <a href="/product?action=edit&id=${product.getId()}">edit</a>
                </td>
                <td>
                    <a href="/product?action=delete&id=${product.getId()}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="controller">
    <a href="/product?action=create">Creat new product</a>
</div>
<div class="controller">
    <a href="/product?action=findByName">Find product by name</a>
</div>


</form>
</body>
</html>
