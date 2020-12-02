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
				<li><a href="<%=request.getContextPath()%>/listcrime"
					class="nav-link">List of crimes</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Crimes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Crime</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>crimeID</th>
						<th>crimeType</th>
						<th>crimeLocation</th>
						<th>policeID</th>
						<th>criminalID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="listCrime" items="${listCrime}">

						<tr>
							<td><c:out value="${listCrime.crimeID}" /></td>
							<td><c:out value="${listCrime.crimeType}" /></td>
							<td><c:out value="${listCrime.crimeLocation}" /></td>
							<td><c:out value="${listCrime.policeID}" /></td>
							<td><c:out value="${listCrime.criminalID}" /></td>
							<td><a href="edit?crimeID=<c:out value='${listCrime.crimeID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?crimeID=<c:out value='${listCrime.crimeID}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
