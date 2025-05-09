<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customers</title>
</head>
<body>
<h1>Customer List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>
                <a href="<c:url value='/customer/edit/${customer.id}'/>">Edit</a>
                <a href="<c:url value='/customer/delete/${customer.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value='/customer/create'/>">Create New Customer</a>
</body>
</html>
