<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>D Tool based on Spring MVC 5 + Hibernate 5 + JSP + PostgreSQL</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">AD Tool based on Spring MVC 5 + Hibernate 5 + JSP + PostgreSQL</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Cars</div>
				</div>
				<div class="panel-body">
					<form:form action="saveCar" cssClass="form-horizontal"
						method="post" modelAttribute="car">

						<!-- need to associate this data with car id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="brandName" class="col-md-3 control-label">Brand</label>
							<div class="col-md-9">
								<form:input path="brandName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="type" class="col-md-3 control-label">Vehicle-Type</label>
							<div class="col-md-9">
								<form:input path="type" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="ps" class="col-md-3 control-label">PS</label>
							<div class="col-md-9">
								<form:input path="ps" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>