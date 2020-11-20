package com.tcs.employeeapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employeeapp.config.DBConfig;
import com.tcs.employeeapp.model.Department;
import com.tcs.employeeapp.service.DepartmentServiceImpl;
import com.tcs.employeeapp.service.DepartmentService;



public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		 InputStreamReader in=new InputStreamReader(System.in);
	     BufferedReader br = new BufferedReader(in);
	     
	     int ch;
	     
	     while(true) {
	    	 AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DBConfig.class);
		     DepartmentService deptService = context.getBean(DepartmentService.class);
	    	 System.out.println("Enter 1 to add department");
		     System.out.println("Enter 2 to update department");
		     System.out.println("Enter 3 to delete department");
		     System.out.println("Enter 4 to search by id");
		     System.out.println("Enter 5 to get all department details");
		     System.out.println("Enter 6 to find department by organization id");
		     System.out.println("Enter 7 to exit  the application");
		     System.out.println("Every id you enter should be unique!");
		     ch=Integer.parseInt(br.readLine());
			     switch(ch) {
			     
			     	case 1: 
				     		System.out.println("Enter id:");
				     		long id=Long.parseLong(br.readLine());
				     		System.out.println("Enter organization id:");
				     		long orgId=Long.parseLong(br.readLine());
				     		System.out.println("Enter employee name:");
				     		String name=br.readLine();
				     		
			     		
				     		Department dept=new Department(id,orgId,name,null);
						
				     		String result = deptService.addDepartment(dept);
						
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
		     				 System.out.println("Enter name to change: ");
					 		 String pos = br.readLine();
					 		 
		     				 
		     				 Department deps=new Department();
		     				 deps.setId(id1);
		     				 deps.setName(pos);
			     			
		     				String result1 =deptService.updateDepartment(deps);
				
		     				if("success".equals(result1)) {
					
		     					System.out.println("record updated successfully");
		     				}
				
		     				else {
		     					System.out.println("problem");
		     				}
		     				break;
		     				
			     	case 3: System.out.println("Enter id:");
			     			long id2=Long.parseLong(br.readLine());
			     			deptService.deleteDepartment(id2);
			     			break;
			     			
			     	case 4: System.out.println("Enter id:");
			     			long id3=Long.parseLong(br.readLine());
			     			Optional<Department> result3=deptService.findById(id3);
			     			
			     			if(result3.isPresent()) {
			     				Department dept1=result3.get();
			     				System.out.println(dept1);
			     			}
			     			else {
			     				System.out.println("Department not found");
			     			}
			     			break;
			     			
			     	case 5: Optional<List<Department>> result4=deptService.getDepartment();
			     			
			     			if(result4.isPresent()) {
			     				List<Department> ldept=result4.get();
			     				ldept.forEach(s1->System.out.println(s1));
			     			}
			     			else {
			     				System.out.println("Departments not available");
			     			}
			     			break;
			     			
			     	case 6: System.out.println("Enter organization id:");
			     			long orgId1=Long.parseLong(br.readLine());
			     			Optional<List<Department>> result5=deptService.findByOrganizationId(orgId1);
			     			
			     			if(result5.isPresent()) {
			     				List<Department> ldept1=result5.get();
			     				ldept1.forEach(s2->System.out.println(s2));
			     			}
			     			else {
			     				System.out.println("departments not available");
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
