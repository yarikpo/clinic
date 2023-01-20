<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<p>Login</p>

    <form:form modelAttribute="user"
              action="${pageContext.request.contextPath}/login"
              method="POST">

        <form:label path = "login">Login:</form:label>
        <form:input path = "login" />
        <form:label path = "password">Password:</form:label>
        <form:input path = "password" />
        <br />
        <input type="submit" value="Login" />
    </form:form>



</body>
</html>