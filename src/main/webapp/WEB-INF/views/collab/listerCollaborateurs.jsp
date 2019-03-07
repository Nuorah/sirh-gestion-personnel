<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>SGP - APP</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<ul>
		<c:forEach items="${listeCollaborateurs}" var="coll">
		<li><c:out value="${coll.getNom()}"></c:out></li>
		</c:forEach>
	</ul>
</body>
</html>
