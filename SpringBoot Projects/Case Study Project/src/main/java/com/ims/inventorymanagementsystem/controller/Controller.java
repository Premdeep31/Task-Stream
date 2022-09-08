package com.ims.inventorymanagementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ims.inventorymanagementsystem.entity.Product;
import com.ims.inventorymanagementsystem.service.InventoryService;

@RestController
public class Controller {
	@Autowired
	InventoryService inventoryService;
	
	// initialize item
	@PostMapping("/product")
	private Product itemInitialization(@RequestBody Product product) {
		return inventoryService.itemInitialization(product);
	}
	
	// search item by id
	@GetMapping("/product/{id}")
	private ResponseEntity<Product> searchItem(@PathVariable int id) {
		return inventoryService.searchItem(id);
	}
	
	// calculate expiry-date of an item by item-id
	@GetMapping("/product/expired/{id}")
	private LocalDate calculateExpiryDate(@PathVariable int id) {
		return inventoryService.calculateExpiryDate(id);
	}
	
	// delete expired items from database
	@GetMapping("/product/expired")
	private String removeExpiredItems() {
		return inventoryService.removeExpiredItems();
	}
	
	// get items sorted by expired date in descending order
	@GetMapping("/product/expired/sort")
	private List<Product> sortItems() {
		return inventoryService.sortItems();
	}
	
	// get discount on items that will expire within 6 months
	@GetMapping("/product/expired/discount")
	private List<Product> applydisounts() {
		return inventoryService.applyDiscounts();
	}
}
