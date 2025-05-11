<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Admin Panel</title>
</head>
<body>
<h2>Welcome, Admin!</h2>

<h3>Categories:</h3>
<ul>
  <c:forEach items="${categories}" var="category">
    <li>
        ${category.name}
      <form method="post" action="/admin/delete-category" style="display:inline;">
        <input type="hidden" name="categoryId" value="${category.id}" />
        <input type="submit" value="Delete" />
      </form>
    </li>
  </c:forEach>
</ul>

<h4>Add new category:</h4>
<form method="post" action="/admin/add-category">
  <input type="text" name="categoryName" placeholder="Category name" required />
  <input type="submit" value="Add" />
</form>

<hr/>

<h3>Dishes:</h3>
<ul>
  <c:forEach items="${dishes}" var="dish">
    <li>
        ${dish.name} - ${dish.category.name} - $${dish.price}
      <form method="post" action="/admin/delete-dish" style="display:inline;">
        <input type="hidden" name="dishId" value="${dish.id}" />
        <input type="submit" value="Delete" />
      </form>
    </li>
  </c:forEach>
</ul>

<h4>Add new dish:</h4>
<form method="post" action="/admin/add-dish">
  <input type="text" name="name" placeholder="Dish name" required />
  <input type="number" step="0.01" name="price" placeholder="Price" required />
  <select name="categoryId" required>
    <c:forEach items="${categories}" var="category">
      <option value="${category.id}">${category.name}</option>
    </c:forEach>
  </select>
  <input type="submit" value="Add Dish" />
</form>

<p><a href="/logout">Logout</a></p>
</body>
</html>
