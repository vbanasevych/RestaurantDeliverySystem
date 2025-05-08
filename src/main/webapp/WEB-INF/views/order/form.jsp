<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order Form</title>
</head>
<body>
<h1>${formTitle}</h1>
<form action="<c:url value='/order/save'/>" method="post">
  <input type="hidden" name="id" value="${order.id}"/>
  <label for="customer">Customer:</label>
  <select id="customer" name="customer.id">
    <c:forEach var="customer" items="${customers}">
      <option value="${customer.id}" ${customer.id == order.customer.id ? 'selected' : ''}>${customer.name}</option>
    </c:forEach>
  </select>
  <br/>
  <label for="date">Date:</label>
  <input type="date" id="date" name="date" value="${order.date}" required/>
  <br/>
  <label for="status">Status:</label>
  <input type="text" id="status" name="status" value="${order.status}" required/>
  <br/>
  <button type="submit">Save</button>
</form>
</body>
</html>
