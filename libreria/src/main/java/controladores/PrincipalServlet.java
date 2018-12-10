package controladores;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pojos.Libro;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Las variables de tipo application se comparten para todos los usuarios
		//de este contexto (aplicación)
		ServletContext application = request.getServletContext();
		
		@SuppressWarnings("unchecked")
		HashMap<Long, Libro> LibrosLista = (HashMap<Long, Libro>) application.getAttribute("LibrosLista");

		if (LibrosLista == null) {
			LibrosLista = new HashMap<Long,Libro>();

			LibrosLista.put(1L, new Libro(1L, "isbn1","titulako","editorial",19));
			LibrosLista.put(2L, new Libro(2L, "isbn2","titulako2","editorial2",12));

			application.setAttribute("LibrosLista", LibrosLista);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
