<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>series_number: ${passport.seriesNumber}</p>
	<p>given: ${passport.given}</p>
	<p>given_date: ${passport.givenDate}</p>
	<p>address: ${passport.address}</p>


    <a href="${pageContext.request.contextPath}/passports/edit/${passport.seriesNumber}">Edit</a>

	<a href="${pageContext.request.contextPath}/passports">Passports</a>

	<form:form
              action="${pageContext.request.contextPath}/passports/delete/${passport.seriesNumber}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>