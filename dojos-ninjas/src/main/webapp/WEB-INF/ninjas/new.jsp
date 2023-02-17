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
      <title>Dojos</title>
      <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
      <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
      <script src="/webjars/jquery/jquery.min.js"></script>
      <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
    </head>
    <body>
      <div>
        <h1>New Dojo</h1>
        <form:form action="/ninjas" method="post" modelAttribute="ninja" >
          <div class="form-control mx-auto w-25" >
            <form:label path="first" class="mx-3">First:</form:label>
            <form:input path="first" type="text" ></form:input>
          </div>
          <div class="form-control mx-auto w-25">
            <form:label path="last" class="mx-3">Last:</form:label>
            <form:input path="last" type="text" ></form:input>
          </div>
          <div class="form-control mx-auto w-25">
            <form:label path="age" class="mx-3">Age:</form:label>
            <form:input path="age" type="number" ></form:input>
          </div>
          <div class="form-control mx-auto w-25">
            <form:select path="dojo" class="w-75 mx-5">
              <c:forEach var="dojo" items="${dojos}">
                <form:option path="dojo" value="${dojo.id}">${dojo.name}</form:option>
              </c:forEach>
            </form:select>
          </div>


          <input type="submit" value="Submit">
        </form:form>
      </div>
    </body>
</html>