<%@page import="com.springmvc2.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<h1>Products List</h1>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
			<th>Actions</th>
		</tr>
		
		<!-- Using JSP to get the products list from the model -->
		<%
			List<Product> products = (List<Product>) request.getAttribute("products");
		
			if(products != null) {
				
			
			// Iterating through the list of products with a loop
			for(Product product : products) {
	
		%>
		
		<tr>
			<td><%= product.getId() %></td>
			<td><%= product.getName() %></td>
			<td><%= product.getDescription() %></td>
			<td><%= product.getPrice() %></td>
			<td>
				<a href="update?id=<%= product.getId() %>">Edit</a>
				<a href="delete?id=<%= product.getId() %>">Delete</a>
			</td>
		</tr>
		
		<%
				}	
			}
		%>
		
	</table>
	<a href="add">Add Product</a>
</body>
</html>
