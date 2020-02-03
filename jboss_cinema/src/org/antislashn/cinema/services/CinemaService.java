package org.antislashn.cinema.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.antislashn.cinema.bo.Caddy;
import org.antislashn.cinema.dao.FilmDao;
import org.antislashn.cinema.entities.Film;

@Singleton
public class CinemaService {
	@EJB private FilmDao dao;
	
	public List<Film> findAllFilms(){
		return dao.findAll();
	}
	
	public Film findFilmById(long id) {
		return dao.findById(id);
	}
	public List<Film> getFilm(Caddy caddy) {
		return caddy.getFilms();
	}
	
	public void removeFilmCaddy(Caddy caddy, Film film) {
		caddy.remove(film);
	}
}
