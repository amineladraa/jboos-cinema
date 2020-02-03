package org.antislashn.cinema.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.cinema.bo.Caddy;
import org.antislashn.cinema.entities.Film;
import org.antislashn.cinema.services.CinemaService;


@WebServlet("/RemoveFilmsServlet")
public class RemoveFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CinemaService service;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Caddy caddy = (Caddy) request.getSession().getAttribute("caddy");
		String id = request.getParameter("id");
		long idFilm = 0;
		if (!id.equals("")) {
			idFilm = Long.parseLong(id);
			
		}
		Film film = service.findFilmById(idFilm);
		if(film !=null) {
			caddy.remove(film);
		}
		String page = "/ShowCaddyServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
