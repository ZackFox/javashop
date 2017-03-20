<%--<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

<div class="container ">
    <div class="row">
        <div class="col-md-10">
            <div class="t">
                <h4>Профиль</h4>
                <p><span>Имя</span> ${sessionScope.customer.firstName}</p>
                <p><span>Фамилия: </span> ${sessionScope.customer.lastName}</p>
                <p><span>Телефоy: </span> ${sessionScope.customer.phoneNumber}</p>
                <p><span>E-mail: </span> ${sessionScope.customer.email}</p>
                <p><span>Город: </span> ${sessionScope.customer.address}</p>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<jsp:include page="../views/scripts.jsp"/>