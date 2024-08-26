package com.spring.springcore.EmployeeManagement.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.springcore.EmployeeManagement.entities.Employee;

@Component("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public int insertEmployee(Employee employee) {
		
		int r = this.jdbcTemplate.update(Query.insert,employee.getId(), employee.getName(),employee.getEmail(),employee.getSalary());
		return r;
	}
	
	@Override
	public int createTable() {
		int r = this.jdbcTemplate.update(Query.createTable);
		return 0;
	}

	@Override
	public int updateEmployee(int id, String s) {
		try {
			int r = this.jdbcTemplate.update(Query.update, s, id);
			return r;
		}
		catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
		
	}

	@Override
	public int deleteEmployee(int id) {
		int r = this.jdbcTemplate.update(Query.delete,id);
		return r;
	}

	@Override
	public Employee getEmployee(int eId) {
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return jdbcTemplate.query(Query.select, new RowMapperImpl());
	}

	@Override
	public int insertBackupEmp(Employee emp) {
		return jdbcTemplate.update(Query.insertBackup,emp.getId(), emp.getName(), emp.getEmail(), emp.getSalary());
	}

	
	





	

	

}
