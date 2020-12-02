<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">SQ1 Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>AveragePoliceAge</th>
	</tr>
<c:forEach items="${q11}" var="sQ1">
	<tr>
		<td><c:out value="${sQ1.averagePoliceAge}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>