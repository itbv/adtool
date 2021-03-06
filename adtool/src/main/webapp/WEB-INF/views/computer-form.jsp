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
					<div class="panel-title">Computer hinzufügen</div>
				</div>
				<div class="panel-body">
					<form:form action="saveComputer" cssClass="form-horizontal"
						method="post" modelAttribute="computer">

						<!-- need to associate this data with computer id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="computerName" class="col-md-3 control-label">Computer-Name</label>
							<div class="col-md-9">
								<form:input path="computerName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Typ</label>
							<div class="col-md-9">
								<form:select path="computerTyp" multiple="false">
									<form:option value="NONE" label="--- Select ---" />
									<form:options items="${computerTypList}" />
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Speichern</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>