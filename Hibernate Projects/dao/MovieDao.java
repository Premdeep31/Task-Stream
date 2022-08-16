package com.dao;

import com.entities.Movie;

public interface MovieDao {
	public String addMovie(Movie movie);
	public void deleteMovie(String movieId);
	public void updateMovie(String movieId);
	public Movie getMovieDetails(String movieId);
}
