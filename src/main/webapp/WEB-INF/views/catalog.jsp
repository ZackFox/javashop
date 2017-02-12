<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

        <div class="container content-wrapper">
            <div class="row"><
                <div class="col-md-12">
                    <ul class="categories">
                        <c:forEach var="cat" items="${applicationScope.categories}">
                            <li >
                                <a href="/catalog/category?id=${cat.id}" class="cat_item">
                                    <h3>${cat.name}</h3>
                                    <img src="x" alt="">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"/>
