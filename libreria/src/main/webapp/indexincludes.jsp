<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="includes/headerinclude.jsp" %>

<main>

	<a href="accioneslibro?accion=insertar" class="btn btn-primary btn-lg" role="button">Insertar nuevo libro</a>

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
      <a href="accioneslibro?accion=borrar&id=${libro.id}">Borrar</a>
      </th>
      
    </tr>
    </c:forEach>
  </tbody>
</table>
</main>
<%@ include file="includes/footerinclude.jsp" %>
