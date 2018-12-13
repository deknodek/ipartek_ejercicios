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
  <h1>NOTICIAS</h1>
  <h2>Portada</h2>
</header>


<main>

<a href="login" class="btn btn-primary">Mantenimiento</a>

<section class=row>
  
    <c:forEach items="${NoticiasLista.values()}" var="noticia">
    <article>
      <h2>${noticia.titular}</h2>
      <p>${noticia.fecha}</p>
      <p>${noticia.autor}</p>
      <p>${noticia.texto}</p>
      <div><img src="img/img-${noticia.id}.jpg" width=100 heigh=100></div>
      <a href=# >Leer Noticia</a>
    </tr>
    </c:forEach>
</section>
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