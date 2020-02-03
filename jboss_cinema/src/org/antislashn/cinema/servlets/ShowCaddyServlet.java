package org.antislashn.cinema.servlets;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/ShowCaddyServlet")
public class ShowCaddyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CinemaService service;
    
    public ShowCaddyServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Caddy caddy = (Caddy) request.getSession().getAttribute("caddy");
		List<Film> films = caddy.getFilms();
		request.setAttribute("films", films);
		String page ="/show-caddy.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
