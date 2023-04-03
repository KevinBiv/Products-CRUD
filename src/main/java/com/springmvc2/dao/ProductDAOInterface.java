package com.springmvc2.dao;

import java.util.List;

import com.springmvc2.model.Product;

public interface ProductDAOInterface {
	public List<Product> getAllProdcuts();
	public Product getProduct(int id);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
}
