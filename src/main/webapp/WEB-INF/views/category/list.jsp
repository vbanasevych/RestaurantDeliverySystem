<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Categories</title>
</head>
<body>
<h1>Category List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>
                <a href="<c:url value='/category/edit/${category.id}'/>">Edit</a>
                <a href="<c:url value='/category/delete/${category.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value='/category/create'/>">Create New Category</a>
</body>
</html>
