<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Workplace</h1>

<form:form modelAttribute="workplace"
          action="${pageContext.request.contextPath}/workplaces/update/${workplace.workplaceId}"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "roomNumber">roomNumber</form:label></td>
            <td><form:input path = "roomNumber" value = "${workplace.roomNumber}" /></td>
       </tr>
       <tr>
            <td><form:label path = "placeNumber">placeNumber</form:label></td>
            <td><form:input path = "placeNumber" value = "${workplace.placeNumber}" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/workplaces">Workplaces</a>
</form:form>