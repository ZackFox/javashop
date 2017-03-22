<%--<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
    <head>
        <title>Phonebook</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="col-md-12">
                <h1>Интернет магазин электроники</h1>
                <a href="catalog">Открыть каталог</a>
                <p> приложение написано с применением servlet и jdbc </p>

                <h3>Реализованные возможноси</h3>
                <ul>
                    <li>Регистрация и авторизация</li>
                    <li>Личный кабинет пользователя</li>
                    <li>Многоуровневое меню категорий товаров</li>
                    <li>поиск товаров</li>
                    <li>догрузкая товаров ajax</li>
                    <li>страница Товара характеристиками</li>
                    <li>Карзина заказа</li>
                    <li>оформление заказа</li>
                    <li>добавление и удаление товара в админ панели</li>
                </ul>
            </div>
        </div>
    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/addtoCart.js"/>"></script>
    </body>
</html>
