<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>code: ${appointment.appointmentNumber}</p>
	<p>doctorId: ${appointment.doctorId}</p>
	<p>name: ${appointment.clientId}</p>
	<p>givenDate: ${appointment.favourId}</p>
	<p>givenDate: ${appointment.workplaceId}</p>
	<p>givenDate: ${appointment.date}</p>

    <a href="${pageContext.request.contextPath}/appointments/edit/${appointment.appointmentNumber}">Edit</a>

	<a href="${pageContext.request.contextPath}/appointments">Appointments</a>

	<form:form
              action="${pageContext.request.contextPath}/appointments/delete/${appointment.appointmentNumber}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>