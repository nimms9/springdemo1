package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Organization;

public interface OrganizationService {
	
	public String addOrganization(Organization org);
	public String updateOrganization(Organization org);
	public String deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	public Optional<List<Organization>> getOrganization();
	

}
