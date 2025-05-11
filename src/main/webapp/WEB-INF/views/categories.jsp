<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Categories</title></head>
<body>
<h2>Categories</h2>
<ul>
    <c:forEach items="${categories}" var="cat">
        <li><a href="/dishes?categoryId=${cat.id}">${cat.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>