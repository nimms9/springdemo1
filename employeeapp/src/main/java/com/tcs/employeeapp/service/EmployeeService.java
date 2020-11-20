package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Employee;

public interface EmployeeService {
	
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee emp);
	public void deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganizationId(long id);
	

}
