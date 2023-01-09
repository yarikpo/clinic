<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>code: ${diploma.code}</p>
	<p>doctorId: ${diploma.doctorId}</p>
	<p>name: ${diploma.name}</p>
	<p>givenDate: ${diploma.givenDate}</p>

    <a href="${pageContext.request.contextPath}/diplomas/edit/${diploma.code}">Edit</a>

	<a href="${pageContext.request.contextPath}/diplomas">Diplomas</a>

	<form:form
              action="${pageContext.request.contextPath}/diplomas/delete/${diploma.code}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>