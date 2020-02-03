package org.antislashn.cinema.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 * Servlet implementation class AddFilmServlet
 */
@WebServlet("/AddFilmServlet")
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("CINEMA");
	@EJB private CinemaService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Caddy caddy = (Caddy) request.getSession().getAttribute("caddy");
		String id = request.getParameter("id");
		try {
			long idFilm = Long.parseLong(id);
			Film film = service.findFilmById(idFilm);
			if(film!=null) {
				caddy.add(film);			
				LOGGER.info(">>> ajout de "+film.getTitre());
			}
		}catch (Exception e) {
			LOGGER.log(Level.WARNING, ">>> identifiant mal formé : "+id,e);
		}
		String jimmy = "/ShowAllFilms";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jimmy);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
