package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Employee;
import com.cognizant.dao.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees(){
	return employeeDao.getAllEmployee();
	}
	

}
