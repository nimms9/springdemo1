package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.dao.EmployeeDAO;
import com.tcs.employeeapp.dao.EmployeeDAOImpl;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeDAO employeeDao;

	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp2=null;
		try {
		emp2=employeeRepository.save(employee);
		return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}

	@Override
	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Optional<Employee> emp3=null;
		try {
		emp3=employeeRepository.findById(emp.getId());
		if(emp3.isPresent()) {
			emp3.get().setAge(emp.getAge());
			emp3.get().setPosition(emp.getPosition());
			employeeRepository.save(emp3.get());
			return "success";
		}
		
		return "fail";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteById(id);
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(employeeRepository.findAll());
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(employeeRepository.findByOrganizationId(id));
	}

}
