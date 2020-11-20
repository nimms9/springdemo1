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
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.utils.DBUtils;


@Repository
public class OrganizationDAOImpl implements OrganizationDAO {
	
	@Autowired
	DBUtils dbUtils;
	
	
	@Override
	public String addOrganization(Organization org) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String insertOrg = "insert into Organization (id,name,address) values(?,?,?)";
		try {
			 preparedStatement = connection.prepareStatement(insertOrg);
			 preparedStatement.setLong(1, org.getId());
			 preparedStatement.setString(2, org.getName());
			 preparedStatement.setString(3, org.getAddress());
			 
			 
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
	public String updateOrganization(Organization org) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updateOrg = "update Organization set name=?,address=? where id=?";
		try {
			 preparedStatement = connection.prepareStatement(updateOrg);
			 
			 preparedStatement.setString(1, org.getName());
			 preparedStatement.setString(2, org.getAddress());
			 preparedStatement.setLong(3, org.getId());
			 
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
	public String deleteOrganization(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deleteOrg = "delete from Organization where id=?";
		try {
			 preparedStatement = connection.prepareStatement(deleteOrg);
			 
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
	public Optional<Organization> findById(long id) {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Organization organ=null;
		String query = "select * from Organization where id=?";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 preparedStatement.setLong(1, id);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 if(resultSet.next()) {
				 organ=new Organization();
				 organ.setId(resultSet.getLong("id"));
				 organ.setName(resultSet.getString("name"));
				 organ.setAddress(resultSet.getString("address"));
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
		return Optional.of(organ);
	}

	@Override
	public Optional<List<Organization>> getOrganization() {
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Organization organ=null;
		List<Organization> org=new ArrayList<Organization>();
		String query = "select * from Organization";
		try {
			 preparedStatement = connection.prepareStatement(query);
			 
			 
			 resultSet = preparedStatement.executeQuery();
			 
			 while(resultSet.next()) {
				 organ=new Organization();
				 organ.setId(resultSet.getLong("id"));
				 
				 organ.setName(resultSet.getString("name"));
				
				 organ.setAddress(resultSet.getString("address"));
				 org.add(organ);
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
		return Optional.of(org);
	}

	

}
