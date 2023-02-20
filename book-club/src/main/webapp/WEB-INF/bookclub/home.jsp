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

<body>
  <div id="nav" class="d-flex justify-content-around w-100">
    <h1>
      Hello ${username} ${id}
    </h1>
    <div>

      <a href="/books/new" class="mx-4">New Book</a>
      <a href="/logout">logout</a>
    </div>
  </div>
  <div class="d-flex justify-content-around w-100">
    <table class="table  w-50">
      <thead>
        <th>Author</th>
        <th>Title</th>
        <th>Posted by</th>
      </thead>
      <tbody>
        <c:forEach var="book" items="${books}">
          <tr>
            <td>
              ${book.author}
            </td>
            <td>
              <a href="books/show/${book.id}">${book.title}</a>
            </td>  
            <td>
              ${book.user.username}
            </td>
          </tr>
        </c:forEach>
        
      </tbody>
    </table>
    
  </div>
</body>

</html>