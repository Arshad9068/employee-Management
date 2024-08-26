package com.spring.springcore.EmployeeManagement.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.springcore.EmployeeManagement.entities.Employee;

public class RowMapperImpl implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setEmail(rs.getString(3));
		emp.setSalary(rs.getInt(4));
		return emp;
	}

}
