<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Client</h1>

<form:form modelAttribute="client"
          action="${pageContext.request.contextPath}/clients/update/${client.clientId}"
          method="POST">
   <form:hidden path="clientId" />
   <table>
       <tr>
            <td><form:label path = "email">email</form:label></td>
            <td><form:input path = "email" value="${client.email}" /></td>
       </tr>
       <tr>
            <td><form:label path = "name">name</form:label></td>
            <td><form:input path = "name" value="${client.name}" /></td>
       </tr>
       <tr>
            <td><form:label path = "sex">sex</form:label></td>
            <!-- <td><form:input path = "sex" value="${client.sex}" /></td> -->
            <td>
                <form:select path = "sex" value="${client.sex}">
                    <option value = '${client.sex == "male" ? "male" : "female"}' >${client.sex == "male" ? "male" : "female"}</option>
                    <option value = '${client.sex == "male" ? "female" : "male"}' >${client.sex == "male" ? "female" : "male"}</option>
                </form:select>
            </td>
       </tr>
       <tr>
            <td><form:label path = "birthDate">birth date</form:label></td>
            <td><form:input path = "birthDate" type="date" pattern="yyyy/MM/dd" value="${client.birthDate}" /></td>
       </tr>
       <tr>
            <td><form:label path = "telNum">tel num</form:label></td>
            <td><form:input path = "telNum" value="${client.telNum}" /></td>
       </tr>
       <tr>
            <td><form:label path = "address">address</form:label></td>
            <td><form:input path = "address" value="${client.address}" /></td>
       </tr>
       <tr>
            <td><form:label path = "invalidityInfo">invalidity info</form:label></td>
            <td><form:input path = "invalidityInfo" value="${client.invalidityInfo}" /></td>
       </tr>
       <tr>
            <td><form:label path = "pensionCertificateNumber">pension certificate number</form:label></td>
            <td><form:input path = "pensionCertificateNumber" value="${client.pensionCertificateNumber}" /></td>
       </tr>

       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/clients">Clients</a>
</form:form>