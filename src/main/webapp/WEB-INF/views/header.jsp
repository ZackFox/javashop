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
            <div class="top-header">
                <div class="container">
                    <a href="/info/shipping">Доставка</a>
                    <a href="/info/buy">Оплата</a>
                    <c:if test="${sessionScope.customer.id == 0}">
                        <a href="registration/new/profile" class="reg-btn">Зарегистрироваться</a>
                        <div class="login-form">
                            <form action="/login" method="post">
                                <input type="text" name="login" id="login" placeholder="логин">
                                <input type="password" name="password" id="pass" placeholder="пароль">
                                <input type="submit" class="btn btn-login" value="Войти">
                            </form>
                        </div>
                    </c:if>

                    <c:if test="${sessionScope.customer.id > 0}">
                        <a href="/cabinet" class="personal">Личный кабинет(${sessionScope.customer.firstName} ${sessionScope.customer.lastName})</a>
                        <a href="/logout" class="logout-btn">Выйти</a>
                    </c:if>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <a href="/catalog" class="logo">Shopper</a>
                    </div>
                    <div class="col-md-6">
                        <form action="">
                            <input type="text" class="search" placeholder="искать">
                            <a href="/" class="fa fa-search"></a>
                        </form>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${sessionScope.customer.id == 0}">
                            <span>Вы вошли как ${sessionScope.customer.firstName} ${sessionScope.customer.lastName}</span>
                            <a href="registration/new/profile" class="login-btn">Зарегистрироваться</a>
                            <p>Для оформления заказа необходимо авторизоваться.</p>
                        </c:if>

                        <c:if test="${sessionScope.customer.id > 0}">
                            <a href="/cabinet/card" class="card"><i class="fa fa-shopping-cart"></i>Карзина</a>
                        </c:if>
                    </div>
                </div>

                <nav class="nav-menu">
                    <span>Категории</span>
                    <ul class="root-menu">
                        <c:forEach var="cat" items="${applicationScope.categories}" >
                            <li>
                                <a href="/catalog/category?id=${cat.id}">${cat.name}</a>
                                <ul class="sub-menu">
                                    <c:forEach var="subcat" items="${cat.subCategories}">
                                        <li>
                                            <a href="/catalog/category?id=${subcat.id}">${subcat.name}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </header>
