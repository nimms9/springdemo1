package com.tcs.employeeapp.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;

public interface DepartmentDAO {
	
	public String addDepartment(Department dept);
	public String updateDepartment(Department dept);
	public String deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartment();
	public Optional<List<Department>> findByOrganizationId(long id);
	
	

}
