<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>client_id: ${client.clientId}</p>
	<p>email: ${client.email}</p>
	<p>name: ${client.name}</p>
	<p>sex: ${client.sex}</p>
	<p>birth_date: ${client.birthDate}</p>
	<p>tel_num: ${client.telNum}</p>
	<p>address: ${client.address}</p>
	<p>invalidity_info: ${client.invalidityInfo}</p>
	<p>pension_certificate_number: ${client.pensionCertificateNumber}</p>

    <a href="${pageContext.request.contextPath}/clients/edit/${client.clientId}">Edit</a>

	<a href="${pageContext.request.contextPath}/clients">Clients</a>

	<form:form
              action="${pageContext.request.contextPath}/clients/delete/${client.clientId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>