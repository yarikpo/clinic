<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>FAVOURS</p>

        <table>
            <thead>
                <td>favourId</td>
                <td>name</td>
                <td>cost</td>
            </thead>
            <c:forEach var="favour" items="${favours}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/favours/${favour.favourId}">${favour.favourId}</a></td>
                <td>${favour.name}</td>
                <td>${favour.cost}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/favours/create">Add</a>

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>