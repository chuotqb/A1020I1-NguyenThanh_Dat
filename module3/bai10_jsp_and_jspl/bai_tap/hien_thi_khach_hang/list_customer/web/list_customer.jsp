
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
</head>
<body>
    <h1>Danh sách khách hàng</h1>
    <table border="1">
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa Chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}" >
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.dayOfBirth}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td>
                    <img style="width: 50px; height: 50px" src="${customer.urlImage} " />
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
