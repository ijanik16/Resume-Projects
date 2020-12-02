<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Police Table Management</title>
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
				<li><a href="<%=request.getContextPath()%>/listpolice"
					class="nav-link">list of police</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${policeRegister != null}">
					<form action="updatepolice" method="post">
				</c:if>
				<c:if test="${policeRegister == null}">
					<form action="insertpolice" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${policeRegister != null}">
            			Edit Police
            		</c:if>
						<c:if test="${policeRegister == null}">
            			Add New Police
            		</c:if>
					</h2>
				</caption>

				
				<fieldset class="form-group">
					<label>Police ID</label> <input type="text"
						value="<c:out value='${policeRegister.policeID}' />" class="form-control"
						name="policeID">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Police Age</label> <input type="text"
						value="<c:out value='${policeRegister.age}' />" class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>Gender</label> <input type="text"
						value="<c:out value='${policeRegister.gender}' />" class="form-control"
						name="gender" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Police Rank</label> <input type="text"
						value="<c:out value='${policeRegister.policeRank}' />" class="form-control"
						name="policeRank">
				</fieldset>
				
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
