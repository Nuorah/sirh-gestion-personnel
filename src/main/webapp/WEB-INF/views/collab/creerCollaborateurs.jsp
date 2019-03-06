<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>SGP - APP</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
	<form action="" method="post" class="form-example" >
		<div>
			<label for="name">Nom </label> <input type="text" name="nom" id="nom"
				required>
		</div>
		<div>
			<label for="prenom">Prenom </label> <input type="text" name="prenom"
				id="prenom" required>
		</div>
		<div>
			<label for="dateDeNaissance">Date de Naissance </label> <input
				type="date" name="dateDeNaissance" id="dateDeNaissance" required>
		</div>
		<div>
			<label for="adresse">Adresse </label>
			<textarea name="adresse" id="adresse" cols="40" rows="5" required></textarea>
		</div>
		<div>
			<label for="numeroDeSecuriteSociale">Numéro de Sécurité
				Sociale</label> <input type="text" maxlength="15" name="numeroDeSecuriteSociale"
				id="numeroDeSecuriteSociale" required>
		</div>
		<div>
			<input type="submit" value="Créer">
		</div>

	</form>
</body>
</html>
