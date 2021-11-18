<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AD Tool</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>AD-Tool -User Relationship Manager</h2>
			<hr />

			<input type="button" value="Add User"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
				<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Benutzerliste</div>
				</div>
				<div class="panel-body"><a href="/adtool/logout" onclick="if (!(confirm('Benutzer wiklich abmelden?'))) return false">Abmelden</a>
					<table class="table table-striped table-bordered">
						<tr>
							<th>Benutzername</th>
							<th>Vorname</th>
							<th>Nachname</th>
							<th>Abteilung</th>
							<th>E-Mail</th>
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

								<td>
								<!-- Test Commit -->
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Benutzer wiklich löschen?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>

</html>