package com.tcs.employeeapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employeeapp.config.DBConfig;
import com.tcs.employeeapp.model.Organization;
import com.tcs.employeeapp.service.OrganizationServiceImpl;
import com.tcs.employeeapp.service.OrganizationService;



public class Main3 {

	public static void main(String[] args) throws IOException,NumberFormatException {
		 InputStreamReader in=new InputStreamReader(System.in);
	     BufferedReader br = new BufferedReader(in);
	     
	     int ch;
	     
	     while(true) {
	    	 AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DBConfig.class);
		     OrganizationService orgService = context.getBean(OrganizationService.class);
	    	 System.out.println("Enter 1 to add organization");
		     System.out.println("Enter 2 to update organization");
		     System.out.println("Enter 3 to delete organization");
		     System.out.println("Enter 4 to search by id");
		     System.out.println("Enter 5 to get all organization details");
		     System.out.println("Enter 7 to exit  the application");
		     System.out.println("Every id you enter should be unique!");
		     ch=Integer.parseInt(br.readLine());
			     switch(ch) {
			     
			     	case 1: 
				     		System.out.println("Enter id:");
				     		long id=Long.parseLong(br.readLine());
				     		System.out.println("Enter organization name:");
				     		String name=br.readLine();
				     		System.out.println("Enter  organization address:");
				     		String address=br.readLine();
			     		
				     		Organization org=new Organization(id,name,address,Collections.emptyList(),Collections.emptyList());
						
				     		String result = orgService.addOrganization(org);
						
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
					 		 System.out.println("Enter address to change: ");
					 		 String add1 = br.readLine();
					 		 
		     				 
		     				 Organization orgs=new Organization();
		     				 orgs.setId(id1);
		     				 orgs.setName(pos);
		     				 orgs.setAddress(add1);
			     			
		     				String result1 =orgService.updateOrganization(orgs);
				
		     				if("success".equals(result1)) {
					
		     					System.out.println("record updated successfully");
		     				}
				
		     				else {
		     					System.out.println("problem");
		     				}
		     				break;
		     				
			     	case 3: System.out.println("Enter id:");
			     			long id2=Long.parseLong(br.readLine());
			     			String result2=orgService.deleteOrganization(id2);
			     			
			     			if("success".equals(result2)) {
			     				
		     					System.out.println("record deleted successfully");
		     				}
				
		     				else {
		     					System.out.println("problem");
		     				}
			     			break;
			     			
			     	case 4: System.out.println("Enter id:");
			     			long id3=Long.parseLong(br.readLine());
			     			Optional<Organization> result3=orgService.findById(id3);
			     			
			     			if(result3.isPresent()) {
			     				Organization orgs1=result3.get();
			     				System.out.println(orgs1);
			     			}
			     			else {
			     				System.out.println("Organization not found");
			     			}
			     			break;
			     			
			     	case 5: Optional<List<Organization>> result4=orgService.getOrganization();
			     			
			     			if(result4.isPresent()) {
			     				List<Organization> lorg=result4.get();
			     				lorg.forEach(s1->System.out.println(s1));
			     			}
			     			else {
			     				System.out.println("Departments not available");
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
