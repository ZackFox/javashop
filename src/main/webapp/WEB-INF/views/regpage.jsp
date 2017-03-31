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
                <p>Пожалуйста заполните все поля</p>
                <div class="well">
                    <form action="/registration/new/profile" method="post">
                        <div class="input-group">
                            <span class="input-group-addon" >@</span>
                            <input type="text" name="firstname" class="form-control" placeholder="Имя">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" name="lastname" class="form-control" placeholder="Фамилия">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" name="phone" class="form-control" placeholder="Телефон" id="phone">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon">@</span>
                            <input type="text" name="email" class="form-control" placeholder="E-mail" id="email">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon" >@</span>
                            <input type="text" name="login" class="form-control" placeholder="Логин">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon" >@</span>
                            <input type="text" name="password" class="form-control" placeholder="Пароль">
                        </div>

                        <div class="input-group">
                            <a href="" >назад</a>
                            <input type="submit" class="btn btn-success" value="Отправить">
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
