package com.spring.springcore.EmployeeMangament;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.springcore.EmployeeManagement.Dao.EmployeeDao;
import com.spring.springcore.EmployeeManagement.Dao.EmployeeDaoImpl;
import com.spring.springcore.EmployeeManagement.entities.Employee;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        
        EmployeeDao employeeDao = context.getBean("EmployeeDao",EmployeeDaoImpl.class);
        char c;
              
        do{
            System.out.println("\nEmployee Management\nId's of all Employees");
            List<Employee> totalEmp = employeeDao.getAllEmployee();
            int count=0;
        	Iterator<Employee> it1 = totalEmp.iterator();
        	while(it1.hasNext()) {
        		System.out.println(it1.next().getId());
        		count++;
        	}
        	System.out.println("Total Employees are... "+count);
            System.out.println("\n1: Create New Employee \n2: Read \n3: Update \n4: Delete \n5: Create table");
            Scanner sc = new Scanner(System.in);
            int Choice = sc.nextInt();
            sc.nextLine();
            switch (Choice){
                case 1:
//                	To Insert new Employee
                	System.out.println("Enter the employee Id");
                	int id = sc.nextInt();
                	sc.nextLine();
                	boolean frag=true;
                	for(Employee emp :totalEmp) {
                		if(id==emp.getId()) {
                			System.out.println("This Id is allready contains another employee");
                			frag = false;
                			break;
                		}
                	}
                	if(frag) {
                		Employee newEmployee = new Employee();            		
            			newEmployee.setId(id);
            			System.out.println("Enter the Employee Name");
            			newEmployee.setName(sc.nextLine());
            			System.out.println("Enter the Employee Email");
            			newEmployee.setEmail(sc.nextLine());
            			System.out.println("Enter the Employee Salary");
            			newEmployee.setSalary(sc.nextInt());
            			sc.nextLine();
            			employeeDao.insertEmployee(newEmployee);
                	}
                	break;

                case 2:
//                	To get individual employee
                	List<Employee> employees = employeeDao.getAllEmployee();
                	System.out.println("enter the id ");
                	int eid = sc.nextInt();
                	sc.nextLine();
                	boolean temp = false;
                	for(Employee emp : employees ){
                		if(emp.getId()==eid) {
                			System.out.println(emp);
                			temp = true;
                			break;
                		}
                	}
                	if(!temp) {
                		System.out.println("this employee does not exists");
                	}
                	
//                	TO get All Employee
                	System.out.println("If you want to get all Employee than press 'Y' or 'y'");
                	char chAll = sc.next().charAt(0);
                	if(chAll=='y' || chAll=='Y') {
                		Iterator<Employee> it = employees.iterator();
                    	while(it.hasNext()) {
                    		System.out.println(it.next());
                	}
                	
                	}
                    break;

                case 3:
//                	To Update any detail of a Employee
                    System.out.println("Enter the Id of Employee");
                    int eId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("what do you want to change? /n1. Name/n.2 Email/n3. Salary");
                    int ch1 = sc.nextInt(); 
                    sc.nextLine();                  
                    switch(ch1) {
                    case 1:
                    	System.out.println("Enter The New Name");
                    	String newName = sc.nextLine(); 
                    	int r1 = employeeDao.updateEmployee(eId, newName);
                    	System.out.println("Name Succesfully updated"+r1);
                    	break;
                    case 2:
                    	System.out.println("Enter The New Email");
                    	String newEmail = sc.nextLine(); 
                    	int r2 = employeeDao.updateEmployee(eId, newEmail);
                    	System.out.println("Email Succesfully updated"+r2);
                    	break;
                    case 3:
                    	System.out.println("Enter The New Salary");
                    	sc.next();
                    	String newSalary = sc.nextLine(); 
                    	int r3 = employeeDao.updateEmployee(eId, newSalary);
                    	System.out.println("Salary Succesfully updated"+r3);
                    	break;
                    default:
                    	System.out.println("Wrong Press");
                    	break;
                    }                                     
                case 4:
//                	To delete any Employee 
                	System.out.println("Enter the employee Id");
                	int delId = sc.nextInt();
                	sc.nextLine();
                	boolean frag1=false;
                	for(Employee emp :totalEmp) {
                		if(delId==emp.getId()) {
                			int r4 = employeeDao.deleteEmployee(delId);
                            if(r4!=0) {
                            	System.out.println("Employee Id "+delId+" Succesfully deleted");
                            }
                            else {
                            	System.out.println("Something went Wrong to delete this");
                            }
                            frag1= false;
//                          This is For Backup of deleted Employee
                            employeeDao.insertBackupEmp(emp);
                            break;
                		}
                		else {
                			frag1 = true;
                		}
                	}
                    if(frag1) {
                    	System.out.println("This Id is not exists");
                    }
                    break;
                case 5:
//                	To Create Employee table
                	try {
                		employeeDao.createTable();
                    	System.out.println("Succesfully created..");
                	}
                	catch (Exception e) {
                		System.out.println(e);
						System.out.println("Already exists this table ");
					}
                	
                	break;
                	
                default:
                	System.out.println("Wrong Press");
                	break;
                
            }
            System.out.println("\nTry Again than press 'y' or 'Y'");
            c = sc.next().charAt(0);
        }while('y'==c || 'Y'==c);
        System.out.println("\n");
    }
}
            
                    	
 
                  

