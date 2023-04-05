package com.springmvc2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc2.model.Product;
import com.springmvc2.model.ProductService;
import com.springmvc2.model.ProductServiceImplementation;

@Controller
public class MainController {
	
	@Autowired
	private ProductServiceImplementation productService;
	
	@RequestMapping("/")
	public String productsList(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/add")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "add";
	}
	
	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "update";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
		productService.updateProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String deleteForm(@RequestParam("id") int id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "delete";
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProduct(@ModelAttribute("product") Product product) {
		productService.deleteProduct(product.getId());
		return "redirect:/";
	}
}
