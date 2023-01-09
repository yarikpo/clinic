<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Diploma</h1>

<form:form modelAttribute="diploma"
          action="${pageContext.request.contextPath}/diplomas/update/${diploma.code}"
          method="POST">
   <table>
        <tr>
            <td><form:label path = "code">code</form:label></td>
            <td><form:input path = "code" value = "${diploma.code}" /></td>
        </tr>
       <tr>
            <td><form:label path = "doctorId">doctorId</form:label></td>
            <form:select path = "doctorId">
                <form:option value="${diploma.doctorId}" />
                <form:options  items="${allAllowed}" />
            </form:select>
       </tr>


       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" value = "${diploma.name}" /></td>
       </tr>
       <tr>
            <td><form:label path = "givenDate">givenDate</form:label></td>
            <td><form:input path = "givenDate" value = "${diploma.givenDate}" type="date" pattern="yyyy/MM/dd" /></td>
       </tr>



       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/diplomas">Diplomas</a>
</form:form>