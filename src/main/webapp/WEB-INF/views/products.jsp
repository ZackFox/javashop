<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

        <div class="container content-wrapper">
            <div class="row">
                <aside class="col-md-2">
                    <h5>товары</h5>

                    <ul class="nav nav-sidebar">
                        <c:forEach var="cat" items="${applicationScope.categories}">
                            <li><a href="catalog/category?id=1">${cat.name}</a></li>
                        </c:forEach>
                    </ul>
                </aside>

                <div class="col-md-10">
                    <h3>продукты</h3>
                    <ul class="products">
                        <c:forEach var="prod" items="${products}">
                            <li >
                                <a href="/catalog/product?id=2" class="p_item">
                                    <h3>${prod.name}</h3>
                                    <img src="x" alt="">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"/>