package com.spring.springcore.EmployeeManagement.Dao;

import java.util.List;

import com.spring.springcore.EmployeeManagement.entities.Employee;

public interface EmployeeDao {
	
	public int createTable();
	public int insertEmployee(Employee employee);
	public int insertBackupEmp(Employee emp);
	public int updateEmployee(int id, String s);
	public int deleteEmployee(int id);
	public Employee getEmployee(int eId);
	public List<Employee> getAllEmployee();

}
