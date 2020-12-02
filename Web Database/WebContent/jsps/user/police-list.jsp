<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Police Register Table Management</title>
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
					class="nav-link">List Police Register</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List Police Register</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newpolice" class="btn btn-success">Add
					New Police Register</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>policeID</th>
						<th>age</th>
						<th>gender</th>
						<th>policeRank</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="listRegister" items="${listRegister}">

						<tr>
							<td><c:out value="${listRegister.policeID}" /></td>
							<td><c:out value="${listRegister.age}" /></td>
							<td><c:out value="${listRegister.gender}" /></td>
							<td><c:out value="${listRegister.policeRank}" /></td>
							<td><a href="editpolice?policeID=<c:out value='${listRegister.policeID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletepolice?policeID=<c:out value='${listRegister.policeID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
