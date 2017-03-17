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
                        <c:forEach var="prod" items="${products}" varStatus="i">
                            <li>
                                <c:if test="${limit - i.index > 0 }">
                                    <a href="/catalog/product?id=${prod.id}" class="p_item">
                                        <h3>${prod.name}</h3>
                                        <img src="<c:url value="/resources/img/pic8.jpg" />" alt="картинка">
                                    </a>
                                </c:if>
                            </li>
                        </c:forEach>
                    </ul>

                    <c:if test="${offset-limit >= 0}">
                        <a href="/catalog/category?id=${catId}&brand=${brandId}&offset=${offset-limit}" class="btn" >Назад</a>
                    </c:if>
                    <c:if test="${offset-limit < 0}">
                        <a href="#" class="btn" disabled>Назад</a>
                    </c:if>

                    <c:if test="${products.size() > limit }">
                        <a href="/catalog/category?id=${catId}&brand=${brandId}&offset=${offset+(limit)}" class="btn" >Вперед</a>
                    </c:if>

                    <c:if test="${products.size() <= limit }">
                        <a href="#" class="btn" disabled>Вперед</a>
                    </c:if>
                </div>
            </div>
        </div>




<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<jsp:include page="../views/scripts.jsp"/>