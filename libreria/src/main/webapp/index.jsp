<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, pojos.Libro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Libros</title>
</head>
<body>


<div class="container">
<header>
  <h1>CRUD JSP MAVEN</h1>
   <h2>LIBRERIA</h2>
</header>

<main>

	<a href="accioneslibro" class="btn btn-primary btn-lg" role="button">Insertar nuevo libro</a>

  <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ISBN</th>
      <th scope="col">Título</th>
      <th scope="col">Editorial</th>
      <th scope="col">Precio</th>
      <th scope="col">Editar</th>
      <th scope="col">Borrar</th>
    </tr>
  </thead>
  <tbody>
  
    <c:forEach items="${LibrosLista.values()}" var="libro">
    <tr>
      <th scope="row">${libro.id}</th>
      <td>${libro.isbn}</td>
      <td>${libro.titulo}</td>
      <td>${libro.editorial}</td>
      <td>${libro.precio}</td>
      <th scope="col"><a href="accioneslibro?accion=editar&id=${libro.id}">Editar</a></th>
      <th scope="col">
      <a href="accioneslibro?accion=borrar&id=${libro.id}" onclick="return confirm('¿Estás seguro de borrar ${libro.titulo}?')">Borrar</a>
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