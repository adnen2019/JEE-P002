<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/bootstrap.min.css" rel = "stylesheet" type="text/css"/>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<form action="save.do" method="post">
			<div class="form-group">
				<label class="control-label">Nom Produit</label>
				<input type="text" name="libelle"class="form-control"/>
			</div>
			<div class="form-group">
				<label class="control-label">Prix Produit</label>
				<input type="text" name="prix" class="form-control"/>
			</div>
				<button type="submit" class="btn btn-primary">Ajouter</button>
				<button type="reset" class="btn btn-primary">Annuler</button>
		</form>
	
	</div>
</body>
</html>