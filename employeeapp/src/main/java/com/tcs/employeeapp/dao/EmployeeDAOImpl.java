package com.tcs.employeeapp.dao;

import java.io.*;
import java.sql.Connection;
import com.tcs.employeeapp.utils.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employeeapp.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	DBUtils dbUtils;
	
	
	
	@Override
	public String addEmployee(Employee employee) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String insertEmployee = "insert into Employee (id,organizationId,departmentId,name,age,position) values(?,?,?,?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertEmployee);
			 preparedStatement.setLong(1, employee.getId());
			 preparedStatement.setLong(2, employee.getOrganizationId());
			 preparedStatement.setLong(3, employee.getDepartmentId());
			 preparedStatement.setString(4, employee.getName());
			 preparedStatement.setInt(5, employee.getAge());
			 preparedStatement.setString(6, employee.getPosition());
			 
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String updateEmployee(Employee emp)  {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updateEmployee = "update Employee set position=?,age=? where id=?";
		try {
			 preparedStatement = connection.prepareStatement(updateEmployee);
			 
			 preparedStatement.setString(1, emp.getPosition());
			 preparedStatement.setInt(2, emp.getAge());
			 preparedStatement.setLong(3, emp.getId());
			 
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String deleteEmployee(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deleteEmployee = "delete from Employee where id=?";
		try {
			 preparedStatement = connection.prepareStatement(deleteEmployee);
			 
			 preparedStatement.setLong(1, id);
			 
			 result = preparedStatement.executeUpdate();
			 
			 if(result>0)
			 {
				 connection.commit();
				 return "success";
				 
			 }
			 else {
				 return "fail";
			 }
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
	}

	@Override
	public Optional<Employee> findById(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		String query = "select * from Employee where id=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, id);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 if(resultSet.next()) {
				 employee=new Employee();
				 employee.setId(resultSet.getLong("id"));
				 employee.setOrganizationId(resultSet.getLong("organizationId"));
				 employee.setDepartmentId(resultSet.getLong("departmentId"));
				 employee.setName(resultSet.getString("name"));
				 employee.setAge(resultSet.getInt("age"));
				 employee.setPosition(resultSet.getString("position"));
			 }
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
			
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(employee);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		List<Employee> emp=new ArrayList<Employee>();
		String query = "select * from Employee";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 employee=new Employee();
				 employee.setId(resultSet.getLong("id"));
				 employee.setOrganizationId(resultSet.getLong("organizationId"));
				 employee.setDepartmentId(resultSet.getLong("departmentId"));
				 employee.setName(resultSet.getString("name"));
				 employee.setAge(resultSet.getInt("age"));
				 employee.setPosition(resultSet.getString("position"));
				 emp.add(employee);
			 }
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
			
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(emp);
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		List<Employee> emp=new ArrayList<Employee>();
		String query = "select * from Employee where organizationId=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, id);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 employee=new Employee();
				 employee.setId(resultSet.getLong("id"));
				 employee.setOrganizationId(resultSet.getLong("organizationId"));
				 employee.setDepartmentId(resultSet.getLong("departmentId"));
				 employee.setName(resultSet.getString("name"));
				 employee.setAge(resultSet.getInt("age"));
				 employee.setPosition(resultSet.getString("position"));
				 emp.add(employee);
			 }
			 
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
			
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(emp);
	}

}
