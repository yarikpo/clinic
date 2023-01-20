<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>OWNERS</p>

        <table>
            <thead>
                <td>ownerId</td>
                <td>email</td>
                <td>password</td>
            </thead>
            <c:forEach var="owner" items="${owners}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/owners/${owner.ownerId}">${owner.ownerId}</a></td>
                <td>${owner.email}</td>
                <td>${owner.password}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/owners/create">Add</a>

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>