<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

        <div class="container content-wrapper">
            <div class="row">
                <%--<aside class="sidebar">--%>
                    <%--<h4>Категории</h4>--%>
                    <%--<ul class="nav nav-sidebar">--%>
                        <%--<c:forEach var="cat" items="${applicationScope.categories}" >--%>
                            <%--<li>--%>
                                <%--<a href="/catalog/category?id=${cat.id}">${cat.name}</a>--%>
                                <%--<ul class="sub-menu">--%>
                                    <%--<c:forEach var="subcat" items="${cat.subCategories}">--%>
                                        <%--<li>--%>
                                            <%--<a href="/catalog/category?id=${subcat.id}">${subcat.name}</a>--%>
                                        <%--</li>--%>
                                    <%--</c:forEach>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>
                <%--</aside>--%>

                <div class="products">
                    <ul>
                        <c:forEach var="prod" items="${products}" >
                            <li >
                                <a href="/catalog/product?id=${prod.id}" class="p_item">
                                    <h3>${prod.name}</h3>
                                    <img src="" alt="">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>

                    <a href="/" class="btn btn-success btn-more" data-offset="20">показать еще</a>
                    <div class=ajaxtest></div>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"/>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<jsp:include page="../views/scripts.jsp"/>