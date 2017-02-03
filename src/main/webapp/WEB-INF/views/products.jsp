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
                        <a href="/products" class="logo">Shopper</a>
                    </div>
                    <div class="col-md-5">
                        <form action="">
                            <input type="text" class="search">
                            <input type="submit" class="btn btn-primary" value="поиск" placeholder="искать">
                        </form>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${sessionScope.customer.id == 0}">
                            <p>Вы вошли как ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</p>
                            <p>Для оформления заказа необходимо авторизоваться.</p>
                            <a href="#" class="login-btn">Войти</a>
                            <a href="registration/new/profile" class="login-btn">Зарегистрироваться</a>

                            <div class="login-form">
                                <form action="/login" method="post">
                                    <label for="login">логин:</label>
                                    <input type="text" name="login" id="login">
                                    <label for="pass">пороль:</label>
                                    <input type="password" name="password" id="pass">
                                    <input type="submit" class="btn btn-primary">
                                </form>
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.customer.id > 0}">
                            <a href="/get/card/profile/1" class="card">Карзина</a>
                            <a href="/get/profile/1" class="personal">${customer.firstName}</a>
                            <a href="/logout" class="logout-btn">logout</a>
                        </c:if>

                    </div>
                </div>

                <nav>
                    <ul class="nav">
                        <li><a href="">Главная</a></li>
                        <li><a href="">главная</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="container content-wrapper">
            <div class="row">
                <aside class="col-md-2">
                    <h5>товары</h5>
                    <ul class="nav nav-sidebar">
                        <li><a href="">телевизоры</a></li>
                        <li><a href="">телефоны</a></li>
                        <li><a href="">принтеры</a></li>
                    </ul>
                </aside>
                <div class="col-md-10">
                    <div class="table">
                        <ul>
                            <c:forEach var="profile" items="${list}">
                                <li>
                                    <a href="">${profile.firstName}</a>
                                    <a href="">${profile.lastName}</a>
                                    <a href="">${profile.address}</a>
                                    <a href="">${profile.phoneNumber}</a>
                                    <a href="">${profile.email}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
