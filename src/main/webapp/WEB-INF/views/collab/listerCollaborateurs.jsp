<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>SGP - APP</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs</h1>
	<div> Rechercher un nom ou un prénom qui commence par: </div> 
	<ul>
		<%
			List<Collaborateur> listeCollaborateurs = (List<Collaborateur>) request.getAttribute("listeCollaborateurs");
			for (Collaborateur collaborateur : listeCollaborateurs) {
		%>
		<li><%=collaborateur.getNom()%></li>
		<li><img src=<%=collaborateur.getPhoto()%> />
		<%
			}
		%>
	</ul>
</body>
</html>
