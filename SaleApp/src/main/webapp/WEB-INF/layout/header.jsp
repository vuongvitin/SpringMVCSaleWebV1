<%-- 
    Document   : header
    Created on : Apr 2, 2021, 7:36:42 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
        </li>
        <c:forEach items="${categories}" var="cate">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/?cateId=${cate.id}" />">${cate.name}</a>
            </li>
        </c:forEach>
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/cart" />">
                Giỏ hàng <span class="badge badge-danger" id="cart-counter">${cartStats.totalQuantity}</span>
            </a>
        </li>
        
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/register" />">
                        Đăng ký 
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/login" />">Đăng nhập</a>
                </li>
            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a class="nav-link text-danger" href="#">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/logout" />">Logout</a>
                </li>
            </c:when>
        </c:choose>
    </ul>
</nav>
