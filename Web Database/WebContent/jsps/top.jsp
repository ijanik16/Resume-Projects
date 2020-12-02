<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">CSC4710</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a>|&nbsp; 
			<a href="<c:url value='/jsps/user/crime-list.jsp'/>" target="_parent">CRUD Crimes</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/criminal-list.jsp'/>" target="_parent">CRUD Criminal</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/police-list.jsp'/>" target="_parent">CRUD PoliceRegister</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/complexQ1.jsp'/>" target="_parent">Complex Q1</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/complexQ2.jsp'/>" target="_parent">Complex Q2</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/complexQ3.jsp'/>" target="_parent">Complex Q3</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/complexQ4.jsp'/>" target="_parent">Complex Q4</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/complexQ5.jsp'/>" target="_parent">Complex Q5</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/simpleQ1.jsp'/>" target="_parent">Simple Q1</a>|&nbsp; 
			<a href="<c:url value='/jsps/user/simpleQ2.jsp'/>" target="_parent">Simple Q2</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/simpleQ3.jsp'/>" target="_parent">Simple Q3</a>			
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query Result</a>&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
