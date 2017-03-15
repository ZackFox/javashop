<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <c:if test="${!empty subCategories}">
            <ul class="categories">
                <c:forEach var="sub" items="${subCategories}">
                    <li >
                        <a href="/catalog/category?id=${sub.id}" class="cat_item">
                            <h3>${sub.name}</h3>
                            <img src="" alt="">
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<jsp:include page="scripts.jsp"/>
