<%-- 
    Document   : base
    Created on : Mar 26, 2021, 7:23:57 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/main.css" />" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
        <title>Trang chủ</title>
    </head>
    <body>
        <div class="container">
        
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Trang chủ</a>
                    </li>
                    <c:forEach items="${categories}" var="cate">
                    <li class="nav-item">
                        <a class="nav-link" href="#">${cate.name}</a>
                    </li>
                    </c:forEach>
                </ul>
            </nav>

            <section>
                <h1 class="text-center text-danger">
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
         </div>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
        crossorigin="anonymous"></script>
    </body>
</html>
