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
    <title>Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <form:form action="/new/expense" method="post" modelAttribute="expense">
            <form:label path="name">Name</form:label>
            <form:errors path="name"></form:errors>
            <form:input path="name" value="${expense.name}"></form:input>
            <form:label path="price">Price</form:label>
            <form:errors path="price"></form:errors>
            <form:input path="price" value="${expense.price}"></form:input>
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor"></form:errors>
            <form:input path="vendor" value="${expense.vendor}"></form:input>
            <c:if test="${edit != true}">
                <input type="submit" value="add expense">
            </c:if>
            <c:if test="${edit == true}">
                <input type="hidden" name="_method" value="put">
                <input type="submit" formaction="/expense/${expense.id}" value="edit expense">
            </c:if>
    </form:form>
</body>