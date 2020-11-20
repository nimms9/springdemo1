package com.tcs.employeeapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private long id;
	private long organizationId;
	private long departmentId;
	private String name;
	private int age;
	private String position;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_dept_id")
	private Department department;
	
	

}
