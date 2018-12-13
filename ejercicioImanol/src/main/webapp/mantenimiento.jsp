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
  <h2>Mantenimiento</h2>
</header>


<main>
<a href="portada" class="btn btn-primary">Ver Portada</a>
<a href="accionesnoticias?accion=insertar" class="btn btn-primary">Insertar Noticia</a>

  <table class="table table-hover">
  <thead>
    <tr>
    <th scope="col">ID</th>
      <th scope="col">Titular</th>
      <th scope="col">Fecha</th>
      <th scope="col">Autor</th>
      <th scope="col">Texto</th>
       <th scope="col">Imagen</th>
       <th scope="col">Editar</th>
       <th scope="col">Borrar </thead>
  <tbody>
  
    <c:forEach items="${NoticiasLista.values()}" var="noticia">
    <tr>
      <th scope="row">${noticia.id}</th>
      <td>${noticia.titular}</td>
      <td>${noticia.fecha}</td>
      <td>${noticia.autor}</td>
      <td>${noticia.texto}</td>
      <td><img src="img/img-${noticia.id}.jpg" width=100 heigh=100></td>
      <th scope="col"><a href="accionesnoticias?accion=editar&id=${noticia.id}">Editar</a></th>
      <th scope="col">
      <a href="accionesnoticias?accion=borrar&id=${noticia.id}">Borrar</a>
      </th>
    </tr>
    </c:forEach>
    
    
  </tbody>
</table>
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