package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Noticia;

@WebServlet("/accionesnoticias")
public class AccionesNoticiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		
		ServletContext application = request.getServletContext();	
		@SuppressWarnings("unchecked")
		TreeMap<Long, Noticia> NoticiasLista = (TreeMap<Long, Noticia>) application.getAttribute("NoticiasLista");
		
		if(accion==null) {
			response.sendRedirect("mantenimiento");
			
		}else {
			
			if("editar".equals(accion)){
				Noticia noticia = NoticiasLista.get(Long.parseLong(id));
				request.setAttribute("noticia", noticia);
				request.setAttribute("accion", accion);
				request.setAttribute("tipo", "warning");
				request.getRequestDispatcher("noticia.jsp").forward(request, response);
				
				
			}else if( "borrar".equals(accion)) {
				Noticia noticia = NoticiasLista.get(Long.parseLong(id));
				request.setAttribute("noticia", noticia);
				request.setAttribute("accion", accion);
				request.setAttribute("tipo", "danger");
				request.setAttribute("validacion", "disabled");
				request.getRequestDispatcher("noticia.jsp").forward(request, response);
			
			}else if("insertar".equals(accion)) {
				request.setAttribute("accion", accion);	
				request.setAttribute("tipo", "success");
				request.getRequestDispatcher("noticia.jsp").forward(request, response);
			}
		}
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String accion = request.getParameter("accion");
		String id =request.getParameter("identificador");
		String titular = request.getParameter("titular");
		String autor = request.getParameter("autor");
		String texto = request.getParameter("texto");
		Date fecha = new Date();
		
		
		ServletContext application = request.getServletContext();	
		@SuppressWarnings("unchecked")
		TreeMap<Long, Noticia> NoticiasLista = (TreeMap<Long, Noticia>) application.getAttribute("NoticiasLista");
		
		/*CREAR ID*/
		Long idLong;
		if("insertar".equals(accion)) {
			idLong = NoticiasLista.lastKey() + 1L;
		} else {
			idLong = Long.parseLong(id);
		}
		
		
		
		
		
		switch(accion) {
		case "insertar": 
		case "editar": Noticia noticia = new Noticia(idLong, titular,fecha , autor,texto);
		
		boolean notis=noticia.isCorrecto();
		if(!notis) {
		request.setAttribute("accion", accion);
		if("insertar".equals(accion)) {
				request.setAttribute("tipo", "success");
		}else if("editar".equals(accion)){
				request.setAttribute("tipo", "warning");
		}
		request.setAttribute("noticia", noticia);
		request.getRequestDispatcher("noticia.jsp").forward(request, response);
		return;
		}
		NoticiasLista.put(noticia.getId(), noticia);break;
		
		case "borrar": NoticiasLista.remove(idLong); break;
		
		default: throw new ServletException("Opci�n no definida");
		}
		
		response.sendRedirect("mantenimiento");
		
	}

}
