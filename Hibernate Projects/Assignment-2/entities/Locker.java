package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Locker {
	@Id
	@Column(name = "Locker_Id")
	private String lockerId;
	
	@Column(name = "Locker_Type")
	private String lockerType;
	
	@Column(name = "Rent")
	private int rent;
	
	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLockerId() {
		return lockerId;
	}

	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}
	
}
