package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.dao.DaoServiceImpl;
import com.entities.Movie;

public class HollywoodService {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private DaoServiceImpl dao = new DaoServiceImpl();
	
	// Get Movies details By Language
	public void getMoviesByLanguge() throws IOException {
		String lang;
		
		System.out.println("Enter the language: ");
		lang = input.readLine();
		
		List<Movie> movies = dao.getMoviesByLanguge(lang);
    	for (Movie movie : movies)
    		System.out.println(movie);	
	}
	
	// Get movies details by Director Name
	public void getMoviesByDirector() throws IOException {
		String director;
		
		System.out.println("Enter director name: ");
		director = input.readLine();
		
		List<Movie> movies = dao.getMoviesByDirector(director);
    	for (Movie movie : movies)
    		System.out.println(movie);
	}
	
	// Add English Movies
	public void addMovies() {
		dao.addMovies();
	}
	
	// Update Revenue by Movie Name
	public void updateRevenue() throws IOException {
		String movie;
		
		System.out.println("Enter Movie Name: ");
		movie = input.readLine();
		
		dao.updateRevenue(movie);
	}
	
	// Delete Movie by Name
	public void deleteMovie() throws IOException {
		String movie;
		
		System.out.println("Enter Movie Name: ");
		movie = input.readLine();
		
		dao.deleteMovie(movie);
	}
	
	// Get Distinct Languages
	public void getDistinctLanguages() {
		System.out.println(dao.getDistinctLanguages());
	}
	
	// Get Movie and Director Names
	public void getMovieAndDirector() {
		List<String[]> md = dao.getMovieAndDirector();
    	for (Object[] obj : md)
    		System.out.println("Movie: " + obj[0] + ", Directed by: " + obj[1]);
	}
}
