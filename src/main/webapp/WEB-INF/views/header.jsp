<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8" %>

<html>
    <head>
        <title>contacts</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">


        <script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.cookie.js"/>"></script>
        <script src="<c:url value="/resources/js/ajaxlogin.js"/>"></script>
    </head>

    <body>
        <c:if test="${sessionScope.customer.id > 0}">
            <c:set value="activated" var="on"/>
            <c:set value="deactivated" var="off"/>
        </c:if>

        <header>
            <div class="top-header">
                <div class="container">
                    <span>8-800-550-55-22</span>
                    <a href="/info/shipping">Доставка</a>
                    <a href="/info/buy">Оплата</a>
                    <a href="/registration/new" class="reg-btn ${off}">Зарегистрироваться</a>

                    <a href="/cabinet" class="cabinet ${on}">Личный кабинет()</a>
                    <a href="/logout" class="logout ${on}">Выйти</a>

                        <div class="login-form ${off}">
                            <form action="/login" method="post">
                                <input type="text" name="login" id="login" placeholder="логин" required>
                                <input type="password" name="password" id="pass" placeholder="пароль" required>
                                <input type="submit" class="btn btn-login" value="Войти">
                            </form>
                        </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <a href="/catalog" class="logo">Shopper</a>
                    </div>
                    <div class="col-md-6">
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
                                                                <a href="/catalog/category?id=${menu2.id}&brand=0">${menu2.name}</a>
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
                    <div class="col-md-4">
                        <a href="/cabinet/card" class="cart clearfix">
                            <span href="/cabinet/card" class="cart-count"></span>
                            <i class="fa fa-shopping-cart"></i>
                            <span href="/cabinet/card" class="cart-total"></span>
                        </a>
                    </div>
                </div>
            </div>

            <div class="message">
                <span></span>
                <a href="">Забыл пароль?</a>
                <i class="btn-close fa fa-close"></i>
            </div>
        </header>
