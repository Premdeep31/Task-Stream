package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@Column(name = "Customer_Id")
	private int customerId;
	
	@Column(name = "Customer_Name")
	private String customerName;
	
	@Column(name = "Date_Of_Birth")
	private Date dateOfBirth;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Phone_No")
	private long phoneNo;
	
	@OneToOne
	private Locker lockerId;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Locker getLockerId() {
		return lockerId;
	}

	public void setLockerId(Locker lockerId) {
		this.lockerId = lockerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", lockerId=" + lockerId + "]";
	}
	
}
