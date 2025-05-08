<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Form</title>
</head>
<body>
<h1>${formTitle}</h1>
<form action="<c:url value='/product/save'/>" method="post">
  <input type="hidden" name="id" value="${product.id}"/>
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${product.name}" required/>
  <br/>
  <label for="price">Price:</label>
  <input type="number" id="price" name="price" value="${product.price}" required/>
  <br/>
  <label for="category">Category:</label>
  <select id="category" name="category.id">
    <c:forEach var="category" items="${categories}">
      <option value="${category.id}" ${category.id == product.category.id ? 'selected' : ''}>${category.name}</option>
    </c:forEach>
  </select>
  <br/>
  <button type="submit">Save</button>
</form>
</body>
</html>
