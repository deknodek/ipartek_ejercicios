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

@WebServlet("/accioneslibro")
public class AccionesLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String editorial = request.getParameter("editorial");
		String precio = request.getParameter("precio");
		
		ServletContext application = request.getServletContext();	
		@SuppressWarnings("unchecked")
		HashMap<Long, Libro> LibrosLista = (HashMap<Long, Libro>) application.getAttribute("LibrosLista");
		
		if(accion != null && "borrar".equals(accion)) {
			LibrosLista.remove(Long.parseLong(id));
			request.getRequestDispatcher("/").forward(request, response);
		}
		if(accion != null && "editar".equals(accion)) {
			Libro libromod = LibrosLista.get(Long.parseLong(id));		
			request.setAttribute("libro", libromod);
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}
		
		if(accion == null && isbn!=null) {
			
			//Empaquetarla en un objeto
			Libro libro = new Libro(Long.parseLong(id), isbn, titulo, editorial, Integer.parseInt(precio));
			//Realizar la operación
			LibrosLista.put(Long.parseLong(id), libro);
			request.getRequestDispatcher("/").forward(request, response);
		}

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
