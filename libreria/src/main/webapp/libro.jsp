<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
  <h1><a href="/libreria">CRUD JSP MAVEN</a></h1>
   <h2>LIBRERIA</h2>
</header>

<main>
<form action="accioneslibro" method="post" class="form-group">
  <fieldset>
    <legend> ${accion}</legend>
    <input type="hidden" name="accion" id="accion" value="${accion}" />
    
	 <p class="row">
      <label for="isbn" class="col-sm-1 col-form-label">ISBN</label>
    	<input type="text" name="id" id="id" value="${libro.id}" class="form-control col-sm-11" />
	</p>	
    <p class="row">
      <label for="isbn" class="col-sm-1 col-form-label">ISBN</label>
      <input type="text" name="isbn" id="isbn" value="${libro.isbn}"  class="form-control col-sm-11" />
    </p>

    <p class="row">
      <label for="titulo" class="col-sm-1 col-form-label">Título</label>
      <input type="text" name="titulo" id="titulo" value="${libro.titulo}"  class="form-control col-sm-11" />
    </p>

    <p class="row">
      <label for="editorial" class="col-sm-1 col-form-label">Editorial</label>
      <input type="text" name="editorial" id="editorial" value="${libro.editorial}"  class="form-control col-sm-11" />
    </p>

    <p class="row">
      <label for="precio" class="col-sm-1 col-form-label">Precio</label>
       <input type="text" name="precio" id="precio" value="${libro.precio}"  class="form-control col-sm-11" />
    </p>

    <p>
      <button class="btn btn-success">${accion}</button>
    </p>
  </fieldset>
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