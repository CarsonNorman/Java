<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login/Reg</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>

<body class="w-100">
    <div class="w-100 d-flex  justify-content-around">
        <h3>Add to shelf</h3>
        <a href="/books">Back</a>
        <h1>${id}</h1>
    </div>
    <div class="w-50 d-flex  justify-content-around mx-auto">
        <form:form action="/book" method="post" modelAttribute="newBook" class="w-50">
            <div>
                <form:errors path="title" class="text-danger"></form:errors><br>
                <form:errors path="author" class="text-danger"></form:errors><br>
                <form:errors path="thoughts" class="text-danger"></form:errors>
            </div>
            <div >
                <form:label path="title">title</form:label>
                <form:input path="title" class="form-control"></form:input>
            </div>
            <div >
                <form:label path="author">author</form:label>
                <form:input path="author" class="form-control"></form:input>
            </div>
            <div >
                <form:label path="thoughts">thoughts</form:label>
                <form:textarea path="thoughts" class="form-control"></form:textarea>
            </div>
            <div >
                <form:input path="user" value="${id}" type="hidden" class="form-control"></form:input>
            </div>
            <div >
                <input type="submit" value="Submit" class="form-control"/>
            </div>
        </form:form>
        
    </div>
</body>

</html>