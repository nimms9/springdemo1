package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;

public interface DepartmentService {
	
	public String addDepartment(Department dept);
	public String updateDepartment(Department dept);
	public void deleteDepartment(long id);
	public Optional<Department> findById(long id);
	public Optional<List<Department>> getDepartment();
	public Optional<List<Department>> findByOrganizationId(long id);
	

}
