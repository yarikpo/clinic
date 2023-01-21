<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

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
    <br />


        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>APPOINTMENTS FOR TODAY</p>

        <table>
            <thead>
                <td>appointmentNumber</td>
                <td>doctorId</td>
                <td>clientId</td>
                <td>favourId</td>
                <td>workplaceId</td>
                <td>date</td>
            </thead>
            <c:forEach var="appointment" items="${appointments}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/appointments/${appointment.appointmentNumber}">${appointment.appointmentNumber}</a></td>
                <td><a href="${pageContext.request.contextPath}/doctors/${appointment.doctorId}">${appointment.doctorId}</a></td>
                <td><a href="${pageContext.request.contextPath}/clients/${appointment.clientId}">${appointment.clientId}</a></td>
                <td><a href="${pageContext.request.contextPath}/favours/${appointment.favourId}">${appointment.favourId}</a></td>
                <td><a href="${pageContext.request.contextPath}/workplaces/${appointment.workplaceId}">${appointment.workplaceId}</a></td>

                <td>${appointment.date}</td>
            </tr>
            </c:forEach>
        </table>



</body>
</html>