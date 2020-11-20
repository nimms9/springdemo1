package com.tcs.employeeapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="organization_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
	
	@Id
	@Column(name="organization_id")
	private long id;
	@Column(name="organization_name")
	private String name;
	private String address;
	@ElementCollection
	private List<Department> departments = new ArrayList<>();
	@ElementCollection
	private List<Employee> employees=new ArrayList<>();
	

}
