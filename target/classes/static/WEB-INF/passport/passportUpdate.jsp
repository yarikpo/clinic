<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Passport</h1>

<form:form modelAttribute="passport"
          action="${pageContext.request.contextPath}/passports/update/${passport.seriesNumber}"
          method="POST">

   <table>
       <tr>
            <td><form:label path = "seriesNumber">seriesNumber</form:label></td>
            <td><form:input path = "seriesNumber" value = "${passport.seriesNumber}" /></td>
       </tr>
       <tr>
            <td><form:label path = "given">given</form:label></td>
            <td><form:input path = "given" value = "${passport.given}" /></td>
       </tr>
       <tr>
            <td><form:label path = "givenDate">givenDate</form:label></td>
            <td><form:input path = "givenDate" type="date" pattern="yyyy/MM/dd" value = "${passport.givenDate}" /></td>
       </tr>
       <tr>
            <td><form:label path = "address">address</form:label></td>
            <td><form:input path = "address" value = "${passport.address}" /></td>

       </tr>


       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/passports">Passports</a>
</form:form>