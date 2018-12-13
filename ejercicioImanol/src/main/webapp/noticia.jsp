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
  <h2>Mantenimiento - ${accion}</h2>
</header>


<main>
<a href="mantenimiento" class="btn btn-primary">Volver a mantenimiento</a>
<a href="accionesnoticias?accion=insertar" class="btn btn-primary">Insertar Noticia</a>

<form action="accionesnoticias" method="post" class="form-group">
  <fieldset>

    

    
	 <p class="row">
     <input type="hidden" name="accion" id="accion" value="${accion}" />
     
     
    	<input type="hidden" name="identificador" id="identificador" value="${noticia.id}" class="form-control col-sm-11"  />
	</p>	
    <p class="row">
      <label for="titular" class="col-sm-1 col-form-label">Titular</label>
      <input type="text" name="titular" id="titular" value="${noticia.titular}"  class="form-control col-sm-11"  ${validacion} placeholder="${noticia.errortitular}"/>
       <c:if test="${noticia.errortitular != null }">
      	<span class="alert alert-warning" role="alert">${noticia.errortitular}</span>
      </c:if>
    </p>

    <p class="row">
      <label for="fecha" class="col-sm-1 col-form-label">Fecha</label>
      <input type="text" name="fecha" id="fecha" value="${noticia.fecha}"  class="form-control col-sm-11"  ${validacion} />
     
    </p>

    <p class="row">
      <label for="autor" class="col-sm-1 col-form-label">Autor</label>
      <input type="text" name="autor" id="autor" value="${noticia.autor}"  class="form-control col-sm-11" ${validacion} placeholder="${noticia.errorautor}"/>
       <c:if test="${noticia.errorautor != null }">
      	<span class="alert alert-warning" role="alert">${noticia.errorautor}</span>
      </c:if>
    </p>

    <p class="row">
      <label for="texto" class="col-sm-1 col-form-label">Texto</label>
       <input type="text" name="texto" id="texto" value="${noticia.texto}"  class="form-control col-sm-11" ${validacion}  placeholder="${noticia.errortexto}"/>
        <c:if test="${noticia.errortexto != null }">
      	<span class="alert alert-warning" role="alert">${noticia.errortexto}</span>
      </c:if>
    </p>

    <p>
     <button class="btn btn-${tipo}">${accion}</button>
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