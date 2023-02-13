<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  </head>

  <body>
    <form method="POST" action="/handle">
      <div>
        <label for="num">Number</label>
        <input type="number" name="num">
      </div>
      <div>
         <label for="name">Name</label>
        <input type="text" name="name">
      </div>
      <div>
        <label for="place">Place</label>
        <input type="text" name="place">
      </div>
      <div>
        <label for="hobby">Hobby</label>
        <input type="text" name="hobby">
      </div>
      <div>
        <label for="animal">Animal</label>
        <input type="text" name="animal">
      </div>
     <div>
        <input type="submit" value="Submit">
      </div>
    </form>
  </body>

</html>