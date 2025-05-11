<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Login</title>
</head>
<body>
<h2>Login</h2>

<c:if test="${not empty loginError}">
  <p style="color:red;">${loginError}</p>
</c:if>

<form method="post" action="/login">
  <label>Username:</label>
  <input type="text" name="username"/><br/><br/>

  <label>Password:</label>
  <input type="password" name="password"/><br/><br/>

  <label>Role:</label>
  <select name="role">
    <option value="CUSTOMER"
            <c:if test="${role == 'customer'}">selected</c:if>>Customer</option>
    <option value="ADMIN"
            <c:if test="${role == 'admin'}">selected</c:if>>Admin</option>
  </select><br/><br/>

  <input type="submit" value="Login"/>
</form>

<p>Don't have an account? <a href="/register">Register</a></p>
</body>
</html>
