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
            <div class="col-lg-offset-3 col-md-6">
                <h2>регистрация!</h2>
                <p>приложение написано с применением servlet и jdbc </p>

                <form class="well" action="/registration/new/profile" method="post">
                    <lable>Имя</lable>
                    <input type="text" name="firstname">
                    <lable>Фамилия</lable>
                    <input type="text" name="lastname">
                    <lable>E-mail</lable>
                    <input type="text" name="email">
                    <lable>Логин</lable>
                    <input type="text" name="login">
                    <lable>Пороль</lable>
                    <input type="password" name="password">
                    <input type="submit">
                </form>
            </div>
        </div>
    </body>
</html>
