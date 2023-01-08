<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>doctorId: ${doctor.doctorId}</p>
	<p>seriesNumber: ${doctor.seriesNumber}</p>
	<p>email: ${doctor.email}</p>
	<p>password: ${doctor.password}</p>
	<p>name: ${doctor.name}</p>
	<p>specialization: ${doctor.specialization}</p>
	<p>ITN: ${doctor.ITN}</p>
	<p>telNum: ${doctor.telNum}</p>

    <a href="${pageContext.request.contextPath}/doctors/edit/${doctor.doctorId}">Edit</a>

	<a href="${pageContext.request.contextPath}/doctors">Doctors</a>

	<form:form
              action="${pageContext.request.contextPath}/doctors/delete/${doctor.doctorId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>