package com.springmvc2.model;

import java.util.List;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProduct(int id);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
}
