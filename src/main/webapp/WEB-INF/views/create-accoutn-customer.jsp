<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${param.success  eq 1}">
         user ajouter
  </c:if>


	<form:form action="create-account" method="post"
		modelAttribute="customer" enctype="multipart/form-data"
		accept-charset="utf-8">
		<div>
			<label> Email </label>
			<form:input path="login" />
			<form:errors path="login" />

		</div>
		<div>
			<label> password </label>
			<div>
				<form:password path="password" />
				<form:errors path="password" />
			</div>
		</div>


		<div>
			<label> confirmer Password : </label>
			<div>
				<form:input path="confirmPassword" />
				<form:errors path="confirmPassword" />
			</div>
		</div>


		<div>
			<label> firstName </label>
			<form:input path="firstName" />
			<form:errors path="firstName" />

		</div>

		<div>
			<label> LastName </label>
			<form:input path="lastName" />
			<form:errors path="lastName" />


		</div>

		<div>
			<label> Phone </label>
			<div>
				<form:input path="phone" />
				<form:errors path="phone" />
			</div>
		</div>
		<div>
			<label> Photo </label> <input type="file" name="file" />

		</div>

		<div>
			<div>
				<input type="submit" value="add" />
			</div>
		</div>
	</form:form>


</body>
</html>