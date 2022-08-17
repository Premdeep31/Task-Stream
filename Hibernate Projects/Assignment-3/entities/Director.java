package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Director {
	@Id
	private String directorId;
	private String directorName;
	private int bornIn;
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public int getBornIn() {
		return bornIn;
	}

	public void setBornIn(int bornIn) {
		this.bornIn = bornIn;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}
	
}
