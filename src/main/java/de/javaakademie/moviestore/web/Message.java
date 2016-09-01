package de.javaakademie.moviestore.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;
import javax.mvc.annotation.RedirectScoped;

/**
 * Message.
 * 
 * @author Guido.Oelmann
 */
@Named
@RedirectScoped
public class Message implements Serializable {

	private static final long serialVersionUID = 6012270416224546642L;

	private String info;

	private final List<String> errors = new ArrayList<>();

	public Message addError(String error) {
		errors.add(error);
		return this;
	}

	public Message addErrors(Collection<String> errors) {
		this.errors.addAll(errors);
		return this;
	}

	public List<String> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}