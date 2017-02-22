<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:include page="header.jsp"/>

        <div class="container content-wrapper">
            <div class="row">
                <div class="col-md-12 product-content">
                    <h3>${product.name}</h3>
                    <h3>${product.price}</h3>
                    <h3>${product.description}</h3>
                    <img src="x" alt="">
                    <a href="" >добавить в карзину</a>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"/>
<jsp:include page="../views/scripts.jsp"/>