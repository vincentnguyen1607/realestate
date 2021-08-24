<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<security:authorize access="!isAuthenticated()">
    <a href="${pageContext.request.contextPath}/login">Login</a>
</security:authorize>

<security:authorize access="isAuthenticated()">
    User: <security:authentication property="principal.username"/>
    Role(s): <security:authentication property="principal.authorities"/>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</security:authorize>
<p>
   <a href="${pageContext.request.contextPath}/product-form">Add Property</a>
</p>

</body>

</html>