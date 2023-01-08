<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>adminId: ${admin.adminId}</p>
	<p>seriesNumber: ${admin.seriesNumber}</p>
	<p>email: ${admin.email}</p>
	<p>password: ${admin.password}</p>
	<p>name: ${admin.name}</p>
	<p>telNum: ${admin.telNum}</p>
	<p>ITN: ${admin.ITN}</p>

    <a href="${pageContext.request.contextPath}/admins/edit/${admin.adminId}">Edit</a>

	<a href="${pageContext.request.contextPath}/admins">Admins</a>

	<form:form
              action="${pageContext.request.contextPath}/admins/delete/${admin.adminId}"
              method="POST">

        <input type="submit" value="Delete" />
    </form:form>

</body>
</html>