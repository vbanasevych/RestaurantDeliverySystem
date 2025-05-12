<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>

<form:form method="post" modelAttribute="user" action="/register">
    <div>
        <label for="username">User name:</label>
        <form:input path="username" id="username" />
    </div>

    <div>
        <label for="password">Password:</label>
        <form:password path="password" id="password" />
    </div>

    <div>
        <label for="role">Role:</label>
        <form:select path="role">
            <form:option value="CUSTOMER" label="Customer"/>
            <form:option value="ADMIN" label="Admin"/>
        </form:select>
    </div>

    <div>
        <input type="submit" value="Register" />
    </div>
</form:form>
</body>
</html>
