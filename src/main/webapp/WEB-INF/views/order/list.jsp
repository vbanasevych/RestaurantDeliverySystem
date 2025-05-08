<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Orders</title>
</head>
<body>
<h1>Order List</h1>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Customer</th>
    <th>Date</th>
    <th>Status</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="order" items="${orders}">
    <tr>
      <td>${order.id}</td>
      <td>${order.customer.name}</td>
      <td>${order.date}</td>
      <td>${order.status}</td>
      <td>
        <a href="<c:url value='/order/edit/${order.id}'/>">Edit</a>
        <a href="<c:url value='/order/delete/${order.id}'/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="<c:url value='/order/create'/>">Create New Order</a>
</body>
</html>
