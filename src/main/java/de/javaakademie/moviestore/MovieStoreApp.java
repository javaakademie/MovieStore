package de.javaakademie.moviestore;

import java.util.HashMap;
import java.util.Map;

import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Application.
 * 
 * @author Guido.Oelmann
 */
@ApplicationPath("mvc")
public class MovieStoreApp extends Application {

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		// enables CSRF protection. Add hidden input to form for sending token.
		properties.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.IMPLICIT);
		return properties;
	}

}