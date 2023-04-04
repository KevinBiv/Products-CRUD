package com.springmvc2.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc2.model.Product;

@Repository
public class ProductDAO implements ProductDAOInterface {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> getAllProdcuts() {
		String sql = "SELECT * FROM PRODUCTS";
		List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
		return products;
	}

	@Override
	public Product getProduct(int id) {
		String sql = "SELECT * FROM PRODUCTS WHERE id = ?";
		@SuppressWarnings("deprecation")
		Product product = jdbcTemplate.queryForObject(sql, new Object[] {id}, new ProductRowMapper());
		return product;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO PRODUCTS VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE PRODUCTS SET name = ?, description = ?, price = ? WHERE id = ?";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getId());
	}

	@Override
	public void deleteProduct(int id) {
		String sql = "DELETE FROM PRODUCTS WHERE id = ?	";
		jdbcTemplate.update(sql, id);
	}
	
}
