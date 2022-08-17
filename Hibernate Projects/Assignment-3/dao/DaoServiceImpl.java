package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entities.Movie;
import com.util.HibernateUtil;

public class DaoServiceImpl implements DaoService {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	

	// Get Movies details By Language
	public List<Movie> getMoviesByLanguge(String language) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "From Movie M where M.language = :language";
		Query query = session.createQuery(s);
		query.setParameter("language", language);
		List<Movie> results = query.list();
		session.close();
		
		return results;
	}
	
	// Get movies details by Director Name
	public List<Movie> getMoviesByDirector(String director) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "From Movie M where M.director.directorId = "
				+ "(select D.directorId from Director D where D.directorName = :directorName)";
		Query query = session.createQuery(s);
		query.setParameter("directorName", director);
		List<Movie> results = query.list();
		session.close();
		
		return results;
	}
	
	// Add English Movies
	public void addMovies() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "Insert into Hollywood (movieId, movieName, language, releasedIn, revenueInDollars)" 
				+ "select movieId, movieName, language, releasedIn, revenueInDollars from Movie where language = 'English'";
		
		Query query = session.createQuery(s);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	// Update Revenue by Movie Name
	public void updateRevenue(String movie) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "Update Movie M set revenueInDollars = revenueInDollars + 100000 where M.movieName = :movie";
		Query query = session.createQuery(s);
		query.setParameter("movie", movie);
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
	
	// Delete Movie by Name
	public void deleteMovie(String movie) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "Delete from Movie where movieName = :movie";
		Query query = session.createQuery(s);
		query.setParameter("movie", movie);
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}
	
	// Get Distinct Languages
	public List<String> getDistinctLanguages() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "Select distinct(language) from Movie";
		Query query = session.createQuery(s);
		List<String> languages = query.list();
		
		session.close();
		
		return languages;
	}
	
	// Get Movie and Director Names
	public List<String[]> getMovieAndDirector() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		String s = "Select movieName, director.directorName from Movie";
		Query query = session.createQuery(s);
		List<String[]> result = query.list();
		session.close();
		
		return result;
	}
}
