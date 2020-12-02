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
					class="nav-link">List of criminals</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Criminals</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newcriminal" class="btn btn-success">Add
					New Criminal</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>criminalID</th>
						<th>criminalName</th>
						<th>age</th>
						<th>gender</th>
						<th>arrested</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="listCriminal" items="${listCriminal}">

						<tr>
							<td><c:out value="${listCriminal.criminalID}" /></td>
							<td><c:out value="${listCriminal.criminalName}" /></td>
							<td><c:out value="${listCriminal.age}" /></td>
							<td><c:out value="${listCriminal.gender}" /></td>
							<td><c:out value="${listCriminal.arrested}" /></td>
							<td><a href="editcriminal?criminalID=<c:out value='${listCriminal.criminalID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletecriminal?criminalID=<c:out value='${listCriminal.criminalID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
