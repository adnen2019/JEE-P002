<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
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
			<div>
				<form action="search.do" method="post">
					<div class="form-group">
						<label class="control-label">Mot Cle :</label>
						<input type="text" class="form-group form-control" name="motCle" />
						<input type="submit" class="btn btn-primary" value="SEARCH"/>
					</div>
				</form>
			</div>
			<table class="table table-striped" >
				<tr>
					<th>ID</th> <th>LIBELLE</th> <th>PRIX</th> <th>DELETE</th> <th>EDIT</th>
				</tr>
				<c:forEach items="${res.lp}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.libelle}</td>
						<td>${p.prix}</td>
						<td><a href="delete.do?id=${p.id}">Supprimer</a></td>
						<td><a href="edit.do?id=${p.id}">Editer</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</body>
</html>