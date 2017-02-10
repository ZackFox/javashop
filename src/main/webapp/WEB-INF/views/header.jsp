<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <a href="/catalog" class="logo">Shopper</a>
                    </div>
                    <div class="col-md-5">
                        <form action="">
                            <input type="text" class="search">
                            <input type="submit" class="btn btn-primary" value="поиск" placeholder="искать">
                        </form>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${sessionScope.customer.id == 0}">
                            <span>Вы вошли как ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</span>
                            <a href="registration/new/profile" class="login-btn">Зарегистрироваться</a>
                            <p>Для оформления заказа необходимо авторизоваться.</p>

                            <div class="login-form">
                                <form action="/login" method="post">
                                    <input type="text" name="login" id="login" placeholder="логин">
                                    <input type="password" name="password" id="pass" placeholder="пароль">
                                    <input type="submit" class="btn btn-login" value="Войти">
                                </form>
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.customer.id > 0}">
                            <a href="/cabinet" class="personal">Личный кабинет (${sessionScope.customer.firstName} ${sessionScope.customer.lastName})</a>
                            <a href="/cabinet/card" class="card">Карзина</a>
                            <a href="/logout" class="logout-btn">Выйти</a>
                        </c:if>

                    </div>
                </div>

                <nav>
                    <ul class="nav">
                        <li><a href="/catalog">Главная</a></li>
                        <c:forEach var="cat" items="${applicationScope.categories}">
                            <li><a href="/catalog/category?id=${cat.id}">${cat.name}</a></li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </header>
