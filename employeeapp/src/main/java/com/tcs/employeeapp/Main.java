package com.tcs.employeeapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employeeapp.config.DBConfig;
import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.model.Employee;
import com.tcs.employeeapp.service.EmployeeServiceImpl;
import com.tcs.employeeapp.service.DepartmentService;
import com.tcs.employeeapp.service.EmployeeService;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 InputStreamReader in=new InputStreamReader(System.in);
	     BufferedReader br = new BufferedReader(in);
	     
	     
	     int ch;
	     
	     while(true) {
	    	 AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DBConfig.class);
		     EmployeeService employeeService = context.getBean(EmployeeService.class);
		     DepartmentService deptService = context.getBean(DepartmentService.class);
	    	 System.out.println("Enter 1 to add employee");
		     System.out.println("Enter 2 to update employee");
		     System.out.println("Enter 3 to delete employee");
		     System.out.println("Enter 4 to search by id");
		     System.out.println("Enter 5 to get all employee details");
		     System.out.println("Enter 6 to find employee by organization id");
		     System.out.println("Enter 7 to exit  the application");
		     System.out.println("Every id you enter should be unique!");
		     ch=Integer.parseInt(br.readLine());
			     switch(ch) {
			     
			     	case 1: 
				     		System.out.println("Enter id:");
				     		long id=Long.parseLong(br.readLine());
				     		System.out.println("Enter organization id:");
				     		long orgId=Long.parseLong(br.readLine());
				     		System.out.println("Enter department id:");
				     		long deptId=Long.parseLong(br.readLine());
				     		System.out.println("Enter employee name:");
				     		String name=br.readLine();
				     		System.out.println("Enter age:");
				     		int age=Integer.parseInt(br.readLine());
				     		System.out.println("Enter position:");
				     		String position=br.readLine();
				     		
				     		
				     		Hibernate.initialize(deptService.getDepartment());
				     		Optional<List<Department>> result8=deptService.getDepartment();
				     		List<Department> ldept =null;
			     			
			     			if(result8.isPresent()) {
			     				ldept=result8.get();
			     				 //for (int i = 0; i < ldept.size(); i++) {
			     		         //   System.out.println(ldept.get(i));
			     		       // }
			     			}
			     			else {
			     				System.out.println("Departments not available");
			     			}
				     		
				     		
				     		
				     		
				     		
				     		Employee emp=new Employee(id,orgId,deptId,name,age,position,ldept.get(0));
						
				     		String result = employeeService.addEmployee(emp);
						
				     		if("success".equals(result)) {
							
				     			System.out.println("record added successfully");
				     		}
						
				     		else {
				     			System.out.println("problem");
				     		}
				     		break;
				     		
				     		
			     	case 2: 
			     			 System.out.println("Enter id:");
		     				 long id1=Long.parseLong(br.readLine());
		     				 System.out.println("Enter position to change: ");
					 		 String pos = br.readLine();
					 		 System.out.println("Enter age to change: ");
					 		 int ages = Integer.parseInt(br.readLine());
		     				 
		     				 Employee emps=new Employee();
		     				 emps.setAge(ages);
		     				 emps.setId(id1);
		     				 emps.setPosition(pos);
			     			
		     				String result1 = employeeService.updateEmployee(emps);
				
		     				if("success".equals(result1)) {
					
		     					System.out.println("record updated successfully");
		     				}
				
		     				else {
		     					System.out.println("problem");
		     				}
		     				break;
		     				
			     	case 3: System.out.println("Enter id:");
			     			long id2=Long.parseLong(br.readLine());
			     			employeeService.deleteEmployee(id2);
			     			break;
			     			
			     	case 4: System.out.println("Enter id:");
			     			long id3=Long.parseLong(br.readLine());
			     			Optional<Employee> result3=employeeService.findById(id3);
			     			
			     			if(result3.isPresent()) {
			     				Employee emp1=result3.get();
			     				System.out.println(emp1);
			     			}
			     			else {
			     				System.out.println("employee not found");
			     			}
			     			break;
			     			
			     	case 5: Optional<List<Employee>> result4=employeeService.getEmployees();
			     			
			     			if(result4.isPresent()) {
			     				List<Employee> lemp=result4.get();
			     				lemp.forEach(s1->System.out.println(s1));
			     				
			     				 
			     			}
			     			else {
			     				System.out.println("employees not available");
			     			}
			     			break;
			     			
			     	case 6: System.out.println("Enter organization id:");
			     			long orgId1=Long.parseLong(br.readLine());
			     			Optional<List<Employee>> result5=employeeService.findByOrganizationId(orgId1);
			     			
			     			if(result5.isPresent()) {
			     				List<Employee> lemp1=result5.get();
			     				 for (int i = 0; i < lemp1.size(); i++) {
			     		            System.out.println(lemp1.get(i));
			     		        }
			     			}
			     			else {
			     				System.out.println("employees not available");
			     			}
			     			break;
			     			
			     	case 7: System.out.println("Exiting the application");
			     			System.exit(0);
			     			
			     	default: System.out.println("Wrong choice!");
			     }
			     
			     context.close();
	     }
	     

	}

}
