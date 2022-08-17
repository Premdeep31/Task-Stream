package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {
	@Id
	private String movieId;
	private String movieName;
	private String language;
	private int releasedIn;
	private int revenueInDollars;
	
	@OneToOne
	private Director director;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(int releasedIn) {
		this.releasedIn = releasedIn;
	}

	public int getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(int revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + ", director=" + director + "]";
	}
	
}
