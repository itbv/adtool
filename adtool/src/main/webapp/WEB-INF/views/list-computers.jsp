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
			<h2>AD-Too- User Relationship Manager</h2>
			<hr />

			<input type="button" value="Add Computer"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
				<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Computerliste</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>PC-Name</th>
							<th>Typ</th>
						</tr>

						<!-- loop over and print our computers -->
						<c:forEach var="computer" items="${computers}">

							<!-- construct an "update" link with computer id -->
							<c:url var="updateLink" value="/computer/updateForm">
								<c:param name="computerName" value="${computer.computerName}" />
							</c:url>

							<!-- construct an "delete" link with computerTyp id -->
							<c:url var="deleteLink" value="/computer/delete">
								<c:param name="computerId" value="${computer.id}" />
							</c:url>

							<tr>
								<td>${computer.computerName}</td>
								<td>${computer.computerTyp}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Computer wiklich löschen?'))) return false">Delete</a>
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