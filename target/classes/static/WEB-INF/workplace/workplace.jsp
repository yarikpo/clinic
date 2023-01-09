<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>workplaceId: ${workplace.workplaceId}</p>
	<p>roomNumber: ${workplace.roomNumber}</p>
	<p>placeNumber: ${workplace.placeNumber}</p>


    <a href="${pageContext.request.contextPath}/workplaces/edit/${workplace.workplaceId}">Edit</a>

	<a href="${pageContext.request.contextPath}/workplaces">Workplaces</a>

	<form:form
              action="${pageContext.request.contextPath}/workplaces/delete/${workplace.workplaceId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>