package de.javaakademie.moviestore.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Movie.
 * 
 * @author Guido.Oelmann
 */
public class Movie {

	private Integer id;
	private String title;
	private LocalDate releaseDate;
	private Double runningTime;
	private String country;
	private Genre genre;
	private List<Actor> actors;
	private String youTubeVideoId;

	public Movie() {
	}

	public Movie(Integer id, String title, LocalDate releaseDate, Double runningTime, String country, Genre genre, List<Actor> actors, String youTubeVideoId) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.runningTime = runningTime;
		this.country = country;
		this.genre = genre;
		this.actors = actors;
		this.youTubeVideoId = youTubeVideoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getGenre() {
		return genre.toString().replace("_", " ");
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