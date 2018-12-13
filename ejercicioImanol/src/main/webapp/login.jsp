<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, pojos.Noticia" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>NOTICIAS - PORTADA</title>
</head>
<body>


<div class="container">
<header>
  <h1>Login</h1>
  <h2>Mantenimiento</h2>
</header>


<main>


<form action="mantenimiento" method="post" class="form-group">
	<div class="form-group">
		<input type="email" class="form-control" id="inputEmail"
			placeholder="Usuario">
	</div>
	<div class="form-group">
		<input type="password" class="form-control" id="inputPassword"
			placeholder="Contraseña">
	</div>
	<button type="submit" class="btn btn-primary">Login</button>
</form>

</main>

<footer>
  
</footer>
 
</div>
      <!-- FIN DIV CONTENIDO GENERAL-->






<!-- Opcional JavaScript -->
<!-- jQuery primero, despues Popper.js, despues Bootstrap JS -->
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>