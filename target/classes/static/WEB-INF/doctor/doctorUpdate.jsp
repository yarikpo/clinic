<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Doctor</h1>

<form:form modelAttribute="doctor"
          action="${pageContext.request.contextPath}/doctors/update/${doctor.doctorId}"
          method="POST">
   <form:hidden path="doctorId" />
   <table>
       <tr>
            <td><form:label path = "seriesNumber">seriesNumber</form:label></td>
            <form:select path = "seriesNumber">
                <form:option value="${doctor.seriesNumber}" />
                <form:options  items="${allAllowed}" />
            </form:select>
       </tr>


       <tr>
            <td><form:label path = "email">email</form:label></td>
            <td><form:input path = "email" value = "${doctor.email}" /></td>
       </tr>
       <tr>
            <td><form:label path = "password">password</form:label></td>
            <td><form:input path = "password" value = "${doctor.password}" /></td>
       </tr>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" value = "${doctor.name}" /></td>
       </tr>
       <tr>
            <td><form:label path = "specialization">specialization</form:label></td>
            <td><form:input path = "specialization" value = "${doctor.specialization}" /></td>
       </tr>
       <tr>
            <td><form:label path = "ITN">ITN</form:label></td>
            <td><form:input path = "ITN" value = "${doctor.ITN}" /></td>
       </tr>
       <tr>
            <td><form:label path = "telNum">telNum</form:label></td>
            <td><form:input path = "telNum" value = "${doctor.telNum}" /></td>
       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/doctors">Doctors</a>
</form:form>