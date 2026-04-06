package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> productList = repo.findById(id);
		return productList.isPresent() ? productList.get() : null;

	}

	@Override
	public Product saveProduct(Product product) {
		return repo.save(product);
	}

}
