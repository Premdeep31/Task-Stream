package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hollywood {
	@Id
	private String movieId;
	private String movieName;
	private String language;
	private int releasedIn;
	private int revenueInDollars;
	
	public Hollywood() {
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

	@Override
	public String toString() {
		return "Hollywood [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + "]";
	}
	
}
