package com.ims.inventorymanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ims.inventorymanagementsystem.entity.Product;

public interface InventoryService {
	public Product itemInitialization(Product product);
	public LocalDate calculateExpiryDate(int id);
	public String removeExpiredItems();
	public List<Product> sortItems();
	public List<Product> applyDiscounts();
	public ResponseEntity<Product> searchItem(int id);
}
