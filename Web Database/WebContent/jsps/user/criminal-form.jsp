<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Criminal Table Management</title>
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
				<li><a href="<%=request.getContextPath()%>/listcriminal"
					class="nav-link">list of Criminals</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${criminal != null}">
					<form action="updatecriminal" method="post">
				</c:if>
				<c:if test="${criminal == null}">
					<form action="insertcriminal" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${criminal != null}">
            			Edit Criminal
            		</c:if>
						<c:if test="${criminal == null}">
            			Add New Criminal
            		</c:if>
					</h2>
				</caption>

				<c:if test="${criminal != null}">
					<input type="hidden" name="criminalID" value="<c:out value='${criminal.criminalID}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Criminal ID</label> <input type="text"
						value="<c:out value='${criminal.criminalID}' />" class="form-control"
						name="criminalID">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Criminal Name</label> <input type="text"
						value="<c:out value='${criminal.criminalName}' />" class="form-control"
						name="criminalName">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value="<c:out value='${criminal.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Gender</label> <input type="text"
						value="<c:out value='${criminal.gender}' />" class="form-control"
						name="gender">
				</fieldset>

				<fieldset class="form-group">
					<label>Arrested</label> <input type="text"
						value="<c:out value='${criminal.arrested}' />" class="form-control"
						name="arrested">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
