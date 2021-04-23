<%-- 
    Document   : register
    Created on : Apr 23, 2021, 7:30:29 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">ĐĂNG KÝ TÀI KHOẢN</h1>

<c:url value="/register" var="action" />
<form:form method="post" action="${action}" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <form:input id="firstName" class="form-control" path="firstName" />
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <form:input id="lastName" class="form-control" path="lastName" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input id="email" class="form-control" path="email" />
    </div>
    <div class="form-group">
        <label for="phone">Phone</label>
        <form:input id="phone" class="form-control" path="phone" />
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input id="username" class="form-control" path="username" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:password id="password" class="form-control" path="password" />
    </div>
    <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <form:password id="confirm-password" class="form-control" path="confirmPassword" />
    </div>
    <div>
        <input type="submit" value="Đăng ký" class="btn btn-danger" />
    </div>
</form:form>
