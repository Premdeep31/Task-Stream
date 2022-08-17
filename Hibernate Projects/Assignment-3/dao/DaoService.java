package com.dao;

import java.util.List;

import com.entities.Movie;

public interface DaoService {
	public List<Movie> getMoviesByLanguge(String language); 
	public List<Movie> getMoviesByDirector(String director); 
	public void addMovies(); 
	public void updateRevenue(String movie); 
	public void deleteMovie(String movie); 
	public List<String> getDistinctLanguages(); 
	public List<String[]> getMovieAndDirector(); 
}
