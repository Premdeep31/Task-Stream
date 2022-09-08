package com.ims.inventorymanagementsystem.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int id;
	private String description;
	private int weight;
	private double price;
	private LocalDate manufaturingDate;
	private int useBeforeMonths;
	private LocalDate expiryDate;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String description, int weight, double price, LocalDate manufaturingDate, int useBeforeMonths,
			LocalDate expiryDate) {
		super();
		this.id = id;
		this.description = description;
		this.weight = weight;
		this.price = price;
		this.manufaturingDate = manufaturingDate;
		this.useBeforeMonths = useBeforeMonths;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}

	public LocalDate getManufaturingDate() {
		return manufaturingDate;
	}

	public void setManufaturingDate(LocalDate manufaturingDate) {
		this.manufaturingDate = manufaturingDate;
	}

	public int getUseBeforeMonths() {
		return useBeforeMonths;
	}

	public void setUseBeforeMonths(int useBeforeMonths) {
		this.useBeforeMonths = useBeforeMonths;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate localDate) {
		this.expiryDate = localDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", weight=" + weight + ", price=" + price
				+ ", manufaturingDate=" + manufaturingDate + ", useBeforeMonths=" + useBeforeMonths + ", expiryDate="
				+ expiryDate + "]";
	}
	
}
