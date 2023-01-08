<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Admin</h1>

<form:form modelAttribute="admin"
          action="${pageContext.request.contextPath}/admins/update/${admin.adminId}"
          method="POST">
   <form:hidden path="adminId" />
   <table>
       <tr>
            <td><form:label path = "seriesNumber">seriesNumber</form:label></td>
            <form:select path = "seriesNumber">
                <form:option value="${admin.seriesNumber}" />
                <form:options  items="${allAllowed}" />
            </form:select>
       </tr>


       <tr>
            <td><form:label path = "email">email</form:label></td>
            <td><form:input path = "email" /></td>
       </tr>
       <tr>
            <td><form:label path = "password">password</form:label></td>
            <td><form:input path = "password" /></td>
       </tr>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" /></td>
       </tr>
       <tr>
            <td><form:label path = "telNum">telNum</form:label></td>
            <td><form:input path = "telNum" /></td>
       </tr>
       <tr>
            <td><form:label path = "ITN">ITN</form:label></td>
            <td><form:input path = "ITN" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/admins">Admins</a>
</form:form>