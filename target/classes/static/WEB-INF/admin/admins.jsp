<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>ADMINS</p>

        <table>
            <thead>
                <td>admin_id</td>
                <td>series_number</td>
                <td>email</td>
                <td>password</td>
                <td>name</td>
                <td>tel_num</td>
                <td>ITN</td>
            </thead>
            <c:forEach var="admin" items="${admins}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/admins/${admin.adminId}">${admin.adminId}</a></td>
                <td><a href="${pageContext.request.contextPath}/passports/${admin.seriesNumber}">${admin.seriesNumber}</a></td>
                
                <td>${admin.email}</td>
                <td>${admin.password}</td>
                <td>${admin.name}</td>
                <td>${admin.telNum}</td>
                <td>${admin.ITN}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/admins/create">Add</a>

    </body>
</html>