package de.javaakademie.moviestore.model;

import java.time.LocalDate;
import java.time.Period;;

/**
 * Actor.
 * 
 * @author Guido.Oelmann
 */
public class Actor {

	private Integer id;
	private String name;
	private String surname;
	private LocalDate birthday;
	private String wikipediaUrl;

	public Actor() {
	}

	public Actor(Integer id, String name, String surname, LocalDate birthday, String wikipediaUrl) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.wikipediaUrl = wikipediaUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public String getWikipediaUrl() {
		return wikipediaUrl;
	}

	public void setWikipediaUrl(String wikipediaUrl) {
		this.wikipediaUrl = wikipediaUrl;
	}
}