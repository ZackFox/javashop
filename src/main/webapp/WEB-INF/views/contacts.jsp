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
        <div class="container">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                        <tr>
                            <td>Firstname</td>
                            <td>Lastname</td>
                            <td>Address</td>
                            <td>Phone number</td>
                            <td>Email</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="contact" items="${list}">
                            <tr>
                                <td>${contact.firstName}</td>
                                <td>${contact.lastName}</td>
                                <td>${contact.address}</td>
                                <td>${contact.phoneNumber}</td>
                                <td>${contact.email}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
