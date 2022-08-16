package com.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entities.Movie;
import com.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao {
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public String addMovie(Movie movie) {
		Session session = sf.openSession();
		
		session.beginTransaction();
		Serializable id = session.save(movie);
		session.getTransaction().commit();
        session.close();
		
		return (String)id;
	}

	@Override
	public void deleteMovie(String movieId) {
		Session session = sf.openSession();
		
		//Movie movie = session.load(Movie.class, movieId);
		Movie movie = getMovieDetails(movieId);
		
		session.beginTransaction();
		session.delete(movie);
		session.getTransaction().commit();
        session.close();
		
	}

	@Override
	public void updateMovie(String movieId) {
		Session session = sf.openSession();
		
		// Adding 100000 to the revenue dollars of requested movie
		Movie movie = getMovieDetails(movieId);
		movie.setRevenueDollars(movie.getRevenueDollars() + 100000);
		
		session.beginTransaction();
		session.update(movie);
		session.getTransaction().commit();
        session.close();
	}

	@Override
	public Movie getMovieDetails(String movieId) {
		Session session = sf.openSession();
		
		session.beginTransaction();
//		Movie movie = session.load(Movie.class, movieId);
		Movie movie = session.get(Movie.class, movieId);
		session.getTransaction().commit();
        session.close();
        
		return movie;
	}

}
