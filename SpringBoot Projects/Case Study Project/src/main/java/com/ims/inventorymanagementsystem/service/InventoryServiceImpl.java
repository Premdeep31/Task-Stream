package com.ims.inventorymanagementsystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ims.inventorymanagementsystem.dao.ProductDao;
import com.ims.inventorymanagementsystem.entity.Product;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	private ProductDao productDao;

	// add product
	@Override
	public Product itemInitialization(Product product) {
		productDao.save(product);
		
		return product;
	}

	// calculate expiry date
	@Override
	public LocalDate calculateExpiryDate(int id) {
		ResponseEntity<Product> entity = searchItem(id);
		Product product = entity.getBody();
		LocalDate expiryDate = product.getManufaturingDate();
		
		return expiryDate.plusMonths(product.getUseBeforeMonths());
	}

	// delete expired items 
	@Override
	public String removeExpiredItems() {
		List<Product> products = productDao.findAll();
		
		products.stream()
		.filter(product -> calculateExpiryDate(product.getId()).isBefore(LocalDate.now()))
		.forEach(product -> productDao.deleteById(product.getId()));
		
		return "Expired Items removed successfully";
	}

	// get items sorted by expired date in descending order
	@Override
	public List<Product> sortItems() {
		List<Product> products = productDao.findAll();
		
		List<Product> sortedProducts = products.stream()
				.map(product -> {
					product.setExpiryDate(calculateExpiryDate(product.getId()));
					return product;
				})
				.sorted((p1, p2) -> p2.getExpiryDate().compareTo(p1.getExpiryDate()))
				.collect(Collectors.toList());
		
		return sortedProducts;
	}

	// // get discount on items that will expire within 6 months
	@Override
	public List<Product> applyDiscounts() {
		List<Product> products = productDao.findAll();
		
		List<Product> discountProducts = products.stream()
				.filter(product -> {
					Period period = Period.between(LocalDate.now(), calculateExpiryDate(product.getId()));
					System.out.println(product.getId() + " -> " + period.getMonths());
					return (period.getMonths() < 7 && period.getMonths() >= 0);
				})
				.map(product -> {
					product.setPrice((product.getPrice() * 0.8));
					return product;
				})
				.collect(Collectors.toList());
		
		return discountProducts;
	}

	// search item by id
	@Override
	public ResponseEntity<Product> searchItem(int id) {
		Optional<Product> product = productDao.findById(id);
		
		if (product.isPresent())
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
