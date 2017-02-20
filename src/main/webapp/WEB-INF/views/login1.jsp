<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>authentification</title>
</head>
<body>


	<c:if test="${param.activate  eq 1}">
		<spring:message code="user.label.message.active" />
	</c:if>


	<c:if test="${param.error  eq 1}">
		<div>
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		</div>
	</c:if>

	<form action="login" method="post">
		<div>
			<label> <spring:message code="label.login" />
			</label> <input type="text" name="useranme" />

		</div>
		<div>
			<label> Password </label>
			<div>
				<input type="password" name="password" />
			</div>
		</div>



		<div>
			<div>
				<input type="submit" value="Sign In" />
			</div>
		</div>
	</form>

	<a href="auth/google" class="btn btn-danger btn-fab"> connect by
		google plus </a>

	<a href="${pageContext.request.contextPath}/auth/facebook"> connect
		by facebook </a>


</body>
</html>