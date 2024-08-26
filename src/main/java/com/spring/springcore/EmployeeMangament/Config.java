package com.spring.springcore.EmployeeMangament;

import java.beans.BeanProperty;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring.springcore.EmployeeManagement.Dao")
public class Config {
	
	@Bean
	public DriverManagerDataSource getDataSourse() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/springjdbc", "root", "78607860");
		return driverManagerDataSource;
	}
	
	@Bean
	public JdbcTemplate getTempate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSourse());
		return jdbcTemplate;
	}

}
