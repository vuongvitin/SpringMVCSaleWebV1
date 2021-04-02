<%-- 
    Document   : product
    Created on : Apr 2, 2021, 8:24:29 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <<h1 class="text-center text-danger">
        <spring:message code="saleapp.title" />
    </h1>
    <form method="POST" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">
                <spring:message code="product.name" />
            </label>
            <input id="name" class="form-control" />
        </div>
        <div class="form-group">
            <label for="price">
                <spring:message code="product.price" />
            </label>
            <input id="price" class="form-control" />
        </div>
        <div class="form-group">
            <label for="price">
                <spring:message code="product.image" />
            </label>
            <input type="file" id="price" class="form-control" />   
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-warning" 
                   value="<spring:message code="product.add" />" />
        </div>
    </form>
</section>