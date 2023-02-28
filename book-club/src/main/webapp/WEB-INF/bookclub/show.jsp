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

<body class="w-100 ">
    <div class="w-100 d-flex  justify-content-around">
        <h1>${book.title}</h1>
        <a href="/books">Back to shelves</a>
    </div>
    <div class="w-100 d-flex flex-column  justify-content-around align-items-center">
        <h3>
            ${book.user.username} read ${book.title} by ${book.author}</h3>
        <h4>Here are ${book.user.username} thoughts</h4>
        <p>${book.thoughts}</p>
        <div class="w-25 mx-auto d-flex  justify-content-around align-items-center">
            <c:if test="${userId == book.user.id}">
                <a href="/books/edit/${book.id}" class="btn btn-info btn-sm">Edit</a> 
                <form action="/books/delete/${book.id}" method="post">
                    <input type="hidden" name="_method"  value="Delete">
                    <input type="submit" value="delete" class="btn btn-danger btn-sm">
                </form>
        </c:if>
        <c:if test="${userId != book.user.id}">
                <a href="/books/borrow/${book.id}" class="btn btn-info btn-sm">Add to borrowed collection</a> 
                </form>
        </c:if>               
    </div>
    </div>

</body>

</html>