package com.tcs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
// applying singleton
	// task for u
	//@Autowired
	//private ProductDAO productDao;
	
	@Autowired
	ProductRepository productRepository;
	
//	private static ProductService dao;
//	
//	private ProductServiceImpl() {
//		
//	}
//	
//	public static ProductService getInstance() {
//		
//		if(dao==null) {
//			dao=new ProductServiceImpl();
//			System.out.println("inside the if condition");
//			return dao;
//		}
//		return dao;
//	}
//ProductDAO productDao=ProductDAOImpl.getInstance();
	
	
	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		//return productDao.createProduct(product);
		Product product2 = null;
		try {
		product2 = productRepository.save(product);
		return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		//return  productDao.getProductById(id);
		return productRepository.findById(id);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findAll());
	}

	@Override
	public Optional<List<Product>> getProductsByCategory(String catName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByCategory(catName));
		
	}

	@Override
	public Optional<List<Product>> getProductsByPrice(float priceValue) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByPriceGreaterThan(priceValue));
	}

	@Override
	public Optional<List<Product>> getProductsByCategoryPrice(String category, float price) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByCategoryAndPriceLessThan(category, price));
	}

	@Override
	public Optional<List<Product>> getProductNameLike(String productName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findByProductNameLike(productName));
	}
	
	
	
	
	
	

}
