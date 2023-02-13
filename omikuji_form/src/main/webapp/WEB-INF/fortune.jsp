<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fortune</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div>
        <p>Number:
        <c:out value="${num}"></c:out>
    </p>
    </div>
    <div>
        <p>Name:
        <c:out value="${name}"></c:out>
    </p>
    </div>
    <div>
        <p>Place:
        <c:out value="${place}"></c:out>
    </p>
    </div>
    <div>
        <p>Hobby:
        <c:out value="${hobby}"></c:out>
    </p>
    </div>
    <div>
        <p>Animal:
        <c:out value="${animal}"></c:out>
    </p>
    </div>


   <a href="/">Back</a>
</body>
</html>