<%-- 
    Document   : login
    Created on : Apr 23, 2021, 9:23:51 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Chương trình đang xảy ra lỗi! Vui lòng quay lại sau!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập trang web
    </div>
</c:if>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    <div>
        <input type="submit" value="Đăng ký" class="btn btn-danger" />
    </div>
</form>