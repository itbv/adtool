<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D Tool based on Spring MVC 5 + Hibernate 5 + JSP +
	PostgreSQL</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">AD Tool based on Spring MVC 5 +
				Hibernate 5 + JSP + PostgreSQL</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Benutzer hinzufügen</div>
				</div>
				<div class="panel-body">
					<a href="/adtool/logout" onclick="if (!(confirm('Benutzer wiklich abmelden?'))) return false">Abmelden</a>
					<form:form action="saveUser" cssClass="form-horizontal"
						method="post" modelAttribute="user">

						<!-- need to associate this data with user id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="userName" class="col-md-3 control-label">Benutzername</label>
							<div class="col-md-9">
								<form:input path="userName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="firstName" class="col-md-3 control-label">Vorname</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="surname" class="col-md-3 control-label">Nachname</label>
							<div class="col-md-9">
								<form:input path="surname" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="col-md-3 control-label">Abteilung</label>
							<div class="col-md-9">
								<form:input path="department" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">E-Mail</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>
				</div>

				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<form:button name="save" cssClass="btn btn-primary">Speichern</form:button>
					</div>
				</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>