<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<title>Liste compte(s)</title>
</head>
<body>

<h1 class="text-center">Compte(s)</h1>
	<div class="container">
		<div class="en_tete_client col-md-3 col-md-offset-2">

			<p>Client n°: ${liste[0].client.id}</p>
			<p>Nom: ${liste[0].client.nom}
			<p>Prénom: ${liste[0].client.prenom}</p>
			<p></p>
		</div>

		<div class="container">
			<div class=row>
				<div class="col-md-12 col-md-auto">
					<table class="table table-striped table-bordered">
						<th>Type de compte</th>
						<th>N° de compte</th>
						<th>Date d'ouverture</th>
						<th>Solde</th>
						<th>Action</th>
						<c:forEach items="${liste}" var="compte">
							<tr>
								<td><c:choose>
										<c:when
											test="${compte.getClass()=='class fr.jeanaurore.model.CompteCourant'}">
											<p>Courant</p>
										</c:when>
										<c:otherwise>
											<p>Epargne</p>
										</c:otherwise>
									</c:choose></td>
								<td>${compte.id}</td>
								<td>${compte.dateOuverture}</td>
								<td>${compte.solde}</td>
								<td><a href="ServletVirement?id=${compte.id}"><button>Virement</button></a></td>
							</tr>
						</c:forEach>
					</table>
					<a href="/ProxiBanqueSI/ServletAuthentif"><button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">Retour à la liste des clients</button></a>
				</div>
			</div>
		</div>



	</div>

</body>
</html>