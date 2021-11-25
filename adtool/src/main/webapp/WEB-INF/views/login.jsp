<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AD Tool</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">AD Tool</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align=center>Login</div>
				</div>
				<div class="panel-body">
					<form:form action="access" cssClass="form-horizontal"
						method="post" modelAttribute="login">

						<div class="form-group">
							<label for="userName" class="col-md-3 control-label">Benutzername</label>
							<div class="col-md-9">
								<form:input path="userName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="firstName" class="col-md-3 control-label">Kennwort</label>
							<div class="col-md-9">
								<form:input path="password" type="password" cssClass="form-control" />
							</div>
						</div>
				</div>
				
					<div id="button">
						<form:button id="button" >Login</form:button>
					</div>
				

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>