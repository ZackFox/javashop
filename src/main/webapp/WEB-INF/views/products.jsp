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
                            <c:if test="${limit - i.index > 0 }">
                                <li class="p_item">
                                    <div class="title-block clearfix">
                                        <a href="/catalog/product?id=${prod.id}">${prod.name}</a>
                                        <p class="price">${prod.price}<span>Р.</span></p>
                                    </div>
                                        <div class="p-content clearfix">
                                        <div class="image">
                                            <img src="<c:url value="${pageContext.request.contextPath}/resources/img/pic8.jpg"/>" alt="картинка">
                                        </div>
                                        <div class="desctription">
                                            <p>${prod.description}</p>
                                        </div>
                                    </div>
                                </li>
                            </c:if>
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