<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-10">
            <a class="navbar-brand" rel="home" href="/" title="Click">
                <img src="assert/img/unnamed.png" height="105" width="256"/>
            </a>
        </div>
        <div class="col-2 m-auto">
            <h4>Nguyễn Thành Đạt</h4>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse d-flex justify-content-center position-relative" id="navbarSupportedContent">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link ml-5 mr-5" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ml-5 mr-5" href="#">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ml-5 mr-5" href="/customer?type=customer&action=null">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ml-5 mr-5" href="/service?type=service&action=null">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link ml-5 mr-5" href="#">Contract</a>
            </li>
        </ul>
    </div>
    <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap413/js/bootstrap.min.js"></script>
</body>
</html>
