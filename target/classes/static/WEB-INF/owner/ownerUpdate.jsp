<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Owner</h1>

<form:form modelAttribute="owner"
          action="${pageContext.request.contextPath}/owners/update/${owner.ownerId}"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "email">email</form:label></td>
            <td><form:input path = "email" value = "${owner.email}" /></td>
       </tr>
       <tr>
            <td><form:label path = "password">password</form:label></td>
            <td><form:input path = "password" value = "${owner.password}" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/owners">Owners</a>
</form:form>