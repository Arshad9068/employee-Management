package com.spring.springcore.EmployeeManagement.Dao;

public class Query {
	
	static String createTable = "create table EmployeeBackup(Id int(50) Primary key, Name varchar(50), Email varchar(100), Salary varchar(50))";
	static String insert = "insert into employee(Id, Name, Email, Salary) values(?,?,?,?)";
	static String insertBackup = "insert into employeebackup(Id, Name, Email, Salary) values(?,?,?,?)";
	static String update = "update employee set Email=? where Id=?";
	static String delete = "delete from employee where Id=?";
	static String select = "select * from employee";
}
