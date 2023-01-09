<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>favourId: ${favour.favourId}</p>
	<p>name: ${favour.name}</p>
	<p>cost: ${favour.cost}</p>


    <a href="${pageContext.request.contextPath}/favours/edit/${favour.favourId}">Edit</a>

	<a href="${pageContext.request.contextPath}/favours">Favours</a>

	<form:form
              action="${pageContext.request.contextPath}/favours/delete/${favour.favourId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>