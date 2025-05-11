<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Register</title>
    <style>
        /* Додати стилі для форми */
        label {
            font-weight: bold;
        }
        input, select {
            margin-bottom: 10px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>User Registration</h2>

<!-- Повідомлення про помилки -->
<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>

<form:form method="post" modelAttribute="user">
    <label>Username:</label>
    <form:input path="username"/><br/><br/>

    <label>Password:</label>
    <form:password path="password"/><br/><br/>

    <label>Role:</label>
    <form:select path="role">
        <form:option value="CUSTOMER">Customer</form:option>
        <form:option value="ADMIN">Admin</form:option>
    </form:select><br/><br/>

    <input type="submit" value="Register"/>
</form:form>

<p>Already have an account? <a href="/login">Log in</a></p>

</body>
</html>
