<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Your Cart</title></head>
<body>
<h2>Your Cart</h2>
<ul>
  <c:forEach items="${cartItems}" var="item">
    <li>${item.dish.name} - ${item.quantity} шт - ${item.dish.price * item.quantity} грн</li>
  </c:forEach>
</ul>
<form method="POST" action="/purchase">
  <input type="submit" value="Place Order"/>
</form>
</body>
</html>