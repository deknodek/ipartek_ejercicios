package controladores;

import java.io.IOException;
import java.util.TreeMap;

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
	
//reques dispacher mantenite el sistema de envio k recibe si viene por get seguira por get
	//send redicrec es siempre un get
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		
		ServletContext application = request.getServletContext();	
		@SuppressWarnings("unchecked")
		TreeMap<Long, Libro> LibrosLista = (TreeMap<Long, Libro>) application.getAttribute("LibrosLista");
		
		if(accion==null) {
			response.sendRedirect("/libreria");
		}else if("editar".equals(accion) || "borrar".equals(accion)){
			Libro libromod = LibrosLista.get(Long.parseLong(id));		
			request.setAttribute("libro", libromod);
			request.setAttribute("accion", accion);
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}else if("insertar".equals(accion)) {
			request.setAttribute("accion", accion);
			request.getRequestDispatcher("libro.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String id =request.getParameter("id");
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String editorial = request.getParameter("editorial");
		Integer precio = Integer.parseInt(request.getParameter("precio"));
		
		
		
		ServletContext application = request.getServletContext();	
		@SuppressWarnings("unchecked")
		TreeMap<Long, Libro> LibrosLista = (TreeMap<Long, Libro>) application.getAttribute("LibrosLista");
		
		
		Long idLong;
		if("insertar".equals(accion)) {
			idLong = LibrosLista.lastKey() + 1L;
		} else {
			idLong = Long.parseLong(id);
		}
		
		switch(accion) {
		case "insertar": Libro libro = new Libro(idLong, isbn, titulo, editorial, precio);
		LibrosLista.put(libro.getId(), libro);
		break;
		case "editar": 
			Libro libro2 = new Libro(idLong, isbn, titulo, editorial, precio);
			LibrosLista.put(libro2.getId(), libro2);
			break;
		case "borrar": LibrosLista.remove(idLong); break;
		default: throw new ServletException("Opción no definida");
		}
		request.setAttribute("accion", accion);
		response.sendRedirect("principal");
		
		
	}

}
