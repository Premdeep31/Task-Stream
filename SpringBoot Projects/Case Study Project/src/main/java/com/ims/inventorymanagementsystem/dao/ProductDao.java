package com.ims.inventorymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.inventorymanagementsystem.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
}
