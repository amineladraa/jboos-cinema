<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value = "fr_FR"/>
<h2>Panier</h2>
Caddy - Nb d'articles : ${caddy.nombreArticles } (<fmt:formatNumber value = "${caddy.prixTotalHT}" type = "currency"/>)
<table>
	<tr><th>Titre</th><th>Prix HT</th></tr>
	<c:forEach items="${films }" var="film">
		<tr>
			<td>${film.titre }</td>
			<td><fmt:formatNumber value = "${film.prixHT}" type = "currency"/><td/>
			<td><a href="RemoveFilmsServlet?id=${film.id }">Supprimer</a>
		</tr>
	</c:forEach>
</table>
</body>
</html>