<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>Appointment</h1>

<form:form modelAttribute="appointment"
          action="${pageContext.request.contextPath}/appointments/save"
          method="POST">
   <table>
       <tr>
            <td><form:label path = "doctorId">doctorId</form:label></td>
            <form:select path = "doctorId">
                <form:option value="${appointment.doctorId}" />
                <form:options  items="${allowedDoctorIds}" />
            </form:select>
       </tr>
       <tr>
            <td><form:label path = "clientId">clientId</form:label></td>
            <form:select path = "clientId">
                <form:option value="${appointment.clientId}" />
                <form:options  items="${allowedClientIds}" />
            </form:select>
       </tr>
       <tr>
            <td><form:label path = "favourId">favourId</form:label></td>
            <form:select path = "favourId">
                <form:option value="${appointment.favourId}" />
                <form:options  items="${allowedFavourIds}" />
            </form:select>
       </tr>
       <tr>
            <td><form:label path = "workplaceId">workplaceId</form:label></td>
            <form:select path = "workplaceId">
                <form:option value="${appointment.workplaceId}" />
                <form:options  items="${allowedWorkplaceIds}" />
            </form:select>
       </tr>

       <tr>
            <td><form:label path = "date">date</form:label></td>
            <td><form:input path = "date" value = "${appointment.date}" type="datetime-local" pattern="yyyy-MM-dd HH:mm:ss" /></td>
       </tr>



       <td colspan="2">
           <input type="submit" value="Update" />
       </td>
   </table>

   <a href="${pageContext.request.contextPath}/appointments">Appointments</a>
</form:form>