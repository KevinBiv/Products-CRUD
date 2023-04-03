package com.springmvc2.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc2.dao.ProductDAO;

public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProdcuts();
	}

	@Override
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);		
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}

	

}
