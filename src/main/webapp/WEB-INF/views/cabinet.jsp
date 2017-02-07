<%--<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>contacts</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h3 class="logo"> ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</h3>
            </div>

            <div class="col-md-3">

            </div>
        </div>
        <div class="row">
            <div class="col-md12">
                <nav class="nav">
                    <ul>
                        <li><a href="">главная</a></li>
                        <li><a href="">главная</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</header>
<div class="container ">
    <div class="row">
        <div class="col-md-10">
            <div class="t">
                <h1>cabinet</h1>
            </div>
        </div>
    </div>
</div>
</body>
</html>
