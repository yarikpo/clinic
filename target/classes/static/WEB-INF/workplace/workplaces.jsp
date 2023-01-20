<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>WORKPLACES</p>

        <table>
            <thead>
                <td>workplaceId</td>
                <td>roomNumber</td>
                <td>placeNumber</td>
            </thead>
            <c:forEach var="workplace" items="${workplaces}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/workplaces/${workplace.workplaceId}">${workplace.workplaceId}</a></td>
                <td>${workplace.roomNumber}</td>
                <td>${workplace.placeNumber}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/workplaces/create">Add</a>

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>