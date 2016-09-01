package de.javaakademie.moviestore;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import de.javaakademie.moviestore.model.Movie;
import de.javaakademie.moviestore.service.MovieService;
import de.javaakademie.moviestore.web.CreateMovieForm;
import de.javaakademie.moviestore.web.Message;

/**
 * MovieController.
 * 
 * @author Guido.Oelmann
 */
@Path("/movies")
@Controller
public class MovieController {

	@Inject
	private Models models;

	@Inject
	private BindingResult bindingResult;

	@Inject
	private Message message;

	@Inject
	private MovieService movieService;

	@GET
	public String listMovies() {
		models.put("movies", movieService.getMovies());
		return "/movielist.jsp";
	}

	@POST
	@Path("/create")
	public String createItem(@BeanParam @Valid CreateMovieForm form) {

		if (bindingResult.isFailed()) {
			message.addErrors(bindingResult.getAllMessages());
			models.put("form", form);
			return listMovies();
		}

		Movie newMovie = movieService.createMovie(form.getTitle(), form.getReleaseDate(), form.getRunningTime(), form.getCountry(), form.getGenre(), form.getActors(),
				form.getYouTubeVideoId());

		message.setInfo("Movie created: " + newMovie.getTitle());
		return "redirect:/movies";

	}

	@POST
	@Path("/delete")
	public String deleteMovie(@FormParam("id") Integer id) {
		movieService.deleteMovie(id);
		return "redirect:/movies";
	}

}