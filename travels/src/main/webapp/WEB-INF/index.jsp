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
    <table class="table">
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>
                    <a href="/expense/view/${expense.id}">
                        ${expense.name}
                    </a>
                </td>
                <td>${expense.price}</td>
                <td>${expense.vendor}</td>
                <td><a href="/expense/edit/${expense.id}">Edit</a> 
                <form action="/expense/${expense.id}" method="post">
                    <input type="hidden" name="_method"  value="Delete">
                    <input type="submit" value="delete">
                </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/new">
        New Expense
    </a>
</body>
</html>