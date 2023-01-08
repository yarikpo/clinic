<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>adminId: ${admin.adminId}</p>
	<p>email: ${admin.seriesNumber}</p>
	<p>name: ${admin.email}</p>
	<p>sex: ${admin.password}</p>
	<p>birth_date: ${admin.name}</p>
	<p>tel_num: ${admin.telNum}</p>
	<p>address: ${admin.ITN}</p>

    <a href="${pageContext.request.contextPath}/admins/edit/${admin.adminId}">Edit</a>

	<a href="${pageContext.request.contextPath}/admins">Admins</a>

	<form:form
              action="${pageContext.request.contextPath}/admins/delete/${admin.adminId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>