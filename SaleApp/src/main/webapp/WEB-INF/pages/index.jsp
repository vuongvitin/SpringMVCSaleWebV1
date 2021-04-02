<%-- 
    Document   : index
    Created on : Apr 2, 2021, 7:40:39 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="index.jsp"></a>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">DANH SÁCH SẢN PHẨM</h1>
<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Gía sản phẩm</th>
    </tr>
    <c:forEach items="${products}" var="product">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price} VNĐ</td>
    </tr>
    </c:forEach>
</table>