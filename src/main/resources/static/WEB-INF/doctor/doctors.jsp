<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>DOCTORS</p>

        <table>
            <thead>
                <td>doctorId</td>
                <td>seriesNumber</td>
                <td>email</td>
                <td>password</td>
                <td>name</td>
                <td>specialization</td>
                <td>ITN</td>
                <td>telNum</td>
            </thead>
            <c:forEach var="doctor" items="${doctors}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/doctors/${doctor.doctorId}">${doctor.doctorId}</a></td>
                <td><a href="${pageContext.request.contextPath}/passports/${doctor.seriesNumber}">${doctor.seriesNumber}</a></td>

                <td>${doctor.email}</td>
                <td>${doctor.password}</td>
                <td>${doctor.name}</td>
                <td>${doctor.specialization}</td>
                <td>${doctor.ITN}</td>
                <td>${doctor.telNum}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/doctors/create">Add</a>

    </body>
</html>