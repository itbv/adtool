<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<form:form action="suche" cssClass="form-horizontal" method="post"
		modelAttribute="user">
		<div class="container">
			<div class="col-md-offset-1 col-md-10">
				<h2 >AD-Tool</h2>
				<hr />

				<input type="button" id=button value="Add User"
					onclick="window.location.href='showForm'; return false;" />

				<form:input path="sucheUsername" cssClass="form-control" placeholder="Benutzername"/> 
				<div >
				<form:button  name="btnSuche">Suchen</form:button>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">Benutzerliste</div>
					</div>
					<div class="panel-body">
						<a href="/adtool/logout"
							onclick="if (!(confirm('Benutzer wirklich abmelden?'))) return false">Abmelden</a>
						<table class="table table-striped table-bordered">
							<tr>
								<th>Benutzername</th>
								<th>Vorname</th>
								<th>Nachname</th>
								<th>Abteilung</th>
								<th>E-Mail</th>
								<th>PC-Name</th>
								<th>Zustand</th>
								<th>Konto</th>
							</tr>

							<!-- loop over and print our users -->
							<c:forEach var="user" items="${users}">

								<!-- construct an "update" link with user id -->
								<c:url var="updateLink" value="/user/updateForm">
									<c:param name="userId" value="${user.id}" />
								</c:url>

								<!-- construct an "delete" link with user id -->
								<c:url var="deleteLink" value="/user/delete">
									<c:param name="userId" value="${user.id}" />
								</c:url>

								<tr>
									<td>${user.userName}</td>
									<td>${user.firstName}</td>
									<td>${user.surname}</td>
									<td>${user.department}</td>
									<td>${user.email}</td>
									<td>${user.pcName}</td>
									<td>${user.state}</td>				
									<td>${user.account}</td>
									

									<td>
										<!-- Test Commit --> <!-- display the update link --> <a
										href="${updateLink}">Update</a> | <a href="${deleteLink}"
										onclick="if (!(confirm('Benutzer wirklich löschen?'))) return false">Delete</a>
									</td>

								</tr>

							</c:forEach>

						</table>

					</div>
				</div>
			</div>

		</div>
	</form:form>
</body>

</html>