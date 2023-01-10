<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>APPOINTMENTS</p>

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

        <a href="${pageContext.request.contextPath}/appointments/create">Add</a>

    </body>
</html>