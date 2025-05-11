<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Dishes</title></head>
<body>
<h2>Dishes in ${category.name}</h2>
<ul>
    <c:forEach items="${dishes}" var="dish">
        <li>
                ${dish.name} - ${dish.price} грн
            <form method="POST" action="/cart/add">
                <input type="hidden" name="dishId" value="${dish.id}"/>
                <input type="submit" value="Add to Cart"/>
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>