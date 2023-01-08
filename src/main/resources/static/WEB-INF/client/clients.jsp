<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>CLIENTS</p>

        <table>
            <thead>
                <td>client_id</td>
                <td>email</td>
                <td>name</td>
                <td>sex</td>
                <td>birth_date</td>
                <td>tel_num</td>
                <td>address</td>
                <td>invalidity_info</td>
                <td>pension_certificate_number</td>
            </thead>
            <c:forEach var="client" items="${clients}">
            <tr>

                <td><a href="${pageContext.request.contextPath}/clients/${client.clientId}">${client.clientId}</a></td>
                <td>${client.email}</td>
                <td>${client.name}</td>
                <td>${client.sex}</td>
                <td>${client.birthDate}</td>
                <td>${client.telNum}</td>
                <td>${client.address}</td>
                <td>${client.invalidityInfo}</td>
                <td>${client.pensionCertificateNumber}</td>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/clients/create">Add</a>

    </body>
</html>