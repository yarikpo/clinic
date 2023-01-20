<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<p>Home</p>


    <a href="${pageContext.request.contextPath}/admins">Admins</a>

    <a href="${pageContext.request.contextPath}/appointments">Appointments</a>

	<a href="${pageContext.request.contextPath}/clients">Clients</a>

	<a href="${pageContext.request.contextPath}/diplomas">Diplomas</a>

	<a href="${pageContext.request.contextPath}/doctors">Doctors</a>

	<a href="${pageContext.request.contextPath}/favours">Favours</a>

	<a href="${pageContext.request.contextPath}/owners">Owners</a>

	<a href="${pageContext.request.contextPath}/passports">Passports</a>

	<a href="${pageContext.request.contextPath}/statistics">Statistics</a>

	<a href="${pageContext.request.contextPath}/workplaces">Workplaces</a>

	<a href="${pageContext.request.contextPath}/checks">Report</a>

	<br />
	<form:form
        action="${pageContext.request.contextPath}/home"
        method="POST">
        <input type="submit" value="Log Out" />
    </form:form>



</body>
</html>