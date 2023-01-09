<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Workplace</h1>

<form:form modelAttribute="workplace"
          action="${pageContext.request.contextPath}/workplaces/save"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "roomNumber">roomNumber</form:label></td>
            <td><form:input path = "roomNumber" /></td>
       </tr>
       <tr>
            <td><form:label path = "placeNumber">placeNumber</form:label></td>
            <td><form:input path = "placeNumber" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Save" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/workplaces">Workplaces</a>
</form:form>