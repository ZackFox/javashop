<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

        <div class="container content-wrapper">
            <div class="row">

                <div class="sidebar">
                    <h4>Брэнд</h4>
                    <div class="brands">
                        <a href="/catalog/category?id=${catId}&brand=0">Все</a>
                        <c:forEach var="brand" items="${brands}">
                            <a href="/catalog/category?id=${catId}&brand=${brand.id}">${brand.name}</a>
                        </c:forEach>
                    </div>
                </div>

                <div class="products">
                    <ul>
                        <c:forEach var="prod" items="${products}" >
                            <li>
                                <a href="/catalog/product?id=${prod.id}" class="p_item">
                                    <h3>${prod.name}</h3>
                                    <img src="<c:url value="/resources/img/pic8.jpg" />" alt="картинка">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    <a href="/" class="btn btn-success btn-more">показать еще</a>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<jsp:include page="../views/scripts.jsp"/>