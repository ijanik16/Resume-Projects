<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Crime Table Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">list of Crimes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${crimes != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${crimes == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${crimes != null}">
            			Edit Crime
            		</c:if>
						<c:if test="${crimes == null}">
            			Add New Crime
            		</c:if>
					</h2>
				</caption>

				<c:if test="${crimes != null}">
					<input type="hidden" name="crimeID" value="<c:out value='${crimes.crimeID}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Crime ID</label> <input type="text"
						value="<c:out value='${crimes.crimeID}' />" class="form-control"
						name="crimeID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Crime Type</label> <input type="text"
						value="<c:out value='${crimes.crimeType}' />" class="form-control"
						name="crimeType" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Crime Location</label> <input type="text"
						value="<c:out value='${crimes.crimeLocation}' />" class="form-control"
						name="crimeLocation">
				</fieldset>

				<fieldset class="form-group">
					<label>Police ID</label> <input type="text"
						value="<c:out value='${crimes.policeID}' />" class="form-control"
						name="policeID">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Criminal ID</label> <input type="text"
						value="<c:out value='${crimes.criminalID}' />" class="form-control"
						name="criminalID">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
