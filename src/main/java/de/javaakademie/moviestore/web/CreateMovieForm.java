package de.javaakademie.moviestore.web;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

import de.javaakademie.moviestore.model.Actor;
import de.javaakademie.moviestore.model.Genre;

/**
 * CreateMovieForm.
 * 
 * @author Guido.Oelmann
 */
public class CreateMovieForm {

	@NotNull
	@Size(min = 3, message = "The title must be at least 3 characters.")
	@FormParam("title")
	private String title;

	@FormParam("releaseDate")
	private LocalDate releaseDate;

	@FormParam("runningTime")
	private Double runningTime;

	@FormParam("country")
	private String country;

	@NotNull(message = "Please select the genre of the movie.")
	@FormParam("genre")
	private Genre genre;

	@FormParam("actors")
	private List<Actor> actors;

	@FormParam("youTubeVideoId")
	private String youTubeVideoId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(Double runningTime) {
		this.runningTime = runningTime;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getYouTubeVideoId() {
		return youTubeVideoId;
	}

	public void setYouTubeVideoId(String youTubeVideoId) {
		this.youTubeVideoId = youTubeVideoId;
	}

}