<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/headerinclude.jsp" %>

<main>
<form action="accioneslibro" method="post" class="form-group">
  <fieldset>
    <legend>${accion}</legend>
    
    <p>MENSAJE:${precioError}</p>
	 <p class="row">
     <input type="hidden" name="accion" id="accion" value="${accion}" />
    	<input type="hidden" name="id" id="id" value="${libro.id}" class="form-control col-sm-11" />
	</p>	
    <p class="row">
      <label for="isbn" class="col-sm-1 col-form-label">ISBN</label>
      <input type="text" name="isbn" id="isbn" value="${libro.isbn}"  class="form-control col-sm-11" ${validacion} />
    </p>

    <p class="row">
      <label for="titulo" class="col-sm-1 col-form-label">Título</label>
      <input type="text" name="titulo" id="titulo" value="${libro.titulo}"  class="form-control col-sm-11" ${validacion} />
    </p>

    <p class="row">
      <label for="editorial" class="col-sm-1 col-form-label">Editorial</label>
      <input type="text" name="editorial" id="editorial" value="${libro.editorial}"  class="form-control col-sm-11" ${validacion} />
    </p>

    <p class="row">
      <label for="precio" class="col-sm-1 col-form-label">Precio</label>
       <input type="text" name="precio" id="precio" value="${libro.precio}"  class="form-control col-sm-11" ${validacion} />
    </p>

    <p>
      <button class="btn btn-${tipo}">${accion}</button>
    </p>
  </fieldset>
</form>
  
</main>
<%@ include file="includes/footerinclude.jsp" %>