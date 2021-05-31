<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Service</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
</head>
<body>
<center>
    <h2>
        <a href="?type=service">List All Service</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">

            <tr>
                <th>Id:</th>
                <td>
                    <input type="text" name="id" id="id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Max People:</th>
                <td>
                    <input type="text" name="maxPeople" id="maxPeople" size="45"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Type Rent:</th>
                <td>
                    <select name="typeRent">
                        <c:forEach var="typeRent" items="${typeRentList}">
                            <option value="${typeRent.id}">
                                <c:out value="${typeRent.name}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Type Service:</th>
                <td>
                    <select name="typeService" id="typeService" onchange="selectService()" >
                        <c:forEach var="typeService" items="${typeServiceList}">
                            <option value="${typeService.id}" id="${typeService.id}">
                                <c:out value="${typeService.name}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standardRoom" id="standardRoom" size="45"/>
                </td>
            </tr>

            <tr id="desc">
                <th>Description Other Convenience:</th>
                <td>
                    <input type="text" name="desc"  size="45"/>
                </td>
            </tr>
            <tr id="areaPool">
                <th>Area Pool:</th>
                <td>
                    <input type="text" name="areaPool"  size="45"/>
                </td>
            </tr>
            <tr id="numOfFloor">
                <th>Number Of Floor:</th>
                <td>
                    <input type="text" name="numOfFloor"  size="45"/>
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

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script>
    function selectService(){
        let typeService = document.getElementById("typeService").value;

        switch (typeService) {
            case "1":
                document.getElementById("areaPool").style.display = 'table-row';
                document.getElementById("numOfFloor").style.display = 'table-row';
                document.getElementById("desc").style.display = 'table-row';
                break;
            case "2" :
                document.getElementById("areaPool").style.display = 'none';
                document.getElementById("numOfFloor").style.display = 'table-row';
                document.getElementById("desc").style.display = 'table-row';
                break;
            case "3":
                document.getElementById("areaPool").style.display = 'none';
                document.getElementById("numOfFloor").style.display = 'none';
                document.getElementById("desc").style.display = 'none';
                break;
        }
    }
    $(window).on('load', function() {
        selectService();
    });
</script>
</body>
</html>
