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
			
		}else {
			
			if("editar".equals(accion)){
				Libro libromod = LibrosLista.get(Long.parseLong(id));		
				request.setAttribute("libro", libromod);
				request.setAttribute("accion", accion);
				//request.setAttribute("validacion", "required");
				request.setAttribute("tipo", "warning");
				request.getRequestDispatcher("libroinclude.jsp").forward(request, response);
				
				
			}else if( "borrar".equals(accion)) {
				Libro libromod2 = LibrosLista.get(Long.parseLong(id));		
				request.setAttribute("libro", libromod2);
				request.setAttribute("accion", accion);
				request.setAttribute("validacion", "disabled");
				request.setAttribute("tipo", "danger");
				request.getRequestDispatcher("libroinclude.jsp").forward(request, response);
			
			}else if("insertar".equals(accion)) {
				request.setAttribute("accion", accion);
				request.setAttribute("tipo", "success");
				//request.setAttribute("validacion", "required");
				request.getRequestDispatcher("libroinclude.jsp").forward(request, response);
			}
		}
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		String id =request.getParameter("id");
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String editorial = request.getParameter("editorial");
		
		
		
		
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
		case "insertar": 
		case "editar": 
			Libro libro = new Libro(idLong, isbn, titulo, editorial,Integer.parseInt(request.getParameter("precio")));
			LibrosLista.put(libro.getId(), libro);
			break;
		case "borrar": LibrosLista.remove(idLong); break;
		default: throw new ServletException("Opción no definida");
		}
		request.setAttribute("accion", accion);
		response.sendRedirect("principal");
		
		
	}

}
