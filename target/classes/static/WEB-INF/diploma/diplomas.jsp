<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>DIPLOMAS</p>

        <table>
            <thead>
                <td>code</td>
                <td>doctorId</td>
                <td>name</td>
                <td>givenDate</td>
            </thead>
            <c:forEach var="diploma" items="${diplomas}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/diplomas/${diploma.code}">${diploma.code}</a></td>
                <td><a href="${pageContext.request.contextPath}/doctors/${diploma.doctorId}">${diploma.doctorId}</a></td>

                <td>${diploma.name}</td>
                <td>${diploma.givenDate}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/diplomas/create">Add</a>

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>