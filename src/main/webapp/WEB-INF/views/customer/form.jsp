<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Customer Form</title>
</head>
<body>
<h1>${formTitle}</h1>
<form action="<c:url value='/customer/save'/>" method="post">
  <input type="hidden" name="id" value="${customer.id}"/>
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${customer.name}" required/>
  <br/>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${customer.email}" required/>
  <br/>
  <button type="submit">Save</button>
</form>
</body>
</html>
