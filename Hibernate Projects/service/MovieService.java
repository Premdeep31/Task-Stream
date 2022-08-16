package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dao.MovieDaoImpl;
import com.entities.Movie;

public class MovieService {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	// Add Movie
	public String addMovieDetails() throws IOException {
		Movie movie = new Movie();
		String s;
		int num;
		
		System.out.println("Enter the Movie Id: ");
		s = input.readLine();
		movie.setMovieId(s);
		
		System.out.println("Enter the Movie Name: ");
		s = input.readLine();
		movie.setMovieName(s);
		
		System.out.println("Enter the Movie Language: ");
		s = input.readLine();
		movie.setLanguage(s);
		
		System.out.println("Enter the Movie Released Date: ");
		num = Integer.parseInt(input.readLine());
		movie.setReleasedIn(num);
		
		System.out.println("Enter the Movie Revenue Dollars: ");
		num = Integer.parseInt(input.readLine());
		movie.setRevenueDollars(num);
	
		s = new MovieDaoImpl().addMovie(movie);
		if (s != null)
			return "Movie added successfully";
		
		return "Movie was not added";
	}
	
	// Delete Movie
	public String deleteMovieDetails() throws IOException {
		String s;
		
		System.out.println("Enter the Movie Id: ");
		s = input.readLine();
		
		new MovieDaoImpl().deleteMovie(s);
		
		return "Movie deleted successfully";
	}
	
	// Update Movie
	public String updateMovieDetails() throws IOException {
		String s;
		
		System.out.println("Enter the Movie Id: ");
		s = input.readLine();
		
		new MovieDaoImpl().updateMovie(s);
		
		return "Movie is Updated";
	}
	
	// Fetch Movie
	public Movie getMovieDetails() throws IOException {
		String s;
		
		System.out.println("Enter the Movie Id: ");
		s = input.readLine();
		
		Movie movie = new MovieDaoImpl().getMovieDetails(s);
		return movie;
	}
}
