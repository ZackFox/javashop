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
                <a href="/products" class="logo">Digital Shop</a>
            </div>
            <div class="col-md-6">
                <form action="">
                    <input type="text" class="text-input">
                    <input type="submit" value="поиск" class="btn btn-primary">
                </form>
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
                <%--<ul>--%>
                    <%--<c:forEach var="profile" items="${list}">--%>
                        <%--<li>--%>
                            <%--<a href="">${profile.firstName}</a>--%>
                            <%--<a href="">${profile.lastName}</a>--%>
                            <%--<a href="">${profile.address}</a>--%>
                            <%--<a href="">${profile.phoneNumber}</a>--%>
                            <%--<a href="">${profile.email}</a>--%>
                        <%--</li>--%>
                    <%--</c:forEach>--%>
                <%--</ul>--%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
