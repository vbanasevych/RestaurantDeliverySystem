<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Form</title>
</head>
<body>
<h1>${formTitle}</h1>
<form action="<c:url value='/category/save'/>" method="post">
    <input type="hidden" name="id" value="${category.id}"/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${category.name}" required/>
    <br/>
    <button type="submit">Save</button>
</form>
</body>
</html>
