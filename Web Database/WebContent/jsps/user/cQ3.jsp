<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">CQ3 Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>criminalName</th>
		<th>criminalID</th>
	</tr>
<c:forEach items="${q3}" var="cQ3">
	<tr>
		<td><c:out value="${cQ3.criminalName}" /></td>
		<td><c:out value="${cQ3.criminalID}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>