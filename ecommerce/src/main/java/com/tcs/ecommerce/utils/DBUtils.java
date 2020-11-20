package com.tcs.ecommerce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//whenever we will come across the utility classes then we should mark these classes with @Component
//singleton
@Component
public class DBUtils {
	
	@PostConstruct
	public void init() {
		System.out.println("init called");
		
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy called");
	}
	
	/*public static Connection getConnection() {
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tcs?useSSL=false","root","y13cs958");
			
			connection.setAutoCommit(false);
			return connection;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	
	@Autowired
	DataSource dataSource;
	public  Connection getConnection() {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			connection.setAutoCommit(false);
			return connection;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
//		Connection connection=null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tcs?useSSL=false","root","y13cs958");
//			
//			connection.setAutoCommit(false);
//			return connection;
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		return connection;
	}
	
	public  void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
