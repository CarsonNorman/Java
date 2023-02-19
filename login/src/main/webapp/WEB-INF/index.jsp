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

<body class="w-100 d-flex  justify-content-around">
  <div class="w-50">
    <h1>Register</h1>
    <form:form action="/register" method="post" modelAttribute="newUser">
      <div>
        <form:label path="username">Username</form:label><br>
        <form:errors path="username" class="text-danger"></form:errors>
        <form:input path="username" class="form-control w-25"></form:input>
      </div>
      <div>
        <form:label path="email">Email</form:label><br>
        <form:errors path="email" class="text-danger"></form:errors>
        <form:input path="email" class="form-control w-25"></form:input>
      </div>
      <div>
        <form:label path="password">Password</form:label><br>
        <form:errors path="password" class="text-danger"></form:errors>
        <form:input path="password" class="form-control w-25"></form:input>
      </div>
      <div>
        <form:label path="confirm">Confirm Password</form:label><br>
        <form:errors path="confirm" class="text-danger"></form:errors>
        <form:input path="confirm" class="form-control w-25"></form:input>
      </div>
      <input type="submit" value="Submit" class="form-control w-25">
    </form:form>
  </div>
  <div class="w-50">
    <h1>Login</h1>
    <form:form action="/login" method="post" modelAttribute="newLogin">
      <div>
        <form:label path="email">Email</form:label><br>
        <form:errors path="email" class="text-danger"></form:errors>
        <form:input path="email" class="form-control w-25"></form:input>
      </div>
      <div>
        <form:label path="password">Password</form:label><br>
        <form:errors path="password" class="text-danger"></form:errors>
        <form:input path="password" class="form-control w-25"></form:input>
      </div>
      <input type="submit" value="Submit" class="form-control w-25">

    </form:form>
  </div>
</body>

</html>