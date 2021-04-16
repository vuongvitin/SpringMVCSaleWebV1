<%-- 
    Document   : index
    Created on : Apr 2, 2021, 7:40:39 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">DANH SÁCH SẢN PHẨM</h1>
<form:form>
<div class="row">
    <div class="col-md-10 form-group">
        <input type="text" name="kw" class="form-control" placeholder="Nhập từ khóa để tìm..." />
    </div>
    <div class="col-md-2 form-group">
        <input type="submit" class="btn btn-info" value="Tìm kiếm" />
    </div>
</div>
</form:form>
<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Gía sản phẩm</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="product">
    <tr id="product${product.id}">
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price} VNĐ</td>
        <td>
            <a href="javascript:;" class="btn btn-danger" onclick="deleteProduct(${product.id})">Xóa</a>
            <a href="<c:url value="/products/?productId=${product.id}" />" class="btn btn-info">Cập nhật</a>
            <a href="javascript:;" class="btn btn-success" onclick="">Thêm vào giỏ</a>
        </td>
    </tr>
    </c:forEach>
</table>

<script src="<c:url value="/js/main.js" />"></script>