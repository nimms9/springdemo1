package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.dao.DepartmentDAO;
import com.tcs.employeeapp.dao.DepartmentDAOImpl;
import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	private DepartmentDAO deptdao;
	
	
	@Override
	public String addDepartment(Department dept) {
		// TODO Auto-generated method stub
		Department dept2=null;
		try {
			dept2=departmentRepository.save(dept);
			return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		Optional<Department> dept4=null;
		try {
			dept4=departmentRepository.findById(dept.getId());
			if(dept4.isPresent()) {
				dept4.get().setName(dept.getName());
				departmentRepository.save(dept4.get());
				return "success";
			}
			return "fail";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public void deleteDepartment(long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		
	}

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartment() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findAll());
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findByOrganizationId(id));
	}

}
