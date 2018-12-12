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

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Las variables de tipo application se comparten para todos los usuarios
		//de este contexto (aplicación)
		ServletContext application = request.getServletContext();
		
		@SuppressWarnings("unchecked")
		TreeMap<Long, Libro> LibrosLista = (TreeMap<Long, Libro>) application.getAttribute("LibrosLista");

		if (LibrosLista == null) {
			LibrosLista = new TreeMap<Long,Libro>();

			
			for(Long i = 1L; i <= 5L; i++) {
				LibrosLista.put(i, new Libro(i, "ISdsdsdEFED"+i,"Desarollo"+i,"Ipartek"+i,(int) (15+i)));
			}

			application.setAttribute("LibrosLista", LibrosLista);
		}
		
		request.getRequestDispatcher("indexincludes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
