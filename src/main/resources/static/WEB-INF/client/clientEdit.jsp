<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Client</h1>

<form:form modelAttribute="client"
          action="${pageContext.request.contextPath}/clients/save"
          method="POST">
   <form:hidden path="clientId" />
   <table>
       <tr>
            <td><form:label path = "email">email</form:label></td>
            <td><form:input path = "email" /></td>
       </tr>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" /></td>
       </tr>
       <tr>
            <td><form:label path = "sex">sex</form:label></td>
            <!-- <td><form:input path = "sex" /></td> -->
            <td>
                <form:select path = "sex">
                    <option value = "male" >male</option>
                    <option value = "female" >female</option>
                </form:select>
            </td>
       </tr>
       <tr>
            <td><form:label path = "birthDate">birth date</form:label></td>
            <td><form:input path = "birthDate" type="date" pattern="yyyy/MM/dd" /></td>
       </tr>
       <tr>
            <td><form:label path = "telNum">tel num</form:label></td>
            <td><form:input path = "telNum" /></td>
       </tr>
       <tr>
            <td><form:label path = "address">address</form:label></td>
            <td><form:input path = "address" /></td>
       </tr>
       <tr>
            <td><form:label path = "invalidityInfo">invalidity info</form:label></td>
            <td><form:input path = "invalidityInfo" /></td>
       </tr>
       <tr>
            <td><form:label path = "pensionCertificateNumber">pension certificate number</form:label></td>
            <td><form:input path = "pensionCertificateNumber" /></td>
       </tr>

       <td colspan="2">
           <input type="submit" value="Save" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/clients">Clients</a>
</form:form>