<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Diploma</h1>

<form:form modelAttribute="diploma"
          action="${pageContext.request.contextPath}/diplomas/save"
          method="POST">
   <table>
        <tr>
            <td><form:label path = "code">code</form:label></td>
            <td><form:input path = "code" /></td>
        </tr>
       <tr>
            <td><form:label path = "doctorId">doctorId</form:label></td>
            <form:select path = "doctorId">
                <form:options  items="${allAllowed}" />
            </form:select>
       </tr>


       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" /></td>
       </tr>
       <tr>
            <td><form:label path = "givenDate">givenDate</form:label></td>
            <td><form:input path = "givenDate" type="date" pattern="yyyy/MM/dd" /></td>
       </tr>



       <td colspan="2">
           <input type="submit" value="Save" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/diplomas">Diplomas</a>
</form:form>