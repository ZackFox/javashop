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
                        <a href="/registration/new" class="reg-btn">Зарегистрироваться</a>
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
                    <div class="col-md-7">
                        <div class="search-bar">
                            <div class="nav-menu">
                                <span>Категории</span>
                                <ul class="root-menu">
                                    <c:forEach var="menu1" items="${applicationScope.categories}" >
                                        <c:if test="${menu1.parentId == 0}">
                                            <li>
                                                <a href="/catalog/category?id=${menu1.id}">${menu1.name}</a>
                                                <ul class="sub-menu">
                                                    <c:if test="${menu1.getSubCategories().size() > 0}">
                                                        <c:forEach var="menu2" items="${menu1.subCategories}">
                                                            <li>
                                                                <a href="/catalog/category?id=${menu2.id}">${menu2.name}</a>
                                                            </li>
                                                        </c:forEach>
                                                    </c:if>
                                                </ul>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </div>


                            <form action="">
                                <input type="text" class="search" placeholder="искать">
                                <a href="/" class="fa fa-search"></a>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <c:if test="${sessionScope.customer.id == 0}">
                            <p>Для оформления заказа необходимо авторизоваться.</p>
                        </c:if>

                        <c:if test="${sessionScope.customer.id > 0}">
                            <a href="/cabinet/card" class="card"><i class="fa fa-shopping-cart"></i>Карзина</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </header>
