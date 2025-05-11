<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Menu</title>
</head>
<body>
<h2>Welcome, Customer!</h2>

<h3>Select a category:</h3>
<ul>
    <c:forEach items="${categories}" var="category">
        <li>
            <a href="/customer/category/${category.id}">${category.name}</a>
        </li>
    </c:forEach>
</ul>

<c:if test="${not empty dishes}">
    <h3>Dishes in category: ${selectedCategory.name}</h3>
    <ul>
        <c:forEach items="${dishes}" var="dish">
            <li>
                    ${dish.name} - $${dish.price}
                <form method="post" action="/customer/add-to-cart">
                    <input type="hidden" name="dishId" value="${dish.id}" />
                    <input type="submit" value="Add to cart" />
                </form>
            </li>
        </c:forEach>
    </ul>
</c:if>

<h3>Your cart:</h3>
<ul>
    <c:forEach items="${cart}" var="item">
        <li>${item.name} - $${item.price}</li>
    </c:forEach>
</ul>

<p><a href="/logout">Logout</a></p>
</body>
</html>
