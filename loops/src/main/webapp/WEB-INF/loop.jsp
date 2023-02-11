<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Loops</title>
    </head>

    <body>
      <table>
        <thead>
          <th>Name</th>
          <th>Price</th>
        </thead>
        <tbody>
          <c:forEach var="fruit" items="${fruits}">
            <tr>
              <td>
                <c:out value="${fruit.getName()}"></c:out>
              </td>
              <td>
                <c:out value="${fruit.getPrice()}"></c:out>
              </td>
            </tr>
          </c:forEach>

        </tbody>
      </table>



    </body>

    </html>