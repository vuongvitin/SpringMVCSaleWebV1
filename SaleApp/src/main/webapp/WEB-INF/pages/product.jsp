<%-- 
    Document   : product
    Created on : Apr 2, 2021, 8:24:29 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <h1 class="text-center text-danger">
        <spring:message code="saleapp.title" />
    </h1>
    <form:form method="post" modelAttribute="product">
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
        
        <div class="form-group">
            <label for="name">
                <spring:message code="product.name" />
            </label>
            <form:input id="name" cssClass="form-control" path="name" />
        </div>
        <div class="form-group">
            <label for="description">
                <spring:message code="product.des" />
            </label>
            <form:input id="description" cssClass="form-control" path="description" />
        </div>
        <div class="form-group">
            <label for="price">
                <spring:message code="product.price" />
            </label>
            <form:input id="price" cssClass="form-control" path="price" />
        </div>
        <div class="form-group">
            <label for="category">
                <spring:message code="product.cate" />
            </label>
            <form:select cssClass="form-control" id="category" path="category">
                 <c:forEach items="${categories}" var="cat">
                    <c:if test="${cat.id == product.category.id}">
                        <option selected value="${cat.id}">${cat.name}</option>
                    </c:if>
                    <c:if test="${cat.id != product.category.id}">
                        <option value="${cat.id}">${cat.name}</option>
                    </c:if>
                </c:forEach>
            </form:select>
        </div>
        
        <div class="form-group">
            <form:hidden path="id" />
            <c:if test="${product.id > 0}">
                <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="product.update" />" />
            </c:if>
            <c:if test="${product.id <= 0}">
                <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="product.add" />" />
            </c:if>
            
        </div>
    </form:form>
</section>