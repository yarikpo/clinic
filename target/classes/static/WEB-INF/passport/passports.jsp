<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>PASSPORTS</p>

        <table>
            <thead>
                <td>seriesNumber</td>
                <td>given</td>
                <td>givenDate</td>
                <td>address</td>
            </thead>
            <c:forEach var="passport" items="${passports}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/passports/${passport.seriesNumber}">${passport.seriesNumber}</a></td>
                <td>${passport.given}</td>
                <td>${passport.givenDate}</td>
                <td>${passport.address}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/passports/create">Add</a>

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>