package org.antislashn.cinema.bo;





import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antislashn.cinema.entities.Film;

import lombok.Data;
@Data
public class Caddy {
	//List<Film> films = new ArrayList<>();
	
	private Map<Film, Integer> films = new HashMap<Film, Integer>();
	private int quantite;
	
	public void add(Film film) {
		films.put(film, ++quantite);
	}
	
	public void remove(Film film) {
		films.remove(film);
	}
	
	public double getPrixTotalHT() {
		double total = 0;
		for(Film f : films.keySet())
			total += f.getPrixHT() * films.get(f);
		return total;
	}
	
	public int getNombreArticles() {
		return films.size();
	}
	
	
	public List<Film> getFilms() {
		return new ArrayList<Film>(films.keySet());
	}
	
	
}
