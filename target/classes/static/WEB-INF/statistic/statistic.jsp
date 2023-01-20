<%@taglib uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <body>
        <style>
            table, th, td {
              border: 1px solid;
            }
        </style>
        <p>STATISTIC</p>

        <table>

            <thead>
                <c:forEach var="attr" items="${head.attributes}">
                <td>${attr}</td>
                </c:forEach>
            </thead>

            <c:forEach var="attrs" items="${body}">
            <tr>
                <c:forEach var="attr" items="${attrs.attributes}">
                <td>${attr}</td>
                </c:forEach>
            </tr>
            </c:forEach>
        </table>

        <!-- <a href="${pageContext.request.contextPath}/workplaces/create">Add</a> -->
        <form:form modelAttribute="clientId"
                  action="${pageContext.request.contextPath}/statistics"
                  method="POST">
                  <form:label path = "clientId">clientId</form:label>
                  <form:input path = "clientId" type="number" />
                  <input type="submit" value="Check" />
        </form:form>
        <a href="${pageContext.request.contextPath}/statistics?statement=doctorsByHours">doctorsByHours</a>
        <br />
        <a href="${pageContext.request.contextPath}/statistics?statement=doctorsByMoney">doctorsByMoney</a>
        <br />
        <a href="${pageContext.request.contextPath}/statistics?statement=favoursByAllClients">favoursByAllClients</a>
        <br />

        <a href="${pageContext.request.contextPath}/home">Home</a>

    </body>
</html>