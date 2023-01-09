<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Favour</h1>

<form:form modelAttribute="favour"
          action="${pageContext.request.contextPath}/favours/save"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" /></td>
       </tr>
       <tr>
            <td><form:label path = "cost">cost</form:label></td>
            <td><form:input path = "cost" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Save" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/favours">Favours</a>
</form:form>