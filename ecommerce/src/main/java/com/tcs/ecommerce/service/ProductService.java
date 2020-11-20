package com.tcs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.tcs.ecommerce.model.Product;


public interface ProductService {
	
	public String createProduct(Product product);
	public Optional<Product> getProductById(int id);
	public void deleteProduct(int id);
	public Optional<List<Product>> getProducts();
	public Optional<List<Product>> getProductsByCategory(String catName);
	public Optional<List<Product>> getProductsByPrice(float priceValue);
	public Optional<List<Product>> getProductsByCategoryPrice(String category, float price);
	public Optional<List<Product>> getProductNameLike(String productName);
	
}
