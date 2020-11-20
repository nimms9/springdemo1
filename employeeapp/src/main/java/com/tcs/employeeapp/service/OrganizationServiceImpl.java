package com.tcs.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeapp.dao.OrganizationDAO;
import com.tcs.employeeapp.dao.OrganizationDAOImpl;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	@Autowired
	private OrganizationDAO orgdao;
	

	@Override
	public String addOrganization(Organization org) {
		// TODO Auto-generated method stub
		Organization org1=null;
		try {
			org1=organizationRepository.save(org);
			return "success";
		} catch(Exception e) {
			return "fail";
		}
	}

	@Override
	public String updateOrganization(Organization org) {
		// TODO Auto-generated method stub
		return orgdao.updateOrganization(org);
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return orgdao.deleteOrganization(id);
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return orgdao.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganization() {
		// TODO Auto-generated method stub
		return orgdao.getOrganization();
	}

	

}
