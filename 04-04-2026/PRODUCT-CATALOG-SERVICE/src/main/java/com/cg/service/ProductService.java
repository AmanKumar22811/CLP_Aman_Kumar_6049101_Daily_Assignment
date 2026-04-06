package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(Long id);

	public Product saveProduct(Product product);
}
