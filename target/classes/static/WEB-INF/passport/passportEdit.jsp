<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Passport</h1>

<form:form modelAttribute="passport"
          action="${pageContext.request.contextPath}/passports/save"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "seriesNumber">seriesNumber</form:label></td>
            <td><form:input path = "seriesNumber" /></td>
       </tr>
       <tr>
            <td><form:label path = "given">given</form:label></td>
            <td><form:input path = "given" /></td>
       </tr>
       <tr>
            <td><form:label path = "givenDate">givenDate</form:label></td>
            <td><form:input path = "givenDate" type="date" pattern="yyyy/MM/dd" /></td>
       </tr>
       <tr>
            <td><form:label path = "address">address</form:label></td>
            <td><form:input path = "address" /></td>

       </tr>


       <td colspan="2">
           <input type="submit" value="Save" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/passports">Passports</a>
</form:form>