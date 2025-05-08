<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Products</title>
</head>
<body>
<h1>Product List</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Category</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>${product.category.name}</td>
      <td>
        <a href="<c:url value='/product/edit/${product.id}'/>">Edit</a>
        <a href="<c:url value='/product/delete/${product.id}'/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<c:url value='/product/create'/>">Create New Product</a>
</body>
</html>
