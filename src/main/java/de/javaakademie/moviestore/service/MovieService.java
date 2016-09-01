package de.javaakademie.moviestore.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import de.javaakademie.moviestore.model.Actor;
import de.javaakademie.moviestore.model.Genre;
import de.javaakademie.moviestore.model.Movie;

/**
 * MovieService.
 * 
 * @author Guido.Oelmann
 */
@ApplicationScoped
public class MovieService {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;

	private final List<Movie> movies = new ArrayList<>();

	private Integer sequence = 1;

	@PostConstruct
	public void init() {
		// create test data
		List<Actor> actors = Arrays.asList(new Actor(null, "Jeff", "Goldblum", LocalDate.parse("1952-10-22", FORMATTER), "https://de.wikipedia.org/wiki/Jeff_Goldblum"),
				new Actor(null, "Maika", "Dillon Monroe", LocalDate.parse("1993-05-29", FORMATTER), "https://de.wikipedia.org/wiki/Maika_Monroe"));
		createMovie("Independence Day: Wiederkehr", LocalDate.parse("2016-07-01", FORMATTER), 120.0, "USA", Genre.SCIENCE_FICTION, actors, "Nj45204cZMo");

		actors = Arrays.asList(new Actor(null, "Clint", "Eastwood", LocalDate.parse("1930-05-31", FORMATTER), "https://de.wikipedia.org/wiki/Clint_Eastwood"),
				new Actor(null, "Marianne", "Koch", LocalDate.parse("1931-08-19", FORMATTER), "https://de.wikipedia.org/wiki/Marianne_Koch"));
		createMovie("Für eine Handvoll Dollar", LocalDate.parse("1965-03-05", FORMATTER), 100.0, "Deutschland", Genre.WESTERN, actors, "gGkYW_CFTJk");

		actors = Arrays.asList(new Actor(null, "Clint", "Eastwood", LocalDate.parse("1930-05-31", FORMATTER), "https://de.wikipedia.org/wiki/Clint_Eastwood"),
				new Actor(null, "Morgan", "Freeman", LocalDate.parse("1937-06-01", FORMATTER), "https://de.wikipedia.org/wiki/Marianne_Koch"));
		createMovie("Erbarmungslos", LocalDate.parse("1992-01-01", FORMATTER), 100.0, "USA", Genre.WESTERN, actors, "QL9yxr1ZC_Q");
	}

	public List<Movie> getMovies() {
		return Collections.unmodifiableList(movies);
	}

	public Movie createMovie(String title, LocalDate releaseDate, Double runningTime, String country, Genre genre, List<Actor> actors, String trailerUrl) {
		Movie movie = new Movie(sequence++, title, releaseDate, runningTime, country, genre, actors, trailerUrl);
		movies.add(movie);
		return movie;
	}

	public void deleteMovie(Integer id) {
		movies.removeIf(movie -> movie.getId() == id);
	}

}