<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>favourId: ${owner.ownerId}</p>
	<p>name: ${owner.email}</p>
	<p>cost: ${owner.password}</p>


    <a href="${pageContext.request.contextPath}/owners/edit/${owner.ownerId}">Edit</a>

	<a href="${pageContext.request.contextPath}/owners">Owners</a>

	<form:form
              action="${pageContext.request.contextPath}/owners/delete/${owner.ownerId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>