package com.tcs.employeeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.utils.DBUtils;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	DBUtils dbUtils;
	
	@Override
	public String addDepartment(Department dept) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String insertDept = "insert into Department (id,organizationId,name) values(?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertDept);
			 preparedStatement.setLong(1, dept.getId());
			 preparedStatement.setLong(2, dept.getOrganizationId());
			 preparedStatement.setString(3, dept.getName());
			 
			 
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
	public String updateDepartment(Department dept) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updateDept = "update Department set name=? where id=?";
		try {
			 preparedStatement = connection.prepareStatement(updateDept);
			 
			 preparedStatement.setString(1, dept.getName());
			 preparedStatement.setLong(2, dept.getId());
			
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
	public String deleteDepartment(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deleteDept = "delete from Department where id=?";
		try {
			 preparedStatement = connection.prepareStatement(deleteDept);
			 
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
	public Optional<Department> findById(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		String query = "select * from Department where id=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, id);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 if(resultSet.next()) {
				 department=new Department();
				 department.setId(resultSet.getLong("id"));
				 department.setOrganizationId(resultSet.getLong("organizationId"));
				 department.setName(resultSet.getString("name"));
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
		return Optional.of(department);
	}

	@Override
	public Optional<List<Department>> getDepartment() {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> dept=new ArrayList<Department>();
		String query = "select * from Department";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 department=new Department();
				 department.setId(resultSet.getLong("id"));
				 department.setOrganizationId(resultSet.getLong("organizationId"));
				 
				 department.setName(resultSet.getString("name"));
				 
				 dept.add(department);
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
		return Optional.of(dept);
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> dept=new ArrayList<Department>();
		String query = "select * from Department where organizationId=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, id);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 department=new Department();
				 department.setId(resultSet.getLong("id"));
				 department.setOrganizationId(resultSet.getLong("organizationId"));
				 department.setName(resultSet.getString("name"));
				 dept.add(department);
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
		return Optional.of(dept);
	}

}
