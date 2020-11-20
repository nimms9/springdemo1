package com.tcs.ecommerce;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;
import com.tcs.ecommerce.service.ProductServiceImpl;

public class MainSpring {

	public static void main(String[] args) {
		
		
		System.out.println("Before object creating");
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DBConfig.class);
		System.out.println("after context creation");
		
		
		//DataSource dataSource = context.getBean("mysqlDataSource",DataSource.class);
		//DataSource dataSource2=(DataSource) context.getBean("mysqlDataSource");
		
		
		//DataSource dataSource = context.getBean("getMySQLDataSource",DataSource.class);
		//DataSource dataSource2=(DataSource) context.getBean("getMySQLDataSource");
		
		//ProductService productService = context.getBean(ProductServiceImpl.class);
		//ProductService  productService2= context.getBean(ProductServiceImpl.class);
		ProductService productService = context.getBean(ProductService.class);
		ProductService  productService2= context.getBean(ProductService.class);
		Product product = new Product(35,"laptop_modified","i13 10th gen",1239.09f,"Mac_laptop");
		String result=productService.createProduct(product);
		System.out.println(result);
		System.out.println("after data source");
		
		//System.out.println(dataSource.equals(dataSource2));
		//System.out.println(dataSource==dataSource2);
		
		System.out.println(productService.equals(productService2));
		System.out.println(productService==productService2);
		
		/*if(productService.getProductById(11).isPresent()) {
			System.out.println("product exists ");
		}
		else {
			System.out.println("not available");
		}
		
		productService.deleteProduct(11);
		if(productService.getProducts().isPresent()) {
			System.out.println("products exists all");
		}
		else {
			System.out.println("nothing available");
		}*/
		
		Optional<List<Product>> optional=productService.getProductsByCategory("Mac_laptop");
		
		if(optional.isPresent()) {
			List<Product> products = optional.get();
			products.forEach(p->{
				System.out.println(p);
				});
		}
		else {
			System.out.println("problem");
		}
		
		context.close();
		System.out.println("destroying");

	}

}
