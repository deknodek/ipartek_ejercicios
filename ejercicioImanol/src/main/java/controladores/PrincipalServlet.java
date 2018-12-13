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

@WebServlet("/portada")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext application = request.getServletContext();
		
		@SuppressWarnings("unchecked")
		TreeMap<Long, Noticia> NoticiasLista = (TreeMap<Long, Noticia>) application.getAttribute("NoticiasLista");

		if (NoticiasLista == null) {
			NoticiasLista = new TreeMap<Long,Noticia>();

			
			for (Long i = 1L; i <= 3L; i++) {
				NoticiasLista.put(i, new Noticia(i, "Titular" + i, new Date(), "Autor" + i, "Texto" + i));
			}

			application.setAttribute("NoticiasLista", NoticiasLista);
		}
		
		request.getRequestDispatcher("inicioNoticias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
