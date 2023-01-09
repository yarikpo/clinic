<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Favour</h1>

<form:form modelAttribute="favour"
          action="${pageContext.request.contextPath}/favours/update/${favour.favourId}"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" value = "${favour.name}" /></td>
       </tr>
       <tr>
            <td><form:label path = "cost">cost</form:label></td>
            <td><form:input path = "cost" value = "${favour.cost}" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/favours">Favours</a>
</form:form>